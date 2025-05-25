package demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateStudentRequest {
	@JsonProperty("first_name")
	@NotBlank(message = "First name is mandatory, required.")
	private String firstName;

	private String lastName;

	private String email;

	private String street;
	private String city;
}
