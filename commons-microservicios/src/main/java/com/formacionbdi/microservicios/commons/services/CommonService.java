package com.formacionbdi.microservicios.commons.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
public interface CommonService<E> {

    public Iterable<E> findAll();

    public Page<E> findAll(Pageable pageable);

    public Optional<E> findById(Long id);

    public E save(E entity);

    public void deleteById(Long id);


}
