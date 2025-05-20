package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Student;
import demo.request.CreateStudentRequest;
import demo.request.UpdateStudentRequest;
import demo.response.StudentResponse;
import demo.service.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

	@Value("${spring.application.name: Default app name}")
	private String appName;

	@Autowired
	private StudentService studentService;

	@GetMapping("/get")
	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getStudent() {
		return appName;
	}

	@GetMapping("/getJackson")
	public StudentResponse getStu() {
		StudentResponse studentResponse = new StudentResponse(1, "Abdul", "Hannan", "abdul.hannan@gmail.com");
		studentResponse.setFirstName("Believer");
		return studentResponse;
	}

	@GetMapping("/getAll")
	public List<StudentResponse> getAll() {
		List<StudentResponse> studentResponseList = new ArrayList<>();
		List<Student> studentList = studentService.getAllStudents();
		studentList.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}

	@PostMapping("/create")
	public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		Student st = studentService.createStudent(createStudentRequest);
		return new StudentResponse(st);
	}

	@PutMapping("/update")
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		Student student = studentService.updateStudent(updateStudentRequest);
		return new StudentResponse(student);
	}

	@DeleteMapping("/delete")
	public String deleteStudent1(@RequestParam("id") long id) {
		studentService.deleteStudent(id);
		return "Student record has been deleted successfully using request parameter";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
		return "Student record has been deleted successfully using path variable..";
	}
	
	

}
