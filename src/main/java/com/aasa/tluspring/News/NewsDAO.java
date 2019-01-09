package com.aasa.tluspring.News;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDAO extends CrudRepository<News, Long> {
}
