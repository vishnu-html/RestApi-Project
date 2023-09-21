package com.example.day8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.day8.model.HomeModel;

import jakarta.transaction.Transactional;

public interface HomeRepo extends JpaRepository<HomeModel, Integer> {

	@Query(value="select * from billpro where custid=:s or custname=:sn",nativeQuery=true)
	public List<HomeModel> getAccInfo(@Param("s") int id,@Param("sn") String name);
	
	@Modifying 
	@Transactional
	@Query(value = "update billpro set custname=:n where billno=:bill",nativeQuery = true)
	public int updatebybillno(String n,int bill);
	
	@Modifying
	@Transactional
	@Query(value = "delete from billpro where billno=:s",nativeQuery = true)
	public int deleteBillInfo(@Param("s") int billno);
	
	
}