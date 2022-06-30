package edu.escuelaing.arsw.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.escuelaing.arsw.model.Vendedor;

public interface VendedorPersistence extends JpaRepository<Vendedor, Long>{
    public Vendedor findByname(String name);
}
