/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendaTech.tienda.repository;
import com.tiendaTech.tienda.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Arianna Mora
 */
public interface VentaRepository extends JpaRepository<Venta, Integer>{
    
}