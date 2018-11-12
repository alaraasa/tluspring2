package com.aasa.tluspring.LetterPairs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterPairDAO extends CrudRepository<LetterPair, Long> {
}
