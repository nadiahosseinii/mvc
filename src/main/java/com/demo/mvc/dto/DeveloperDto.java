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
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDto {
    private Developer developer;
    private List<Skill> skills;
}
