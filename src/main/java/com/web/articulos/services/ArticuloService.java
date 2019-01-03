package com.web.articulos.services;

import com.web.articulos.entity.Articulo;
import com.web.articulos.repository.ArticuloPagRepository;
import com.web.articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService {

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    private ArticuloPagRepository articuloPagRepository;

    public void crearArticulo(Articulo articulo) {

        articuloRepository.save(articulo);
    }

    public List<Articulo> buscarTodos(){

        return articuloRepository.findAll();
    }

    public void borrarArticulo(Articulo articulo){

        articuloRepository.delete(articulo);
    }

    public Articulo buscarPorId(int id) {

        Optional<Articulo> articulo = articuloRepository.findById(id);

        return articulo.orElse(null);

    }

    public List<Articulo> buscarArtNombre(String nombre) {
        return articuloRepository.findAllByNombreIgnoreCaseContaining(nombre);
    }

    public List<Articulo> pagDeArticulos(Pageable page) {

        return articuloPagRepository.findAll(page).getContent();
    }

    public List<Articulo> buscarArtPorCantMayor(int cantidad) {

        return articuloRepository.findAllByCantidadDispGreaterThanEqual(cantidad);
    }

    public void restarCantidadArticulo(Articulo articulo, int cantidadMenos) {

        articulo.setCantidadDisp(articulo.getCantidadDisp() - cantidadMenos);
        articuloRepository.save(articulo);
    }

    public int contarArticulos() {

        return (int) articuloRepository.count();
    }
}
