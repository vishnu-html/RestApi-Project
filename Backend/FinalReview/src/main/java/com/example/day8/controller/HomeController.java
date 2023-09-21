package com.example.day8.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day8.model.HomeModel;

import com.example.day8.service.HomeService;

@CrossOrigin
@RestController
public class HomeController {
  
	@Autowired
	HomeService hserv;
	
	@PostMapping("/addbill")
	public HomeModel add(@RequestBody HomeModel ss)
	{
		return hserv.saveInfo(ss);
	}
	
	@PostMapping("/addmul")
	public List<HomeModel> addndetails(@RequestBody List<HomeModel> ss)
	{
		return hserv.savedetails(ss);
	}
	
	@GetMapping("/showbill")
	public List<HomeModel> show()
	{
		return hserv.showInfo();
	}
	
	@PutMapping("update")
	public HomeModel modify(@RequestBody HomeModel ss)
	{
		return hserv.changeInfo(ss);
	}
	
	@DeleteMapping("/deletedetail")
	public String del(@RequestBody HomeModel ss)
	{
		hserv.deleteInfo(ss);
		return "DELETED SUCCESSFULLY";
	}
	
	@DeleteMapping("/delid/{productid}")
	public String deletemyid(@PathVariable int productid)
	{
		hserv.deleteid(productid);
		return "deleted cust id";
	}
	
	@DeleteMapping("/delparamid")
	public String deleteparamid(@RequestParam int custid)
	{
		hserv.deleteid(custid);
		return "deleted parameter id";
	}
	
	@GetMapping("/showbyId/{id}")
	public Optional<HomeModel> showid(@PathVariable int id)
	{
		return hserv.showbyid(id);
	}
	
	@PutMapping("/updateinfo/{id}")
	public String updateInfoById(@PathVariable int id,@RequestBody HomeModel ss)
	{
		return hserv.updateinfoById(id, ss);
	}
	
	@GetMapping("/sort/{str}")
	public List<HomeModel> sort(@PathVariable String str)
	{
		return hserv.sort(str);
	}
	
	@GetMapping("/paging/{cur}/{tot}")
	public List<HomeModel> paging(@PathVariable int cur,@PathVariable int tot)
	{
		return hserv.paging(cur, tot);
	}
	
	@GetMapping("/pageandsort/{cur}/{tot}/{str}")
	public List<HomeModel> pageandsort(@PathVariable int cur,@PathVariable int tot,@PathVariable String str)
	{
		return hserv.pageandsort(cur, tot, str);
	}
	
	@GetMapping("/getbyname/{id}/{name}")
	public List<HomeModel> getbyname(@PathVariable int id,@PathVariable String name)
	{
		return hserv.getbyname(id, name);
	}
	
	@PutMapping("/updatename/{id}/{name}")
	public String updatename(@PathVariable int id,@PathVariable String name) {
		return hserv.updatename(name,id)+" updated";
	}
	
	@DeleteMapping("/deletename/{no}")
	public int deletename(@PathVariable int no)
	{
		return hserv.deleteName(no);
	}
}