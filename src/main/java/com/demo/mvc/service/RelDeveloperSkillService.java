package com.demo.mvc.service;

import com.demo.mvc.dto.DeveloperDto;
import com.demo.mvc.dto.DeveloperSkillDto;
import com.demo.mvc.model.Developer;
import com.demo.mvc.model.RelDeveloperSkill;
import com.demo.mvc.model.Skill;
import com.demo.mvc.repository.DeveloperRepository;
import com.demo.mvc.repository.RelDeveloperSkillRepository;
import com.demo.mvc.repository.SkillRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RelDeveloperSkillService {
    private DeveloperRepository developerRepository;
    private SkillRepository skillRepository;
    private RelDeveloperSkillRepository relDeveloperSkillRepository;

    public DeveloperDto getDeveloper(Long id) {
        DeveloperDto developerDto = new DeveloperDto();
        Optional<Developer> developer = developerRepository.findById(id);
        List<RelDeveloperSkill> relDeveloperSkills = relDeveloperSkillRepository.getDevelopersById(developer.orElseThrow(() -> new RuntimeException("Developer not found.")).getId());
        List<Skill> skills = relDeveloperSkills.stream().map(RelDeveloperSkill::getSkill).toList();
        developerDto.setSkills(skills);
        developerDto.setDeveloper(developer.get());
        return developerDto;
    }


    @Transactional
    public DeveloperSkillDto saveDeveloperSkills(DeveloperSkillDto dto) {
        Developer developer = developerRepository.findById(dto.getDeveloper().getId()).orElseThrow(() -> new RuntimeException("Developer not found"));
        Skill skill = skillRepository.findById(dto.getSkill().getId()).orElseThrow(() -> new RuntimeException("Skill not found"));
        relDeveloperSkillRepository.save(new RelDeveloperSkill(developer, skill));
        return dto;
    }


}
