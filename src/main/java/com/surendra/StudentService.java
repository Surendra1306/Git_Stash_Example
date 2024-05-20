package com.surendra;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	public Student saveTheStudents(Student st) {
	  Student stud = repo.save(st);
	  return stud;
	}
	
	public List<Student> fetchStudents(){
		 return repo.findAll();
	}
	
//	public boolean updateStudent( Student st1,Integer id) {
//		 Optional<Student> optionalStudent = repo.findById(id); 
//	        if (optionalStudent.isPresent()) {  
//	            Student existingStudent = optionalStudent.get();  
//	             
//	            existingStudent.setsName(existingStudent.getsName());
//	            existingStudent.setsClass(existingStudent.getsClass());
//	            existingStudent.setsFee(existingStudent.getsFee());
//	            
//	            repo.save(existingStudent);
//	            return true;  
//	        } else { 
//	            return false; 
//	        }
//	}
//	
	public Student getStudentsById(Integer sId) {
		Student student = repo.findById(sId).get();
		return student;
	}
	
	public Student updateStudentsById(Student st) {
		return repo.save(st);
	}
	
	public boolean deleteStudentById(Integer id) {
		 repo.deleteById(id);
		 return true;
	}
}
