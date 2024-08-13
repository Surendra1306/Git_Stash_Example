package com.surendra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
//	@GetMapping("/")
//	public ModelAndView loadStudents(){
//		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("studentObj",new Student());
//		mv.setViewName("index");
//		return mv;
//		
//	}
//	@PostMapping("/students")
//	public ModelAndView getStudents(Student std) {
//		ModelAndView mv= new ModelAndView();
//		mv.setViewName("index");
//		 boolean sts = service.saveTheStudents(std);
//		 if(sts) {
//			 mv.addObject("sms1","Student records saved successfully..");
//		 }
//		 else{
//			 mv.addObject("sms2","Failed to insert record");
//		 }
//		 mv.addObject("studentObj",new Student());//for diff page its not required ,to get response in same page set the binding obj 
//		return mv;
//	}
	
	@GetMapping("/studentDetails")
	public ModelAndView viewStudents() {
		List<Student> slist = service.fetchStudents();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("data");	
		mv.addObject("studentList", slist);
		return mv;
	}
	
//	@GetMapping("/update")
//	public ModelAndView loadUpdates(Integer sid){
//		ModelAndView mv = new ModelAndView("update");
//		Student sbi = service.getStudentsById(sid);
//		mv.addObject("studentObj1",sbi);
//		return mv;
//	
//	}
	 
//	@PostMapping("/update")
//	public String updateStudent(Student student, Model model) {	
//		
//		System.out.println(student.getsId() +" "+ student.getsName() + " "+ student.getsFee());
//		
//		boolean saveTheStudents = service.saveTheStudents(student);
//		if(saveTheStudents) {
//			model.addAttribute("succMsg", "Student details updated successfully");
//		}else {
//			model.addAttribute("errMsg", "Error occured while updating the details");
//		}
// 		return "update";
// 	}
//	@PostMapping("/students/{id}")
//	public String updateStudent(@PathVariable Integer id,
//			@ModelAttribute("student")  Student student,
//			Model model) {
//		
//		Student existingStudent = service.getStudentsById(id);
//		existingStudent.setsId(id);
//		existingStudent.setsName(student.getsName());
//		existingStudent.setsClass(student.getsClass());
//		existingStudent.setsFee(student.getsFee());
//		
//		service.saveTheStudents(existingStudent);
//		return "redirect:/update";		
//	}
	
//	public String getdeletedStudent(Model model,Integer id) {
//		Student byId = service.getStudentsById(id);
//		if(byId!=null) {
//			model.addAttribute("Student", byId);
//		}
//		return "studentDetails";
//	}
//	
	
	@GetMapping("/")
	public String loadStudents(Model model) {
		model.addAttribute("studentObj",new Student());
		return "index";
		
	}
	
	@PostMapping("/students")
	public String getStudents(@ModelAttribute("studentObj") Student studentObj) {
		service.saveTheStudents(studentObj);
		return "index";
	}
	

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") Integer id, Model model) {
 
       Student student= service.getStudentsById(id);
       model.addAttribute("studentupdt",student);
        return "update";
    }

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(value="id") Integer id) {
	   this.service.deleteStudentById(id);
	   return "redirect:/studentDetails";
}
}
