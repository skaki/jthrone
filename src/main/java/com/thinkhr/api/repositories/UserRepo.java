package com.thinkhr.api.repositories;

/**
 * Created by skaki on 10/4/17.
 */

import com.thinkhr.api.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}