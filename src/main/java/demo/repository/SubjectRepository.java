package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
