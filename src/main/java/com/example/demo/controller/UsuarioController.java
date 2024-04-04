package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("api")
@RestController
public class UsuarioController{
    @Autowired
    private UserRepository repo;
    @GetMapping("/usuario")
    public List<Usuario> getUser(){
        return repo.findAll();
    }

@PostMapping("/create")
public Usuario saveUser(@RequestBody Usuario user){
    return repo.save(user);
}
}
