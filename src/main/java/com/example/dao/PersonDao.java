package com.example.dao;

import com.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2017/7/14.
 */
@Repository
public interface PersonDao extends JpaRepository<Person, Long> {
}
