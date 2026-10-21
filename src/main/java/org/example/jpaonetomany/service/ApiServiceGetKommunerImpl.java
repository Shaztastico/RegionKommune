package org.example.jpaonetomany.service;

import org.example.jpaonetomany.model.Kommune;
import org.example.jpaonetomany.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {
    private final RestClient restClient;

    public ApiServiceGetKommunerImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    @Autowired
    KommuneRepository kommuneRepository;

    private void saveKommuner(List<Kommune> kommuner) {
        kommuneRepository.saveAll(kommuner);
    }

    @Override
    public List<Kommune> getKommuner() {
        RestClient.ResponseSpec responseSpec = restClient.get()
                .uri(kommuneUrl)
                .header("Accept-Encoding", "identity")
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        (request, response) -> {
                            throw new RuntimeException("API Error: " + response.getStatusCode());
                        });

        List<Kommune> lst = responseSpec.body(new ParameterizedTypeReference<List<Kommune>>() {
        });

        saveKommuner(lst);

        return lst;

    }
}
