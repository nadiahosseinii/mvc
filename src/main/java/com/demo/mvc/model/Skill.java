package com.demo.mvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Skill", uniqueConstraints = {@UniqueConstraint(columnNames = "NAME")}, indexes = {@Index(columnList = "ID"), @Index(columnList = "NAME")})
public class Skill {
    @Getter
    @Setter
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Skill(String name) {
        this.name = name;
    }

}
