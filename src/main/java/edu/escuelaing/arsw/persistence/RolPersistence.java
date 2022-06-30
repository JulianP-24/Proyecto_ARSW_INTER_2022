package edu.escuelaing.arsw.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.arsw.model.Rol;

public interface RolPersistence extends JpaRepository<Rol, Long> {
    public Rol findByname(String name);
        
    
}
