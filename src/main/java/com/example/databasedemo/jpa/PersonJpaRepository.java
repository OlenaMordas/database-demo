package com.example.databasedemo.jpa;

import com.example.databasedemo.entity.Person;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        entityManager.remove(findById(id));
    }

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery= entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

}
