package com.codingdojo.mvc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
	Optional<Tag> findBySubject(String subject);
}
