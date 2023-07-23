package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.dto.UserDto;
import com.rgnrk.pokerplanning.entity.User;

import java.util.Optional;

public interface RegisterService {
    Optional<User> register(UserDto dto);
}
