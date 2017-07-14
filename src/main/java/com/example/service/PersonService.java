package com.example.service;

import com.example.dao.PersonDao;
import com.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class  PersonService {
     @Autowired
     private PersonDao personDao;

     public Person getPersonById(Long pid) {
          Person obj = personDao.findOne(pid);
          return obj;
     }

     public List<Person> getAllPersons() {
          return (List<Person>) personDao.findAll();
     }

     public Person saveAndUpdatePerson(Person person) {
          return personDao.save(person);
     }

     public void deletePerson(Long pid) {
          personDao.delete(pid);
     }
}
