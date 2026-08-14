package dev.inventory.inventory_api.repository;

import dev.inventory.inventory_api.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository <Server, Long> {
}
