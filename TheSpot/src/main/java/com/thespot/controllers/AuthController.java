package com.thespot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.thespot.services.AuthService;

@RestController
@CrossOrigin({"*", "http://localhost/"})
public class AuthController {
  @Autowired
  private AuthService authService;
}