package com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.repos;

import com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.models.MaintanenceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintanenceRequestRepo extends JpaRepository<MaintanenceRequest, Long> {
    Optional<MaintanenceRequest> findByEmail(String email);
}
