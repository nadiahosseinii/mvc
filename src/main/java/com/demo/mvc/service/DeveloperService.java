package com.demo.mvc.service;

import com.demo.mvc.model.Developer;
import com.demo.mvc.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeveloperService {
    private DeveloperRepository developerRepository;

    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    public Optional<Developer> findById(Long id) {
        return developerRepository.findById(id);
    }

    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    public void deleteById(Long id) {
        developerRepository.deleteById(id);
    }
}
