package demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
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
import demo.request.InQueryRequest;
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

	Logger logger = org.slf4j.LoggerFactory.getLogger(StudentController.class);

	@GetMapping("/getAll")
	public List<StudentResponse> getAll() {
		logger.error("Inside Error");
		logger.warn("Inside Warning");
		logger.info("Inside Info");
		logger.debug("Inside debug");
		logger.trace("Inside trace");
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

	@GetMapping("getByFirstName/{firstName}")
	public List<StudentResponse> getByFistName(@PathVariable String firstName) {
		List<Student> student = studentService.getByFisrtName(firstName);

		List<StudentResponse> studentResponseList = new ArrayList<>();
		student.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}

	@GetMapping("getByLastName/{lastName}")
	public List<StudentResponse> getByLastName(@PathVariable String lastName) {
		List<Student> studentList = studentService.getByLastName(lastName);
		List<StudentResponse> studentResponseList = new ArrayList<>();
		studentList.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;

	}

	@GetMapping("/getByFirstNameAndLastName/{firstName}/{lastName}")
	public List<StudentResponse> getByFirstNameAndLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		List<Student> student = studentService.getByFirstNameAndLastName(firstName, lastName);
		List<StudentResponse> studentResponseList = new ArrayList<>();
		student.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}

	@GetMapping("/getByFirstNameOrLastName/{firstName}/{lastName}")
	public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		List<Student> student = studentService.getByFirstNameOrLastName(firstName, lastName);

		List<StudentResponse> studentResponseList = new ArrayList<>();
		student.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}

	@GetMapping("/getByFirstNameIn")
	public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest) {

		//logger.info("inQueryRequest =" + inQueryRequest);

		List<Student> student = studentService.getByFirstNameIn(inQueryRequest);
		List<StudentResponse> studentResponseList = new ArrayList<>();
		student.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));

		logger.info("studentResponseList =" + studentResponseList);

		return studentResponseList;
	}

	@GetMapping("/getAllByPagination")
	public List<StudentResponse> getAllByPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		List<Student> student = studentService.getAllByPagination(pageNo, pageSize);
		List<StudentResponse> studentResponseList = new ArrayList<>();
		student.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}

	@GetMapping("/getAllBySorting")
	public List<StudentResponse> getAllBySorting() {
		List<Student> student = studentService.getAllBySorting();
		List<StudentResponse> studentResponseList = new ArrayList<>();
		student.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}

	@GetMapping("/getByFirstNameLike/{firstName}")
	public List<StudentResponse> getByFirstNameLike(@PathVariable String firstName) {
		List<Student> student = studentService.like(firstName);

		List<StudentResponse> studentResponseList = new ArrayList<>();
		student.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}

	@GetMapping("getByFirstNameStartsWith/{firstName}")
	public List<StudentResponse> getByFirstNameStartsWith(@PathVariable String firstName) {
		List<Student> student = studentService.getByStartsWithFirstName(firstName);
		List<StudentResponse> studentResponseList = new ArrayList<>();
		student.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}

	@PutMapping("updateFirstNameAndLastName/{id}/{firstName}/{lastName}")
	public String updateFirstNameAndLastName(@PathVariable Long id, @PathVariable String firstName,
			@PathVariable String lastName) {
		return studentService.updateFirstNameAndLastName(id, firstName, lastName) + " Student(s) updated";

	}

	@DeleteMapping("deleteByFirstName/{firstName}")
	public String deleteByFirstName(@PathVariable String firstName) {
		return studentService.deleteByFirstName(firstName) + " Student(s) deleted";
	}

	@GetMapping("/getByAddressCity/{city}")
	public List<StudentResponse> getByAddressCity(@PathVariable String city) {
		List<Student> studentList = studentService.getByAddressCity(city);
		List<StudentResponse> studentResponseList = new ArrayList<>();
		studentList.stream().forEach(s -> studentResponseList.add(new StudentResponse(s)));
		return studentResponseList;
	}
}
