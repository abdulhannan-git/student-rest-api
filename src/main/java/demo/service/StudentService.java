package demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import demo.entity.Address;
import demo.entity.Student;
import demo.entity.Subject;
import demo.repository.AddressRepository;
import demo.repository.StudentRepository;
import demo.repository.SubjectRepository;
import demo.request.CreateStudentRequest;
import demo.request.CreateSubjectRequest;
import demo.request.InQueryRequest;
import demo.request.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	SubjectRepository subjectRepository;
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student createStudent(CreateStudentRequest createStudentRequest) {
		Address address = new Address();
		Student student = new Student(createStudentRequest);
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());
		address = addressRepository.save(address);
		student.setAddress(address);
		student = studentRepository.save(student);
		
		List<Subject> subjectLists = new ArrayList<>();
		if(createStudentRequest.getSubjectsLearning()!=null) {
			for(CreateSubjectRequest createSubjectRequest :
					createStudentRequest.getSubjectsLearning()) {
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);
				subjectLists.add(subject);
			}
			subjectRepository.saveAll(subjectLists);
		}
		student.setLearningSubjects(subjectLists);
		return student;

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
		// return studentRepository.findByFirstNameAndLastName(firstName, lastName);
		return studentRepository.getByFirstNameAndLastName(firstName, lastName);
	}

	public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	public List<Student> getByFirstNameIn(InQueryRequest firstNames) {
		return studentRepository.findByFirstNameIn(firstNames.getFirstNames());
	}

	public List<Student> getAllByPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return studentRepository.findAll(pageable).getContent();
	}

	public List<Student> getAllBySorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		return studentRepository.findAll(sort);
	}

	public List<Student> like(String firstName) {
		return studentRepository.findByFirstNameContains(firstName);
	}

	public List<Student> getByStartsWithFirstName(String firstName) {
		return studentRepository.findByFirstNameStartsWith(firstName);
	}

	public Integer updateFirstNameAndLastName(Long id, String firstName, String lastName) {
		return studentRepository.updateFirstNameAndLastName(id, firstName, lastName);
	}

	public Integer deleteByFirstName(String firstName) {
		return studentRepository.deleteByFirstName(firstName);
	}

	public List<Student> getByAddressCity(String city) {
		
		//return studentRepository.findByAddressCity(city);
		return studentRepository.getByAddressCity(city);
	}

}
