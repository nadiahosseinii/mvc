package com.demo.mvc.controller;

import com.demo.mvc.dto.DeveloperSkillDto;
import com.demo.mvc.model.Skill;
import com.demo.mvc.service.RelDeveloperSkillService;
import com.demo.mvc.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/skills")
public class SkillController {
    private SkillService skillService;
    private RelDeveloperSkillService relDeveloperSkillService;

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Skill> getSkillById(@PathVariable Long id) {
        return skillService.findById(id);
    }


    @PostMapping("/save")
    public Skill saveSkill(@RequestBody Skill skill) {
        return skillService.save(skill);
    }

    @PostMapping("/saveWithDevelopers")
    public ResponseEntity<DeveloperSkillDto> saveWithDevelopers(@RequestBody DeveloperSkillDto dto) {
        return new ResponseEntity<>(relDeveloperSkillService.saveDeveloperSkills(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteById(id);
    }
}
