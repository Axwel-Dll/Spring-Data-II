package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Contact;
import com.codingdojo.mvc.models.Student;
import com.codingdojo.mvc.repositories.ContactRepository;
import com.codingdojo.mvc.repositories.StudentRepository;

@Service
public class ApiService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student s) {
		return studentRepository.save(s);
	}
	
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }
    
	public Contact createContact(Contact c) {
		return contactRepository.save(c);
	}
    public Contact findContact(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()) {
            return contact.get();
        } else {
            return null;
        }
    }
    
	public List<Student> getStudentsWithoutContact() {
		return studentRepository.findByContactIsNull();
	}
}
