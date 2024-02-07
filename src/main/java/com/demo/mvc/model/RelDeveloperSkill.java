package com.demo.mvc.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Rel_Developer_Skill", indexes = {@Index(columnList = "ID"), @Index(columnList = "ID_DEVELOPER"), @Index(columnList = "ID_SKILL")})
public class RelDeveloperSkill {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DEVELOPER")
    private Developer developer;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SKILL")
    private Skill skill;

    public RelDeveloperSkill(Developer developer, Skill skill) {
        this.developer = developer;
        this.skill = skill;
    }
}
