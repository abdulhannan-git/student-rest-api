package demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateStudentRequest {
	@JsonProperty("first_name")
	private String firstName;
	
	private String lastName;
	
	private String email;
}
