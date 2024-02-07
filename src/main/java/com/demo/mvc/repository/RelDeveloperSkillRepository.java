package com.demo.mvc.repository;

import com.demo.mvc.model.RelDeveloperSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelDeveloperSkillRepository extends JpaRepository<RelDeveloperSkill, Long> {
    @Query("SELECT rds FROM RelDeveloperSkill as rds  WHERE rds.developer.id = :developerId")
    public List<RelDeveloperSkill> getDevelopersById(@Param("developerId") Long developerId);

    @Query("SELECT rds FROM RelDeveloperSkill as rds  WHERE rds.skill.id = :skillId")
    public List<RelDeveloperSkill> getSkillsById(@Param("skillId") Long skillId);
}
