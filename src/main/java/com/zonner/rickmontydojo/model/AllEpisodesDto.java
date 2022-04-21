package com.zonner.rickmontydojo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllEpisodesDto {
    private EpisodeInfo info;
    private List<EpisodeDto> results;
}
