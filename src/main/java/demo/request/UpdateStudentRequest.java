package demo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateStudentRequest {
	@NotNull(message = "Student id is mandatory, required.")
	private Long id;
	private String first_name;
	private String last_name;
	private String email;
}
