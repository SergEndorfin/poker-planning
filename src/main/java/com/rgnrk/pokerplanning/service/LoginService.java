package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.dto.security.LoggedUserDto;
import com.rgnrk.pokerplanning.dto.security.UserDto;
import com.rgnrk.pokerplanning.exception.UserNotFoundException;

public interface LoginService {
    LoggedUserDto login(UserDto dto) throws UserNotFoundException;
}
