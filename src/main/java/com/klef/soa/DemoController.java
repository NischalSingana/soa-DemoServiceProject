package com.klef.soa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	List<Employee> emplist = new ArrayList<Employee>();
	
	
	
	@GetMapping("/")
	public String home(){
		return "Demo Service Project";
	}
	@PostMapping("/addemp")
	public ResponseEntity<String> addemployee(@RequestBody Employee emp) {
		emplist.add(emp);
		return ResponseEntity.status(201).body("Employee Added Successfully");
	}
	
	@GetMapping("/displayallemps")
	public ResponseEntity<?> displayallemps() {
		if(emplist.size()>0) 
		{
		return ResponseEntity.ok(emplist);
		}
		else 
		{
			return ResponseEntity.status(404).body("Employee Data Not Found");
		}
	}
	@GetMapping("/empcount")
	public int empcount() {
		return emplist.size();
	}
	
	@GetMapping("add")
	public String add(@RequestParam int a, @RequestParam int b) {
		return "Output="+(a+b);
	}
	
	@GetMapping("sum/{a}/{b}")
	public String sum(@PathVariable int a, @PathVariable int b) {
		return "Output="+(a+b);
	}
	
	@GetMapping("demo/{fname}/{lname}")
	public String demo(@PathVariable String fname, @PathVariable String lname) {
		return fname+" "+lname;
	}
}
