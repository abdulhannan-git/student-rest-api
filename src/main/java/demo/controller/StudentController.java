package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.response.StudentResponse;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

	@Value("${spring.application.name: Default app name}")
	private String appName;

	// @GetMapping("/get")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getStudent() {
		return appName;
	}

	@GetMapping("/getJackson")
	public StudentResponse getStu() {
		return new StudentResponse(1, "Abdul", "Hannan");
	}
}
