package com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.controllers;

import com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.models.MaintanenceRequest;
import com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.services.MaintanenceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maintanence")
@CrossOrigin(origins = "*")
public class MaintanenceRequestController {
    private MaintanenceRequestService maintanenceRequestService;

    @Autowired
    public MaintanenceRequestController(MaintanenceRequestService maintanenceRequestService) {
        this.maintanenceRequestService = maintanenceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<MaintanenceRequest>> getAll(){
        List<MaintanenceRequest> employees = maintanenceRequestService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaintanenceRequest> create(@RequestBody MaintanenceRequest employee){
        employee = maintanenceRequestService.create(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintanenceRequest> getById(@PathVariable("id") Long id){
        MaintanenceRequest maintanenceRequest = maintanenceRequestService.getById(id);
        return new ResponseEntity<>(maintanenceRequest, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<MaintanenceRequest> getByEmail(@RequestParam String email){
        MaintanenceRequest maintanenceRequest = maintanenceRequestService.getByEmail(email);
        return new ResponseEntity<>(maintanenceRequest, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaintanenceRequest> update(@PathVariable("id") Long id, @RequestBody MaintanenceRequest maintanenceRequestDetail){
        maintanenceRequestDetail = maintanenceRequestService.update(id, maintanenceRequestDetail);
        return new ResponseEntity<>(maintanenceRequestDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MaintanenceRequest> delete(@PathVariable("id") Long id){
        maintanenceRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
