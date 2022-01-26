package org.lazarev.congratulator.services;

import lombok.RequiredArgsConstructor;
import org.lazarev.congratulator.entities.UserEntity;
import org.lazarev.congratulator.mappers.Mapper;
import org.lazarev.congratulator.repositories.UserRepository;
import org.lazarev.congratulator.requests.CreateUserRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Добавление информации о пользователи
     */
    public UserEntity createUser(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity(request.getUsername(), request.getFriends().stream().map(Mapper::modelToBirthdayBoyEntity).collect(Collectors.toList()));
        userEntity.getFriends().forEach(f -> f.setUser(userEntity));
        return userRepository.save(userEntity);
    }
}
