package com.spellbook.production;

import com.google.common.collect.Streams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class WizardServiceImpl implements WizardService {
    private final WizardRepository repository;

    WizardServiceImpl(WizardRepository repository) {
        this.repository = repository;
    }

    @Value("${API_KEY}")
    private String apiKey;

    @Override
    public Optional<Wizard> findOneWizard(String name) {
        return repository.findByName(name);
    }

    @Override
    public Wizard addWizard(Wizard newWizard) {
        return repository.save(newWizard);
    }

    public PixabayResponse getPixabayResponse(Long id) {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl = String.valueOf(UriComponentsBuilder.fromHttpUrl("https://pixabay.com/api/")
                .queryParam("q", "wizard")
                .queryParam("key", apiKey)
                .queryParam("safesearch", "true")
                .queryParam("page", id.toString())
                .queryParam("per_page", 3)
                .build());

        ResponseEntity<PixabayResponse> response = restTemplate.getForEntity(resourceUrl, PixabayResponse.class);

        PixabayResponse pixabayResponse = response.getBody();
        return pixabayResponse;
    }

    @Override
    public List<Wizard> addThreeWizards(WizardNames wizardNames) {

        PixabayResponse pixabayResponse = getPixabayResponse(wizardNames.getId()+1);

        List<String> avatars = pixabayResponse.getHits().stream()
                .map(PixabayImage::getPreviewURL)
                .toList();
        List<String> names = wizardNames.getNames();
        List<Wizard> wizards = Streams
                .zip(names.stream(), avatars.stream(), Wizard::new)
                .toList();
        return wizards.stream()
                .map(repository::save)
                .toList();

    }

    @Override
    public Wizard updateInvites(Long id, Boolean bool) {
        Wizard wizard = repository.findById(id).orElse(null);
        wizard.setInvites(bool);
        return repository.save(wizard);
    }
}
