package com.example.day8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.day8.model.OnlineAppliance;

@Repository
public interface OnlineApplianceRepo extends JpaRepository<OnlineAppliance, Integer>{
	
     @Query(value="select password From online_appliance where email=:s",nativeQuery = true)
     public String getSignIn(@Param("s") String OnlineAppliance);
     @Query(value="select  count(*) From online_appliance where email=:s",nativeQuery = true)
     public int getSignUp(@Param("s") String OnlineAppliance);
}
