import React from 'react';
import { Link } from 'react-router-dom';

const inscriptonForm = () => {
    return (
        <div className="box">
      <div className="container">
        <div className="top-header">
          <span style={{ color: '#fff' }}>
            <Link to="/login" className='accueil'>Have an account?</Link>
          </span>
          <header>Create an account</header>
        </div>
        <div className="input-field">
          <input type="text" className="input" placeholder="Username" required />
          <i className="bx bx-user"></i>
        </div>
        <div className="input-field">
          <input type="text" className="input" placeholder="Email" required />
          <i className="bx bx-user"></i>
        </div>
        <div className="input-field">
          <input type="password" className="input" placeholder="Create password" required />
          <i className="bx bx-lock-alt"></i>
        </div>
        <div className="input-field">
          <input type="password" className="input" placeholder="Confirme password" required />
          <i className="bx bx-lock-alt"></i>
        </div>
        <div className="input-field">
          <input type="submit" className="submit" value="Register" />
        </div>
      </div>
    </div>
    );
};

export default inscriptonForm;