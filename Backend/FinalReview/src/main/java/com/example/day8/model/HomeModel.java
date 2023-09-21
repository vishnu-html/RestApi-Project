package com.example.day8.model;
import org.springframework.web.bind.annotation.CrossOrigin;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@CrossOrigin
@Entity
public class HomeModel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String productBrand;
	private int productEdition;
	private int price;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public int getProductEdition() {
		return productEdition;
	}
	public void setProductEdition(int productEdition) {
		this.productEdition = productEdition;
	}
	public int getProductWarrenty() {
		return price;
	}
	public void setProductWarrenty(int productWarrenty) {
		this.price = productWarrenty;
	}
	
	

	public HomeModel(int productId, String productName,String productBrand,
	int productEdition, int productWarrenty) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productEdition = productEdition;
		
	}
	public HomeModel() {
	super();
}
	
}
