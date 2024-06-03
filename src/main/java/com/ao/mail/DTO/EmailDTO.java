package com.ao.mail.DTO;

import com.ao.mail.advice.validation.anotation.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailDTO{

    private String[] toUser;

    @ValidEmail
    private String subject;

    private String message;
}
