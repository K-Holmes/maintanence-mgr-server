package com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.services;

import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.models.MaintanenceRequest;
import com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.repos.MaintanenceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintanenceRequestServiceImpl implements MaintanenceRequestService{
    private MaintanenceRequestRepo maintanenceRequestRepo;

    @Autowired
    public MaintanenceRequestServiceImpl(MaintanenceRequestRepo maintanenceRequestRepo) {
        this.maintanenceRequestRepo = maintanenceRequestRepo;
    }

    @Override
    public MaintanenceRequest create(MaintanenceRequest maintanenceRequest) throws ResourceCreationException {
        Optional<MaintanenceRequest> optional = maintanenceRequestRepo.findByEmail(maintanenceRequest.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Maintanence Request with email exists: " + maintanenceRequest.getEmail());
        maintanenceRequest = maintanenceRequestRepo.save(maintanenceRequest);
        return maintanenceRequest;
    }

    @Override
    public MaintanenceRequest getById(Long id) throws ResourceNotFoundException {
        MaintanenceRequest maintanenceRequest = maintanenceRequestRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No request with id: " + id));
        return maintanenceRequest;
    }

    @Override
    public MaintanenceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintanenceRequest maintanenceRequest = maintanenceRequestRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No request with email: " + email));
        return maintanenceRequest;
    }

    @Override
    public List<MaintanenceRequest> getAll() {
        return maintanenceRequestRepo.findAll();
    }

    @Override
    public MaintanenceRequest update(Long id, MaintanenceRequest maintanenceRequestDetail) throws ResourceNotFoundException {
        MaintanenceRequest maintanenceRequest = getById(id);
        maintanenceRequest.setFirstName(maintanenceRequestDetail.getFirstName());
        maintanenceRequest.setLastName(maintanenceRequestDetail.getLastName());
        maintanenceRequest.setEmail(maintanenceRequestDetail.getEmail());
        maintanenceRequest = maintanenceRequestRepo.save(maintanenceRequest);
        return maintanenceRequest;
    }

    @Override
    public void delete(Long id) {
        MaintanenceRequest maintanenceRequest = getById(id);
        maintanenceRequestRepo.delete(maintanenceRequest);
    }
}
