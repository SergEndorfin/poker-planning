package com.rgnrk.pokerplanning.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoggedInUserDto {

    private String name;
    private String email;
}
