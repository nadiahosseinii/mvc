package com.demo.mvc.controller;

import com.demo.mvc.dto.DeveloperDto;
import com.demo.mvc.dto.DeveloperSkillDto;
import com.demo.mvc.model.Developer;
import com.demo.mvc.service.DeveloperService;
import com.demo.mvc.service.RelDeveloperSkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
@RestController
@RequestMapping("/api/developers")
public class DeveloperController {
    private DeveloperService developerService;
    private RelDeveloperSkillService relDeveloperSkillService;

    @GetMapping("/")
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        return new ResponseEntity<>(developerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Developer>> getDeveloperById(@PathVariable Long id) {
        return new ResponseEntity<>(developerService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/developerSkill/{id}")
    public ResponseEntity<DeveloperDto> getDeveloperSkills(@PathVariable Long id) {
        return new ResponseEntity<>(relDeveloperSkillService.getDeveloper(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Developer> saveDeveloper(@RequestBody Developer developer) {
        return new ResponseEntity<>(developerService.save(developer), HttpStatus.OK);
    }

    @PostMapping("/saveWithSkills")
    public ResponseEntity<DeveloperSkillDto> saveDeveloperSkills(@RequestBody DeveloperSkillDto dto) {
        return new ResponseEntity<>(relDeveloperSkillService.saveDeveloperSkills(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeveloper(@PathVariable Long id) {
        developerService.deleteById(id);
    }
}
