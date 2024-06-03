package com.ao.mail.controller;

import com.ao.mail.DTO.EmailDTO;
import com.ao.mail.DTO.EmailFileDTO;
import com.ao.mail.service.IEmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class MailController {

    @Autowired
    private IEmailService iEmailService;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody @Valid EmailDTO emailDTO) {

        System.out.print("Mensaje Recibido" + emailDTO);
        iEmailService.sendEmail(
                emailDTO.getToUser(),
                emailDTO.getSubject(),
                emailDTO.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("status", "Enviado");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/sendMessageFile")
    public ResponseEntity<?> receiveRequestEmailWithFile(@ModelAttribute EmailFileDTO emailFileDTO) {
        try {
            String fileName = emailFileDTO.getFile().getOriginalFilename();
            Path path = Paths.get("src/mail/resources/files/"+fileName);
            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            File file = path.toFile();

            iEmailService.sendEmailWithFile(
                    emailFileDTO.getToUser(),
                    emailFileDTO.getSubject(),
                    emailFileDTO.getMessage(),
                    file
            );
            
            Map<String, String> response = new HashMap<>();
            response.put("status", "Enviado" );
            response.put("file", "Archivo "+ fileName);

            return ResponseEntity.ok(response);

        }catch(Exception e){
        throw new RuntimeException("Error al enviar el archivo. "+  e.getMessage());
        }
    }
}




