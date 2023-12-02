package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoService {
    private final AutoRepository autoRepository;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public Iterable<Auto> listAll() {
        return autoRepository.findAll();
    }

    public void save(Auto auto) {
        autoRepository.save(auto);
    }

    public Auto get(Long id) {
        return autoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        autoRepository.deleteById(id);
    }

    public void update(Auto auto) {
        // Проверяем, существует ли расписание с таким ID в репозитории
        if (auto.getId() != null && autoRepository.existsById(auto.getId())) {
            autoRepository.save(auto); // save используется и для обновления, если запись уже существует
        } else {
            throw new IllegalArgumentException("Auto with ID " + auto.getId() + " does not exist.");
        }
    }
    public boolean exists(Long id) {
        return autoRepository.existsById(id);
    }
}
