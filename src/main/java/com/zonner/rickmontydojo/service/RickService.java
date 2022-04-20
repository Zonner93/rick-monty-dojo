package com.zonner.rickmontydojo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zonner.rickmontydojo.model.RickModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RickService {

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

//    @Bean
    public RickModel getEpisode(long id) {
        RickModel response = restTemplate.getForObject("https://rickandmortyapi.com/api/episode/" + id, RickModel.class);
        return objectMapper.convertValue(response, RickModel.class);
    }

}
