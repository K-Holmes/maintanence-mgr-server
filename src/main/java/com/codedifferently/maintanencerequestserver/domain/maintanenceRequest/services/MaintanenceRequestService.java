package com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.services;

import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.models.MaintanenceRequest;

import java.util.List;

public interface MaintanenceRequestService {
    MaintanenceRequest create(MaintanenceRequest maintanenceRequest) throws ResourceCreationException;
    MaintanenceRequest getById(Long id) throws ResourceNotFoundException;
    MaintanenceRequest getByEmail(String email) throws ResourceNotFoundException;
    List<MaintanenceRequest> getAll();
    MaintanenceRequest update(Long id, MaintanenceRequest maintanenceRequestDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
