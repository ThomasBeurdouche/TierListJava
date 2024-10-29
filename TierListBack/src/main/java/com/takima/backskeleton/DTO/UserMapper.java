package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.User;
import com.takima.backskeleton.models.TierList;

import java.io.IOException;
import java.util.List;

public class UserMapper {
    public static User fromDto(UserDto dto, Long id) throws IOException {
        return new User.Builder()
            .id(id)
            .username(dto.getUsername())
            .mail(dto.getMail())
            .mdp(dto.getMdp())
            .tierLists(dto.getTierLists())
            .build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .mail(user.getMail())
                .mdp(user.getMdp())
                .tierLists(user.getTierLists())
                .build();
    }
}
