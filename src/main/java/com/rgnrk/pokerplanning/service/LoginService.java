package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.dto.LoggedUserDto;
import com.rgnrk.pokerplanning.dto.UserDto;
import com.rgnrk.pokerplanning.exception.UserNotFoundException;

public interface LoginService {
    LoggedUserDto login(UserDto dto) throws UserNotFoundException;
}
