package com.example.day8.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.day8.model.OnlineAppliance;
import com.example.day8.repository.OnlineApplianceRepo;

@Service
public class OnlineapplianceService {
   @Autowired
   OnlineApplianceRepo r;
   
   public OnlineAppliance saveInfo(OnlineAppliance a) {
	   return r.save(a);
   }
   public String getInfoIn(String email) {
	   return  r.getSignIn(email);
   }
   public int getInfoUp(String email) {
	   return  r.getSignUp(email);
   }
   
}
