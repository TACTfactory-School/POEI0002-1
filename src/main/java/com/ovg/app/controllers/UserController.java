package com.ovg.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovg.app.entities.User;
import com.ovg.app.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController extends CrudController<User, UserRepository> {

}
