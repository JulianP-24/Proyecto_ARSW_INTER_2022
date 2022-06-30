package edu.escuelaing.arsw.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.escuelaing.arsw.model.Comprador;

public interface CompradorPersistence extends JpaRepository<Comprador, Long> {
    public Comprador findByname(String name);
}
