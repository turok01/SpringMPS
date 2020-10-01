package com.Igor.SpringMPS.data;

import com.Igor.SpringMPS.entities.TransformerSubst;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface TransformerRepository extends CrudRepository<TransformerSubst, Integer> {
    Page<TransformerSubst> findAll(Pageable pageable);
    List<TransformerSubst> findAll();

}
