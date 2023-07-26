package com.rgnrk.pokerplanning.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String password;
}
