package com.tiendaTech.tienda.repository;


import com.tiendaTech.tienda.domain.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    public List<Categoria> findByActivoTrue();

    public Optional<Categoria> findById(Long idCategoria);
}