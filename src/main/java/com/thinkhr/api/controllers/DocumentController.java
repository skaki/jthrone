package com.thinkhr.api.controllers;

import com.thinkhr.api.repositories.DocumentRepo;
import com.thinkhr.api.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.Principal;

/**
 * Created by skaki on 10/4/17.
 */
@RestController
@RequestMapping(path="/v1")
public class DocumentController {
    @Autowired
    DocumentRepo docRepo;

    @GetMapping(path="/documents")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public @ResponseBody
    Iterable<Document> getAllUsers(Principal principal) {
        System.console().writer().print(principal);
        return docRepo.findAll();
    }

    @GetMapping("document/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ResponseEntity<Document> getById(@PathVariable(name="id",value = "id") Long id, Principal principal) {
        // System.console().writer().print(principal);
        Document document = docRepo.findOne(id);
        return new ResponseEntity<Document>(document, HttpStatus.OK);
    }

    @PostMapping("document")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<Void> create(@RequestBody Document document, UriComponentsBuilder builder, Principal principal) {
        System.console().writer().print(principal);
        docRepo.save(document);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/document/{id}").buildAndExpand(document.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}

