package com.tek.restcontroller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tek.models.Login;
import com.tek.models.ResponseObj;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class LoginController {
	
	@GetMapping("login")
	private String login() {
		System.out.println(">>>>>> Invoked :::: Login Service <<<<<<<<");
		//System.out.println("Login username :: "+login.getUserName());
		return "Authenticated";
	}
	
	@PostMapping("employeelogin")
	private ResponseEntity<ResponseObj> employeeLogin(@RequestBody Login login) {
		System.out.println("::::::: Invoked EmployeeLogin Service for user >> "+login.getUserName());
		ResponseObj obj = new ResponseObj();
		obj.setAuthenticated(true);
		obj.setStatus("ok");
		obj.setStatusCode("1212");
		obj.setStatusText("Authenticated");
		return new ResponseEntity<ResponseObj>(obj, new HttpHeaders(), HttpStatus.OK);
	}
	
}
