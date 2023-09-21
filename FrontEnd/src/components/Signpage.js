import React from 'react';
import  { useState } from 'react';
import './Sign.css';
import axios from "axios";
import { useNavigate } from 'react-router-dom';


function Signpage() {
  const [formData,setFormData]=useState({
        firstName:"",
        middleName:"",
        lastName:"",
        gender:"",
        email:"",
        age:"",
        password:""
  });
  const[exists,setExists]=useState(false);
  const handleChange=(e)=>{
    setExists(false);
    const {name,value}=e.target;
    setFormData({
      ...formData,
      [name]:value,
    });
  }
  const navigate = useNavigate();
  const handleLoginSubmit=async(e)=>{
     e.preventDefault();
     try{
      const response = await axios.get(`http://localhost:8087/get2/${formData.email}`)
       if(response.data==0){
        console.log(formData);
        axios.post(`http://localhost:8087/post`,formData);
          navigate("/Login",{replace:true});
       }
       else{
         setExists(true);
       }
     }
     catch(error){
      console.log(error);
     }
  }
return (
    <div className='cc'>
    <div className='im1'>
    
    <div className="login-container1">
      <h1><b>REGISTRATION</b></h1>
      <h4>WELCOME TO LOCALSERVICE</h4>

      
      <form onSubmit={handleLoginSubmit}>
        <label htmlFor="first_name" >First Name:</label>
        <input
          type="text"
          className="username"
          name="firstName"
          value={formData.firstName}
          onChange={handleChange}
          required
        />
       
        <label htmlFor="username">Last Name:</label>
        <input
          type="text"
          className="username"
          name="lastName"
          value={formData.lastName}
          onChange={handleChange}
          required
        />
        <label htmlFor="username">Gender:</label>
        <input
          type="text"
          className="username"
          name="gender"
          value={formData.gender}
          onChange={handleChange}
          required
        />
        <label htmlFor="password">Email:</label>
        <input
          type="email"
          className="username"
          name="email"
          value={formData.email}
          onChange={handleChange}
          required
        />
         {exists ? (<label>User Already Exists</label>):''}
        <label htmlFor="username">Age:</label>
        <input
          type="number"
          className="username"
          name="age"
          value={formData.age}
          onChange={handleChange}
          required
        />

        <label htmlFor="username">Password:</label>
        <input
          type="password"
          className="username"
          name="password"
          value={formData.password}
          onChange={handleChange}
          required
        />

        <label htmlFor="username">Confirm Password:</label>
        <input
          type="password"
          className="username"
          name="username"
          required
        />

        <button type="submit" ><b>SUBMIT</b></button>
        
      </form>
      </div>
    </div>
    </div>
  );

}
export default Signpage;


