
package com.project.api.pokemon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.pokemon.model.Abilities;
import com.project.api.pokemon.service.PokemonService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PockemonController {

    private PokemonService pockemonService;

    public PockemonController(PokemonService pockemonService) {
        this.pockemonService = pockemonService;
    }

    @GetMapping("/{name}") 
    public ResponseEntity<Abilities> findAll(@PathVariable("name") String name){

        var abilities = pockemonService.findAllAbilities(name);

        return new ResponseEntity<>(abilities, HttpStatus.OK);
    }
}