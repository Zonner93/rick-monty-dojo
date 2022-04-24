package com.zonner.rickmontydojo.service;

import com.zonner.rickmontydojo.model.AllEpisodesDto;
import com.zonner.rickmontydojo.model.EpisodeDto;
import com.zonner.rickmontydojo.model.SeasonDto;
import com.zonner.rickmontydojo.model.SeasonsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeasonsService {
    private final RestTemplate restTemplate;

    public SeasonsDto getAllSeasons() {

        AllEpisodesDto response = restTemplate.getForObject("https://rickandmortyapi.com/api/episode", AllEpisodesDto.class);
        SeasonsDto seasonsDto = new SeasonsDto();
        Map<Long, Long> episodesCountBySeasonMap = getEpisodesCountBySeasonMap(response);

        for (Map.Entry<Long, Long> seasonNumberEntry : episodesCountBySeasonMap.entrySet()) {
            SeasonDto seasonDto = new SeasonDto(seasonNumberEntry.getKey(), seasonNumberEntry.getValue());
            seasonsDto.getSeasonDtoList().add(seasonDto);
        }

        return seasonsDto;
    }

    private long reformatEpisodeFieldToNumber(String episode) {
        try {
            char[] episodeCharArray = episode.toCharArray();
            if (episodeCharArray[1] == '0') {
                episodeCharArray[1] = 'S';
            }
            episode = Arrays.toString(episodeCharArray);

            return Long.parseLong(episode.split("E")[0].replace("S", ""));
        } catch (NumberFormatException numberFormatException) {
            return -1L;
        }
    }

    private Map<Long, Long> getEpisodesCountBySeasonMap(AllEpisodesDto allEpisodesDto) {
        Map<Long, Long> episodesCountMap = new HashMap<>();

        for (EpisodeDto episodeDto : allEpisodesDto.getResults()) {
            long seasonNumber = reformatEpisodeFieldToNumber(episodeDto.getEpisode());

            if (episodesCountMap.containsKey(seasonNumber)) {
                long seasonCount = episodesCountMap.get(seasonNumber);
                episodesCountMap.remove(seasonCount);

                episodesCountMap.put(seasonNumber, ++seasonCount);
            } else {
                episodesCountMap.put(seasonNumber, 1L);
            }
        }
        return episodesCountMap;
    }

}
