package com.web.articulos.Repository;

import com.web.articulos.Entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {


    List<Articulo> findAllByNombreIgnoreCaseContaining(String nombre);
    List<Articulo> findAllByCantidadDispGreaterThanEqual(int cantidad);

    @Query(value = "select * from Articulo a offset(:offset) limit(:limit)", nativeQuery = true)
    List<Articulo> buscarArticulosPorPaginacion(@Param("offset") int offset, @Param("limit") int limit);



}
