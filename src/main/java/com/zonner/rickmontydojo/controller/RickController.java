package com.zonner.rickmontydojo.controller;

import com.zonner.rickmontydojo.model.AllEpisodesDto;
import com.zonner.rickmontydojo.model.EpisodeDto;
import com.zonner.rickmontydojo.service.RickService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rick")
public class RickController {

    private final RickService rickyService;

    @GetMapping("/{id}")
    public EpisodeDto getEpisodeById(@PathVariable long id) {
        return rickyService.getEpisode(id);
    }

    @GetMapping("/all-episodes")
    public AllEpisodesDto getAllEpisodes(){return rickyService.getAllEpisodes();}

}
