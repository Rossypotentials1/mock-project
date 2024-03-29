package com.group_A.MyTodo_App.controller;

import com.group_A.MyTodo_App.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;
}
