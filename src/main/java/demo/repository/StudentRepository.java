package demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);

	List<Student> findByLastName(String lastName);

	List<Student> findByFirstNameAndLastName(String firstName, String lastName);

	List<Student> findByFirstNameOrLastName(String firstName, String lastName);

	List<Student> findByFirstNameIn(List<String> firstName);

	List<Student> findByFirstNameContains(String firstName);

	List<Student> findByFirstNameStartsWith(String firstName);

	@Query("From Student where firstName=:firstName and lastName=:lastname")
	List<Student> getByFirstNameAndLastName(String firstName, @Param("lastname") String lastName);

	@Modifying
	@Transactional
	@Query("Update Student s set s.firstName=:firstname, s.lastName=:lastName where s.id =:id")
	Integer updateFirstNameAndLastName(Long id, @Param("firstname") String firstName, String lastName);
	
	@Modifying
	@Transactional
	@Query("Delete from Student where firstName=:firstName")
	Integer deleteByFirstName(String firstName);

}
