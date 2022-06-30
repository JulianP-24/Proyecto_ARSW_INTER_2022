package edu.escuelaing.arsw.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.escuelaing.arsw.model.Usuario;

public interface UserPersistence extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
