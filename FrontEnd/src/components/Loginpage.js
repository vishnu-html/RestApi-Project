import React, { useState } from 'react';
import './Login.css';
import { Link } from 'react-router-dom';
import axios from "axios";
import { useNavigate } from 'react-router-dom';

function Login() {
  const [formData,setFormData]=useState({
    email:"",
    password:""
});
const[exists,setExists]=useState(false);
const[CheckPassword,SetCheckPassword]=useState(false);
const handleChange=(e)=>{
  setExists(false);
  SetCheckPassword(false);
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
     if(response.data==1){
      //console.log(formData);
      const response1 = await axios.get(`http://localhost:8087/get/${formData.email}`)
      if(response1.data==formData.password){
         navigate("/",{replace:true});
      }
      else{
           SetCheckPassword(true);
      }
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
    <div className='im'>
    <br></br><br></br><br></br><br></br>
    <div className="login-container">
      <h1><b>LOGIN</b></h1>
      <h2>MARKETPLACE FOR LOCALSERVICE</h2>

      
      <form onSubmit={handleLoginSubmit}>
        <label htmlFor="username" id='name1'>Email:</label>
        <input
          type="email"
          id="username"
          name="email"
          value={formData.email}
          onChange={handleChange}
          required
        />
       {exists ? (<label>User not Exists</label>):""}
        <label htmlFor="password" id='name2'>Password:</label>
        <input
          type="password"
          id="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          required
        />
        {CheckPassword ? (<label>Wrong Password</label>):""}
        <button type="submit"><b>Login</b></button>
        <Link to="/signup"><button id='hma'><b>Sign-up</b></button></Link>
      </form>
      </div>
    </div>
  );
}

export default Login;