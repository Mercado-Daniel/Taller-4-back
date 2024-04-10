package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("api")
@RestController
public class UsuarioController{
    @Autowired
    private UserRepository repo;
    @GetMapping("/usuarios")
    public List<Usuario> getUser(){
        return repo.findAll();
    }

    @PostMapping("/create")
    public Usuario saveUser(@RequestBody Usuario user){
        return repo.save(user);
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> getUserById(@PathVariable Long id){
        return repo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        repo.deleteById(id);
    }

    @PutMapping("/update")
    public Usuario UpdateUser(@RequestBody Usuario user){
        Optional<Usuario> u = repo.findById(user.getId());
        Usuario userU = u.get();
        userU.setUsername(user.getUsername());
        userU.setPassword(user.getPassword());
        userU.setEmail(user.getEmail());
        userU.setEnabled(user.isEnabled());
        return repo.save(userU);
    }

    /*@PutMapping("/{id}")
        public Usuario updateCustomer(@PathVariable Long id, @RequestBody Usuario user){
            Optional<Usuario> userOp = repo.findById(id);//obtengo el objeto a modificar
            System.out.println(userOp);
            Usuario userDb = userOp.get();
            System.out.println(userDb);
            userDb.setUsername(user.getUsername());
            System.out.println(userDb);
            userDb.setEmail(user.getEmail());
            System.out.println(userDb);
            userDb.setEnabled(user.isEnabled());
            System.out.println(userDb);
            return userDb;
    }*/
}
