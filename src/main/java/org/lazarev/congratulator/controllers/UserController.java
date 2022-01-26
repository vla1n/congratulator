package org.lazarev.congratulator.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.lazarev.congratulator.requests.CreateUserRequest;
import org.lazarev.congratulator.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Контроллер для работы с пользователями */
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    /**
     * Добавление информации о пользователи
     */
    @PostMapping("create")
    @Operation(summary = "Добавление информации о пользователи")
    public void createUser(@RequestBody CreateUserRequest request){
        userService.createUser(request);
    }
}
