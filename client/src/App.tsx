import React from 'react';
import logo from './logo.svg';
import './App.css';
import Login from "./components/login/Login";
import Signup from "./components/login/Signup";
import Homepage from "./components/homepage/Homepage";
import Profile from './components/profile/Profile';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';

function App() {
  return (
    <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route index element={<Homepage/>}/>
        <Route path="profile" element={<Profile/>}/>
        <Route path="login" element={<Login/>}/>
        <Route path="signup" element={<Signup/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
