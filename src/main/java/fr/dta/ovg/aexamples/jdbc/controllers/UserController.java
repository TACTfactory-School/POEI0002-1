package com.ovg.app.aexamples.jdbc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovg.app.aexamples.jdbc.entities.User;
import com.ovg.app.aexamples.jdbc.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController extends CrudController<User, UserRepository> {
}
