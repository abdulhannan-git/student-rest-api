package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Student;
import demo.repository.StudentRepository;
import demo.request.CreateStudentRequest;
import demo.request.InQueryRequest;
import demo.request.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student createStudent(CreateStudentRequest createStudentRequest) {
		return studentRepository.save(new Student(createStudentRequest));

	}

	public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
		Student student = studentRepository.findById(updateStudentRequest.getId()).get();
		if (student.getFirstName() != null && !student.getFirstName().isEmpty()) {
			student.setFirstName(updateStudentRequest.getFirst_name());
		}
		if (student.getLastName() != null && !student.getLastName().isEmpty()) {
			student.setLastName(updateStudentRequest.getLast_name());
		}
		if (student.getEmail() != null && !student.getEmail().isEmpty()) {
			student.setEmail(updateStudentRequest.getEmail());
		}
		return studentRepository.save(student);

	}

	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}

	public List<Student> getByFisrtName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	public List<Student> getByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	public List<Student> getByFirstNameAndLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	public List<Student> getByFirstNameIn(InQueryRequest firstNames) {
		return studentRepository.findByFirstNameIn(firstNames.getFirstNames());
	}

}
