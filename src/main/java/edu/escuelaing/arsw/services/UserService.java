package edu.escuelaing.arsw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arsw.model.Usuario;
import edu.escuelaing.arsw.persistence.UserPersistence;

@Service
public class UserService {
    
    @Autowired
    private UserPersistence userPersistence;

    public Usuario findByUserName(String username) {
        return userPersistence.findByUsername(username);
    }

    public List<Usuario> findAll() {
        return userPersistence.findAll();
    }

    public Usuario newUser(Usuario usuario) {
        return userPersistence.save(usuario);
    }
}
