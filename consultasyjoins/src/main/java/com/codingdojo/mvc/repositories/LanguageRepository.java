package com.codingdojo.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long>{

}
