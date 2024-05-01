package com.project.api.pokemon.service;

import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.project.api.pokemon.model.Abilities;

@Service
public class PokemonService {
    
    private RestTemplate restTemplate = new RestTemplate();

    public Abilities findAllAbilities(String  nameSpecies) {
        var url = "https://pokeapi.co/api/v2/pokemon/" + nameSpecies;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        try {
            var response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Abilities.class);
            return Optional.ofNullable(response.getBody()).orElseThrow(IllegalArgumentException::new);
        } catch (HttpClientErrorException e) {
            throw new IllegalArgumentException("Error in call search name species: " + e.getMessage());
        }
    }
}