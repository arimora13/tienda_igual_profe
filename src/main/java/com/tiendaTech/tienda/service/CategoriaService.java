package com.tiendaTech.tienda.service;

import com.tiendaTech.tienda.domain.Categoria;
import com.tiendaTech.tienda.repository.CategoriaRepository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final FirebaseStorageService firebaseStorageService;
    public CategoriaService(CategoriaRepository categoriaRepository, FirebaseStorageService firebaseStorageService) {
        this.categoriaRepository = categoriaRepository;
        this.firebaseStorageService = firebaseStorageService;
    }
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) { // ✅ CAMBIO: Optional → List
        if (activo) {
            return categoriaRepository.findByActivoTrue();
        }
        return categoriaRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Categoria> getCategoria(Long idCategoria) { // ✅ CAMBIO: Integer → Long
        return categoriaRepository.findById(idCategoria);
    }
    @Transactional
    public void save(Categoria categoria, MultipartFile imagenFile) {
        categoria = categoriaRepository.save(categoria);
        if (!imagenFile.isEmpty()) {
            try {
                String rutaImagen = firebaseStorageService.uploadImage(
                        imagenFile, "categoria",
                        categoria.getIdCategoria()); // ✅ Long directo
                categoria.setRutaImagen(rutaImagen);
                categoriaRepository.save(categoria);
            } catch (IOException e) {
            }
        }
    }
    @Transactional
    public void delete(Long idCategoria) { // ✅ CAMBIO: Integer → Long
        if (!categoriaRepository.existsById(idCategoria)) {
            throw new IllegalArgumentException("La categoría con ID " + idCategoria + " no existe.");
        }
        try {
            categoriaRepository.deleteById(idCategoria);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar la categoria. Tiene datos asociados.", e);
        }
    }
}