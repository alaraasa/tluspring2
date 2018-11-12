package com.aasa.tluspring.Texts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextDAO extends CrudRepository<Text, Long> {
}
