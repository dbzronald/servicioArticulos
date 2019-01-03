package com.web.articulos.Repository;

import com.web.articulos.Entity.Articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ArticuloPagRepository extends PagingAndSortingRepository<Articulo, Integer> {

    Page<Articulo> findAll(Pageable pageable);

}
