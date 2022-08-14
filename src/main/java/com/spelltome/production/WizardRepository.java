package com.spelltome.production;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Long> {
    Optional<Wizard> findByName(String name);
}
