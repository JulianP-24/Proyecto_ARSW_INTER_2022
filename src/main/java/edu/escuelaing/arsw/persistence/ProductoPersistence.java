package edu.escuelaing.arsw.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.escuelaing.arsw.model.Producto;
import edu.escuelaing.arsw.model.Vendedor;

public interface ProductoPersistence extends JpaRepository<Producto, Long> {
    public Producto findByproductName(String productName);

    public List<Producto> findByPrecio(Double precio);

    @Query("select products from productos where products.vendedor = ?1")
    public List<Producto> findProductosByVendedor(Vendedor vendedor);

}
