package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Student;
import demo.repository.StudentRepository;
import demo.request.CreateStudentRequest;
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
		if (student.getFirst_name() != null && !student.getFirst_name().isEmpty()) {
			student.setFirst_name(updateStudentRequest.getFirst_name());
		}
		if (student.getLast_name() != null && !student.getLast_name().isEmpty()) {
			student.setLast_name(updateStudentRequest.getLast_name());
		}
		if (student.getEmail() != null && !student.getEmail().isEmpty()) {
			student.setEmail(updateStudentRequest.getEmail());
		}
		return studentRepository.save(student);

	}

	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}
	


}
