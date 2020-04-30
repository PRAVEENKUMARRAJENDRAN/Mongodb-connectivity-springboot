package com.student.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Student {
  @Id
  public ObjectId _id;
  
  public String firstname;
  public String lastname;
  
  
  @Indexed(unique = true)
  public String emailid;
  
  
  public String password;
  public String accounttype;
  
  // Constructors
  public Student() {}
  
  public Student(ObjectId _id, String firstname, String lastname, String emailid, String password, String accounttype  ) {
    this._id = _id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.emailid= emailid;
    this.password= password;
    this.accounttype= accounttype;
  }

public String get_id() {
	return _id.toHexString(); 
}

public void set_id(ObjectId _id) {
	this._id = _id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getAccounttype() {
	return accounttype;
}

public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}


  

}