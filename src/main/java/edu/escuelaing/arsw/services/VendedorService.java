package edu.escuelaing.arsw.services;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.escuelaing.arsw.model.Vendedor;
import edu.escuelaing.arsw.persistence.VendedorPersistence;

@Service
public class VendedorService {
    
    @Autowired
    VendedorPersistence vendedorPersistence;

    @Transactional
    public Vendedor newVendedor(Vendedor vendedor) {
        return vendedorPersistence.save(vendedor);
    }

    @Transactional
    public void deleteVendedor(Long id) {
        vendedorPersistence.deleteById(id);
    }

    public Vendedor findById(Long id) {
        return vendedorPersistence.findById(id).orElse(null);
    }

    public Vendedor findByName(String name) {
        return vendedorPersistence.findByname(name);
    }

    public List<Vendedor> findAll() {
        return vendedorPersistence.findAll();
    }
}
