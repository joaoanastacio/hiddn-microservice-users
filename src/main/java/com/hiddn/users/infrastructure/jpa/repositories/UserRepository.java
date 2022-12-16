package com.hiddn.users.infrastructure.jpa.repositories;

import com.hiddn.users.infrastructure.jpa.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByUserKeycloakIdentifier(UUID userKeycloakIdentifier);
}
