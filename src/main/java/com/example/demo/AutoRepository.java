package com.example.demo;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface AutoRepository extends CrudRepository<Auto, Long> {
}
