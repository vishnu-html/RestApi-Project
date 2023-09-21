package com.example.day8.model;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OnlineAppliance {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	private String firstName;
	private String lastName;
	private String password;
	private int age;
	private String gender;
	private String email;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public OnlineAppliance(int bookId, String firstName, String middleName, String lastName, String password, int age,
			String gender, String email) {
		super();
	
		this.bookId = bookId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}
	public OnlineAppliance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
