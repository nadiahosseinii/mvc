package com.demo.mvc.dto;

import com.demo.mvc.model.Developer;
import com.demo.mvc.model.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {
    private Skill skill;
    private List<Developer> developers;
}
