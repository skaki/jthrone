package com.thinkhr.api.repositories;

import com.thinkhr.api.models.Document;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skaki on 10/4/17.
 */
public interface DocumentRepo extends CrudRepository<Document, Long> {
}
