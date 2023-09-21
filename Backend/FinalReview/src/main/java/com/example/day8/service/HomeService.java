package com.example.day8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day8.model.HomeModel;

import com.example.day8.repository.HomeRepo;

@Service
public class HomeService {
    
	@Autowired
	HomeRepo hrepo;
	
	public HomeModel saveInfo(HomeModel h)
	{
		return hrepo.save(h);
	}
	
	public List<HomeModel> savedetails(List<HomeModel> ss)
    {
    	return (List<HomeModel>)hrepo.saveAll(ss);
    }
	
	public List<HomeModel> showInfo()
	{
		return hrepo.findAll();
	}
	public HomeModel changeInfo(HomeModel ss)
    {
    	return hrepo.saveAndFlush(ss);
    }
    public void deleteInfo(HomeModel ss)
    {
    	hrepo.delete(ss);
    }
    public void deleteid(int custid)
    {
    	hrepo.deleteById(custid);
    }
    
    public Optional <HomeModel> showbyid(int id)
    {
      return hrepo.findById(id);	
    }
    
    public String updateinfoById(int id,HomeModel ss) {
    	hrepo.saveAndFlush(ss);
    	if(hrepo.existsById(id))
    	{
    		return "Updated";
    	}
    	else{
    		return "Enter the valid Id";
    	}
    }
    
    public List<HomeModel> sort(String str)
    {
    	return hrepo.findAll(Sort.by(str).descending());
    }
    
    public List<HomeModel> paging(int cur,int tot)
    {
    	Page<HomeModel> page=hrepo.findAll(PageRequest.of(cur,tot));
    	return page.getContent();
    	
    }
    
    public List<HomeModel> pageandsort(int cur,int tot,String str)
    {
    	Page<HomeModel> page=hrepo.findAll(PageRequest.of(cur,tot,Sort.by(str)));
    	return page.getContent();
    }
    
    public List<HomeModel> getbyname(int id,String name)
    {
    	return hrepo.getAccInfo(id,name);
    }
    public int updatename(String n,int b) {
    	return hrepo.updatebybillno(n, b);
    }
    
    public int deleteName(int no)
    {
    	return hrepo.deleteBillInfo(no);
    }
    
}