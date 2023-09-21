//import React,{useState} from 'react';
import { Link } from 'react-router-dom';
import './Home.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import React, { components,useState } from "react";

const Home = () => {
  const [productId, setId] = useState('');
  const[productName,setName]=useState('');
  const[productBrand,setBrand]=useState('');
  const[productEdition,setEdition]=useState('');
  const[productWarrenty,setWarrenty]=useState('');
 

  const[id,setId1]=useState('');
  
  const handleGet =() =>{

  }
  const handlePut =() =>{
    
  }
  const handleDelete = () => {
    // Convert the ID to a number (assuming it's a numeric ID)
    const idToDelete = parseInt(productId);

    if (!idToDelete) {
      // Handle the case where id is not a valid number
      alert('Please enter a valid ID to delete.');
      return;
    }


    axios
      .delete(`http://localhost:8087/delid/${productId}`)
      .then((response) => {
        console.log('Successfully deleted:', response.data);
        
      })
      .catch((error) => {
        console.error('Error deleting:', error);
      });
  }


  const handlePost = (e) =>{
    e.preventDefault();
    axios.post('http://localhost:8087/addbill',
    {
    product_id:productId,
    productName:productName,
    productBrand:productBrand,
    productEdition:productEdition,
    productWarrenty:productWarrenty,
  }
    )
};

  return (
    <center><div className='homes'>
    <center><b><h2>WELCOME TO LOCALSERVICE</h2></b></center>
    
      <div class='container'>
      <form class='form-table'>

      <div className='form-group'>
      <label>Product Id :</label>
      <input class="form-control"
      type='number'
      placeholder='Enter your Product Id'
      value={productId}
      onChange={(e) => setId(e.target.value)}></input>
      <br></br>
      </div>
      
      <div className='form-group'>
      <label>Product Name :</label>
      <input class="form-control"
      type='text'
      placeholder='Enter the Product Name'
      value={productName}
      onChange={(e) => setName(e.target.value)}></input>
      </div>

      <div className='form-group'>
      <label>Product Brand :</label>
      <input class="form-control"
      type='text'
      placeholder='Enter the Product Brand'
      value={productBrand}
      onChange={(e) => setBrand(e.target.value)}></input>
      </div>

     <div class='form-group'>
      <label>Product Batch :</label>
      <input class="form-control"
      type='text'
      placeholder='Enter the Product Batch'
      value={productEdition}
      onChange={(e) => setEdition(e.target.value)}></input>
      </div>

      <div class='form-group'>
      <label>Price :</label>
      <input class="form-control"
      type='number'
      placeholder='Enter the Price'
      value={productWarrenty}
      onChange={(e) => setWarrenty(e.target.value)}></input>
      </div>

      
      <div class="buttons">
      <button id='but' class="btn btn-info" onClick={handlePost}><b>POST</b></button>
      <button id='but' class="btn btn-danger" onClick={handleGet}><b><a href="/Get">GET</a></b></button>
      <button id='but' class="btn btn-info" onClick={handlePut}><b>PUT</b></button>

      <br></br><br></br>
      <div class='form-group'>
      <label>DELETE ID:</label>
      <input class="form-control"
      type='number'
      placeholder='Enter the Id to delete'
      value={productId}
      onChange={(e) => setId(e.target.value)}></input>
      </div>  
      <button id='but' class="btn btn-info" onClick={handleDelete}><b>DELETE</b></button></div>
      </form>
      </div>
    </div></center>
  );
};

export default Home;