package com.zonner.rickmontydojo.controller;

import com.zonner.rickmontydojo.model.SeasonsDto;
import com.zonner.rickmontydojo.service.SeasonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api1/rick")
public class SeasonsController {

    private final SeasonsService seasonsService;

    @GetMapping("all-seasons")
    public SeasonsDto getAllSeasons(){
        return seasonsService.getAllSeasons();
    }
}
