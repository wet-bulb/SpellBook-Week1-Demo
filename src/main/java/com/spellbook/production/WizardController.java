package com.spellbook.production;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class    WizardController {

    private final WizardServiceImpl wizardServiceImpl;

    WizardController(WizardServiceImpl wizardServiceImpl) {
        this.wizardServiceImpl = wizardServiceImpl;
    }

    @GetMapping("/wizards")
    Optional<Wizard> one(@RequestParam String name) {
        return wizardServiceImpl.findOneWizard(name);
    }

    @PostMapping("/wizards")
    Wizard add(@RequestBody Wizard newWizard) {
        return wizardServiceImpl.addWizard(newWizard);
    }

    @PostMapping("/wizards/invites")
    List<Wizard> addThree(@RequestBody WizardNames wizardNames) {
        return wizardServiceImpl.addThreeWizards(wizardNames);
    }

    @PatchMapping("/wizards/invites")
    Wizard updateInvites(@RequestParam Long id, @RequestParam Boolean bool) {
        return wizardServiceImpl.updateInvites(id, bool);
    }

}
