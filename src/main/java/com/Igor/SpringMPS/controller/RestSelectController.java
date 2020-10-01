package com.Igor.SpringMPS.controller;

import com.Igor.SpringMPS.data.TransformerRepository;
import com.Igor.SpringMPS.entities.TransformerSubst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

import java.util.Collection;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestSelectController {
    private TransformerRepository transformerRepo;
    //@Autowired
    public RestSelectController (TransformerRepository transformerRepo){
        this.transformerRepo = transformerRepo;
    }

    @GetMapping("/rest-select")
    public Collection<TransformerSubst> restSelect(){
        return transformerRepo.findAll();
        //return transformerRepo.findAll().stream().collect(Collectors.toList());
    }
}
