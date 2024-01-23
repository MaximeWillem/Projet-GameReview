// Navigation.js
import React from 'react';
import { NavLink } from 'react-router-dom';
import stylesNaviguation from '../styles/navigation.module.css'; 

const Navigation = () => {
  return (
    <nav className={stylesNaviguation['nav']}>
      <div className={stylesNaviguation['onglets']}>
        <ul>
          <li className={stylesNaviguation['accueil']}>Games</li>
        </ul>
      </div>

        <div style={{ backgroundColor: 'inherit', marginRight: 10, color: '#8f8f8f', textDecoration: 'none', padding: '8px 8px', marginTop: 10 }}>
            <NavLink to="/register" style={{ textDecoration: 'none', color: '#fff', backgroundColor: '#f54266', border: 'none', marginRight: 30, fontSize: 20, padding: '15px 20px', outline: 'none', cursor: 'pointer' }}>Register</NavLink>
            <NavLink to="/login" style={{ textDecoration: 'none', color: '#fff', backgroundColor: '#f54266', border: 'none', marginRight: 30, fontSize: 20, padding: '15px 20px', outline: 'none', cursor: 'pointer' }}>Login</NavLink>
        </div>
      
  
    </nav>
  );
};

export default Navigation;
