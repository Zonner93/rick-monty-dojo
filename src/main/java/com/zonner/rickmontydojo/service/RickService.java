package com.zonner.rickmontydojo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zonner.rickmontydojo.model.AllEpisodesDto;
import com.zonner.rickmontydojo.model.EpisodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RickService {

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public EpisodeDto getEpisode(long id) {
        EpisodeDto response = restTemplate.getForObject("https://rickandmortyapi.com/api/episode/" + id, EpisodeDto.class);
        return objectMapper.convertValue(response, EpisodeDto.class);
    }

    public AllEpisodesDto getAllEpisodes() {
        AllEpisodesDto response = restTemplate.getForObject("https://rickandmortyapi.com/api/episode", AllEpisodesDto.class);
        return objectMapper.convertValue(response, AllEpisodesDto.class);
    }
}
