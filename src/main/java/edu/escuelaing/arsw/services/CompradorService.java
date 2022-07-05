package edu.escuelaing.arsw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.escuelaing.arsw.model.Comprador;
import edu.escuelaing.arsw.persistence.CompradorPersistence;

@Service
public class CompradorService {
    
    @Autowired
    private CompradorPersistence compradorPersistence;

    @Transactional
    public Comprador newComprador(Comprador comprador) {
        return compradorPersistence.save(comprador);
    }

    @Transactional
    public void deleteComprador(Long id) {
        compradorPersistence.deleteById(id);
    }

    public Comprador findById(Long id) {
        return compradorPersistence.findById(id).orElse(null);
    }

    public Comprador findByName(String name) {
        return compradorPersistence.findByname(name);
    }
}
