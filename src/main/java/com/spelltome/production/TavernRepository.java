package com.spelltome.production;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TavernRepository extends JpaRepository<Tavern, Long> {
    Optional<Tavern> findByName(String name);
}
