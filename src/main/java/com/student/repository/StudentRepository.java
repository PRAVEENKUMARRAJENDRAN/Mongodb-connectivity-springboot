package com.student.repository;

import com.student.models.Student;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
   //our own function, defining is done in controller
	Student findBy_id(ObjectId _id);
	
	Student findByEmailid(String emailid);
	
	
}

