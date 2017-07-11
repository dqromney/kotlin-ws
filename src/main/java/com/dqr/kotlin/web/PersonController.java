package com.dqr.kotlin.web;

import com.dqr.kotlin.persistence.PersonRepository;
import com.dqr.kotlin.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * http://localhost:8081/persons
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository repo;

    // -----------------------------------------------------------------------------------------------------------------
    // API - read
    // -----------------------------------------------------------------------------------------------------------------
    @GetMapping("/person/{id}")
    @Validated
    public Person findById(@PathVariable @Min(0) final long id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/persons")
    public List<Person> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/persons", params = {"page", "size"})
    @Validated
    public List<Person> findPaginated(@RequestParam("page") @Min(0) final int page, @Max(100) @RequestParam("size") final int size) {
        return repo.findAll(PageRequest.of(page, size)).getContent();
    }

    // -----------------------------------------------------------------------------------------------------------------
    // API - write
    // -----------------------------------------------------------------------------------------------------------------
    @PutMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person update(@PathVariable("id") final String id, @RequestBody final Person person) {
        return person;
    }

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Person person) {
        if (null == person || null == person.getName()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " 'name' is required");
        }
        repo.save(person);
    }
}
