/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendaTech.tienda.repository;
import com.tiendaTech.tienda.domain.Rol;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Arianna Mora
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    public Optional<Rol> findByRol(String rol);
    
}