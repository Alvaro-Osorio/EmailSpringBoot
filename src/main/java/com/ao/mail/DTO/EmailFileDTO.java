package com.ao.mail.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailFileDTO {

    private String[] toUser;
    private String subject;
    private String message;
    MultipartFile file;
}
