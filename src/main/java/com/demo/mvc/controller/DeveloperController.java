package com.demo.mvc.controller;

import com.demo.mvc.model.Developer;
import com.demo.mvc.service.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/developers")
public class DeveloperController {
    private DeveloperService developerService;

    @GetMapping
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        return new ResponseEntity<>(developerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Developer> getDeveloperById(@PathVariable Long id) {
        return developerService.findById(id);
    }

    @GetMapping("/{id}")
    public

    @PostMapping
    public Developer createDeveloper(@RequestBody Developer developer) {
        return developerService.save(developer);
    }

    @PutMapping("/{id}")
    public Developer updateDeveloper(@PathVariable Long id, @RequestBody Developer developer) {
        developer.setId(id);
        return developerService.save(developer);
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloper(@PathVariable Long id) {
        developerService.deleteById(id);
    }
}
