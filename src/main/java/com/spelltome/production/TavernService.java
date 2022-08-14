package com.spelltome.production;

public interface TavernService {
    Tavern addTavern(Long wizardId, Tavern tavernRequest);

    Tavern addOneTavern(Tavern newTavern);
}
