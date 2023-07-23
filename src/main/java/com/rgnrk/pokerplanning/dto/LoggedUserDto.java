package com.rgnrk.pokerplanning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoggedUserDto {

    private Long id;
    private String username;
    private String email;
}
