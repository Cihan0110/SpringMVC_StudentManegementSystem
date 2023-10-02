package com.tpe.repository;

import com.tpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Student student) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // If we don't have it in the database, it'll create it. Otherwise, it'll update it.
        session.saveOrUpdate(student);

        tx.commit();
        session.close();

    }

    @Override
    public Optional<Student> findById(Long id) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id); // null
        Optional<Student> optionalStudent = Optional.ofNullable(student); // If that student is null, an empty "Optional" object will be returned.

        tx.commit();
        session.close();

        return optionalStudent;

    }

    @Override
    public List<Student> findAll() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();

        tx.commit();
        session.close();

        return students;
    }

    @Override
    public void delete(Long id) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.load(Student.class, id);
        session.delete(student);

        tx.commit();
        session.close();

    }
}
