package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.dto.UserDto;
import com.rgnrk.pokerplanning.entity.User;
import com.rgnrk.pokerplanning.repository.UserRepository;
import com.rgnrk.pokerplanning.service.RegisterService;
import com.rgnrk.pokerplanning.util.UserDtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private UserDtoUtil userDtoUtil;
    private UserRepository userRepository;

    @Override
    public Optional<User> register(UserDto userDto) {
        var entity = userDtoUtil.toEntity(userDto);
        return Optional.of(userRepository.save(entity));
    }
}
