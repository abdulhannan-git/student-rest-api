package demo.response;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

import demo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
	// @JsonIgnore
	// @Value("${student.id}")
	private long id;

	// @JsonIgnore
	@JsonProperty("first_name")
	@Value("${student.firstName}")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	private String email;
	private String fullName;

	/*
	 * public StudentResponse(long id, String firstName, String lastName) { super();
	 * this.id = id; this.firstName = firstName; this.lastName = lastName; }
	 */

	/*
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 * 
	 * public String getFirstName() { return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 */

	public StudentResponse(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.fullName = student.getFirstName() + " " + student.getLastName();
	}
}
