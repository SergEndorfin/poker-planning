package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.dto.security.UserDto;
import com.rgnrk.pokerplanning.entity.security.User;

import java.util.Optional;

public interface RegisterService {
    Optional<User> register(UserDto dto);
}
