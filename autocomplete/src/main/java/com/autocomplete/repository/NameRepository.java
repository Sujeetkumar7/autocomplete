package com.autocomplete.repository;

import com.autocomplete.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NameRepository extends JpaRepository<Name, String> {
    List<Name> findByNameStartsWithIgnoreCase(String prefix);
}