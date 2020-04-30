package com.student.controller;

import com.student.repository.StudentRepository;

import com.student.models.Student;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
  @Autowired
  private StudentRepository repository;
  
  //Get all the records in the collection
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Student> getAllStudent() {
    return repository.findAll();
  }
  //Get the record of specified emailid
  @RequestMapping(value = "/{emailid}", method = RequestMethod.GET)
  public Student getStudentByEmailid(@PathVariable("emailid") String emailid) {
    return repository.findByEmailid(emailid);
  }
  
  //Update the record based on emailid
  @RequestMapping(value = "/{emailid}", method = RequestMethod.PATCH)
  public @Valid void modifyStudentById(@PathVariable("emailid") String emailid, @Valid @RequestBody Student student) {
	  
	  Student stud = repository.findByEmailid(emailid);
	
	  if(student.getPassword()!= null)
          stud.setPassword(student.getPassword());
	    repository.save(stud);
    
   
    
  }
  //Create a record in Mongodb
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public void createPet(@PathVariable("emailid") String emailid,@Valid @RequestBody Student student) {
	  Student stud = repository.findByEmailid(emailid);
	  if(student.getEmailid()== null) {
		  student.set_id(ObjectId.get());
		  repository.save(student);
		    
	  }
	  
    
  }
  //Delete using emailid
  @RequestMapping(value = "/{emailid}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable String emailid) {
    repository.delete(repository.findByEmailid(emailid));
  }


}