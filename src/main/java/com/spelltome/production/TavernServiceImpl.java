package com.spelltome.production;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TavernServiceImpl implements TavernService {
    private final TavernRepository tavernRepository;
    private final WizardRepository wizardRepository;


    TavernServiceImpl(TavernRepository tavernRepository, WizardRepository wizardRepository) {
        this.tavernRepository = tavernRepository;
        this.wizardRepository = wizardRepository;
    }

    @Override
    public Tavern addTavern(Long wizardId, Tavern tavernRequest) {
        Tavern tavern = wizardRepository.findById(wizardId).map(wizard -> {
            long tavernId = tavernRequest.getId();
            String tavernName = tavernRequest.getName();

            // tavern exists
            if (tavernId != 0L) {
                Tavern _tavern = tavernRepository.findByName(tavernName)
                        .orElseThrow(() -> new ResourceNotFoundException("No Tavern with name = " + tavernName));
                wizard.addTavern(_tavern);
                wizardRepository.save(wizard);
                return _tavern;
            }

            // add and create new Tavern
            wizard.addTavern(tavernRequest);
            return tavernRepository.save(tavernRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("No Wizard with id = " + wizardId));
        return tavern;
    }

    @Override
    public Tavern addOneTavern(Tavern newTavern) {
        return tavernRepository.save(newTavern);
    };
}
