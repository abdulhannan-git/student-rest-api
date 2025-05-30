package demo.response;

import demo.entity.Subject;
import lombok.Data;

@Data
public class SubjectResponse {
	private Long id;
	
	private String subjectName;
	
	private Double marksObtained;
	
	public SubjectResponse (Subject subject) {
		this.id=subject.getId();
		this.subjectName=subject.getSubjectName();
		this.marksObtained=subject.getMarksObtained();
	}
}
