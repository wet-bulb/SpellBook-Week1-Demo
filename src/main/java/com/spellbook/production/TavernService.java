package com.spellbook.production;

public interface TavernService {
    Tavern addTavern(Long wizardId, Tavern tavernRequest);

    Tavern addOneTavern(Tavern newTavern);
}
