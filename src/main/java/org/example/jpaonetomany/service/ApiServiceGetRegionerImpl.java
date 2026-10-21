package org.example.jpaonetomany.service;

import org.example.jpaonetomany.model.Region;
import org.example.jpaonetomany.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner {
    private final RestClient restClient;

    public ApiServiceGetRegionerImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    String regionUrl = "https://api.dataforsyningen.dk/regioner";

    @Autowired
    RegionRepository regionRepository;

    private void saveRegioner(List<Region> regioner) {
        regionRepository.saveAll(regioner);
    }

    @Override
    public List<Region> getRegioner() {
        RestClient.ResponseSpec responseSpec = restClient.get()
                .uri(regionUrl)
                .header("Accept-Encoding", "identity")
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        (request, response) -> {
                            throw new RuntimeException("API Error: " + response.getStatusCode());
                        });

        List<Region> lst = responseSpec.body(new ParameterizedTypeReference<List<Region>>() {
        });

        saveRegioner(lst);

        return lst;

    }
}
