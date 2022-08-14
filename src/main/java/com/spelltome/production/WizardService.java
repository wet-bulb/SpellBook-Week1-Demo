package com.spelltome.production;

import java.util.List;
import java.util.Optional;

public interface WizardService {
    Optional<Wizard> findOneWizard(String name);
    //    Post findAllPostByID(long id);
    Wizard addWizard(Wizard wizard);
//    void deleteAllData();
    List<Wizard> addThreeWizards(WizardNames wizardNames);

    Wizard updateInvites(Long id, Boolean bool);
}
