package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.dto.security.LoggedUserDto;
import com.rgnrk.pokerplanning.dto.security.UserDto;
import com.rgnrk.pokerplanning.entity.security.User;
import com.rgnrk.pokerplanning.exception.UserNotFoundException;
import com.rgnrk.pokerplanning.repository.UserRepository;
import com.rgnrk.pokerplanning.service.LoginService;
import com.rgnrk.pokerplanning.util.secutiry.UserDtoUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final Logger logger;
    private final UserRepository userRepository;
    private final UserDtoUtil userDtoUtil;

    @Override
    public LoggedUserDto login(UserDto userDto) {
        var user = userRepository.findByEmail(userDto.getEmail());
        user.ifPresent(entity -> validate(userDto, entity));
        return userDtoUtil.toLoggedUserDto(user.get());
    }

    private void validate(UserDto userDto, User entity) {
        if (!isPasswordValid(userDto, entity)) {
            logger.debug("Credentials is not valid.");
            throw new UserNotFoundException();
        }
        userDto.setId(entity.getId());
    }

    private boolean isPasswordValid(UserDto userDto, User user) {
        return userDto.getPassword().equals(user.getPassword());
    }
}
