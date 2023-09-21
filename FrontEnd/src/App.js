import React, { useState } from 'react';
import Signpage from './components/Signpage';
import './App.css';
import Login from './components/Loginpage';
import Home from './components/Home';
import Get from './components/Get';
import {Routes,Route, BrowserRouter} from 'react-router-dom'

    
    const App = () => {
      return (
        
        <BrowserRouter>
        <Routes>
        <Route path='/Login' element={<Login/>}></Route>
        <Route path='/Signup' element={<Signpage/>}></Route>
        <Route path='/' element={<Home/>}></Route>
         <Route path='/Get' element={<Get/>}></Route>
        </Routes>
        </BrowserRouter>
        
      );
    };
    
    export default App;