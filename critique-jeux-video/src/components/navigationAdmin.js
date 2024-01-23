import React from 'react';
import { NavLink } from 'react-router-dom';
import stylesNaviguation from '../styles/navigation.module.css'; 




const navigationAdmin = () => {
    return (
        <div>
            <nav>
                <nav className={stylesNaviguation['nav']}>
                    <div className={stylesNaviguation['onglets']}>
                        <NavLink to="/accueilAdmin" className={stylesNaviguation['accueiladmin']} class="invitecolor"><ul>Home</ul></NavLink>
                        <NavLink to="/accueilAdmin/managementGame" className={stylesNaviguation['accueiladmin']} class="invitecolor"><ul>Management Game</ul></NavLink>
                        <NavLink to="/accueilAdmin/managementUser" className={stylesNaviguation['accueiladmin']} class="invitecolor"><ul>Management User</ul></NavLink>
                    </div>
                    <div style={{ backgroundColor: 'inherit', marginRight: 10, color: '#8f8f8f', textDecoration: 'none', padding: '8px 8px', marginTop: 10 }}>
                        <NavLink to="/register" style={{ textDecoration: 'none', color: '#fff', backgroundColor: '#f54266', border: 'none', marginRight: 30, fontSize: 20, padding: '15px 20px', outline: 'none', cursor: 'pointer' }}>Register</NavLink>
                        <NavLink to="/login" style={{ textDecoration: 'none', color: '#fff', backgroundColor: '#f54266', border: 'none', marginRight: 30, fontSize: 20, padding: '15px 20px', outline: 'none', cursor: 'pointer' }}>Login</NavLink>
                    </div>
                </nav>
            </nav>
        </div>
    );
};

export default navigationAdmin;


