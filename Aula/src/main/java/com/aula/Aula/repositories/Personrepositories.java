package com.aula.Aula.repositories;

import com.aula.Aula.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Personrepositories extends JpaRepository <Person, Long > { }
