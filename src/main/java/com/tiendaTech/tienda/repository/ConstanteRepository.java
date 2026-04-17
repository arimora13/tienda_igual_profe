/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendaTech.tienda.repository;
import com.tiendaTech.tienda.domain.Constante;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Arianna Mora
 */
public interface ConstanteRepository  extends JpaRepository<Constante,Integer> {
    
    public Optional<Constante> findByAtributo(String atributo);
    
}