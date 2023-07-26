package com.rgnrk.pokerplanning.util.secutiry;

import com.rgnrk.pokerplanning.dto.security.LoggedUserDto;
import com.rgnrk.pokerplanning.dto.security.UserDto;
import com.rgnrk.pokerplanning.entity.security.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoUtil {

    public User toEntity(UserDto dto) {
        var userBuilder = User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword()); // TODO encode it before save to DB!!!!
        return userBuilder.build();
    }

    public LoggedUserDto toLoggedUserDto(User user) {
        return new LoggedUserDto(user.getId(), user.getUsername(), user.getEmail());
    }
}
