package com.example.day8.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day8.model.OnlineAppliance;
import com.example.day8.service.OnlineapplianceService;

@CrossOrigin
@RestController
public class OnlineApplianceController {
     
	@Autowired
	OnlineapplianceService r;
	
	@PostMapping("/post")
	public OnlineAppliance saveinfo(@RequestBody OnlineAppliance a) {
		return r.saveInfo(a);
	}
	@GetMapping("/get/{email}")
	public String getinfo(@PathVariable String email){
		return r.getInfoIn(email);
	}
	@GetMapping("/get2/{email}")
	public int getinfo1(@PathVariable String email){
		return r.getInfoUp(email);
	}
	
	
}
