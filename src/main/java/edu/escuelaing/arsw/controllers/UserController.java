package edu.escuelaing.arsw.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arsw.model.Comprador;
import edu.escuelaing.arsw.model.Usuario;
import edu.escuelaing.arsw.model.Vendedor;
import edu.escuelaing.arsw.services.CompradorService;
import edu.escuelaing.arsw.services.UserService;
import edu.escuelaing.arsw.services.VendedorService;

@RestController
@RequestMapping(value = "/SubastaExpress")
public class UserController {
    
    @Autowired
    UserService userService;

    @Autowired
    CompradorService compradorService;

    @Autowired
    VendedorService vendedorService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody Usuario user) {
        Usuario usuario = new Usuario(user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getSurname(),user.getRoles());

        String roles = user.getRoles();
        if (roles.equals(null)) {
            new RuntimeException("Error, no existe el rol");
        } else {
            user.setRoles(roles);
            if (roles.equals("Comprador")) {
                Comprador comprador = new Comprador(user.getUsername(), user.getSurname(), user.getEmail());
                compradorService.newComprador(comprador);
            }
            if (roles.equals("Vendedor")) {
                Vendedor vendedor = new Vendedor(user.getUsername(), user.getEmail());
                vendedorService.newVendedor(vendedor);
            }
        }
        System.out.println("Usuario Registrado");
        return new ResponseEntity<>(userService.newUser(usuario), HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/login/{username}")
    public ResponseEntity<?> login(@RequestBody @PathVariable String username) {
        Usuario user = userService.findByUserName(username);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

}
