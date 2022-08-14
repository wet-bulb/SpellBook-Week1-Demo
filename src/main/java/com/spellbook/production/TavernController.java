package com.spellbook.production;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TavernController {

    private final TavernServiceImpl tavernServiceImpl;
    TavernController(TavernServiceImpl tavernServiceImpl) {
        this.tavernServiceImpl = tavernServiceImpl;
    }


    @PostMapping("/wizards/{wizardId}/taverns")
    Tavern add(@PathVariable(value = "wizardId") Long wizardId, @RequestBody Tavern tavernRequest) {
        return tavernServiceImpl.addTavern(wizardId, tavernRequest);
    }

    @PostMapping("/taverns")
        Tavern addOne(@RequestBody Tavern newTavern) {
            return tavernServiceImpl.addOneTavern(newTavern);

    }
}
