package com.zonner.rickmontydojo.controller;

import com.zonner.rickmontydojo.model.RickModel;
import com.zonner.rickmontydojo.service.RickService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ricky")
public class RickController {

    private final RickService rickyService;

    @GetMapping("/{id}")
    public RickModel getEpisodeById(@PathVariable long id) {
        return rickyService.getEpisode(id);
    }
}
