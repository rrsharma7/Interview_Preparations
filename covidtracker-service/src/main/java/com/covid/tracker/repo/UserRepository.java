package com.covid.tracker.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.tracker.domain.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
