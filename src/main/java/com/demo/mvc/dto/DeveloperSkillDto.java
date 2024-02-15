package com.demo.mvc.dto;

import com.demo.mvc.model.Developer;
import com.demo.mvc.model.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperSkillDto {
    private Skill skill;
    private Developer developer;
}
