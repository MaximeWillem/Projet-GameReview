import React from 'react';
import styleConnexion from '../styles/connexion.module.css';
import { Link } from 'react-router-dom';

const connexion = () => {
    return (
        <div className={styleConnexion['background']}>
            <div className={styleConnexion['box']}>
                <div className={styleConnexion['container']}>
                    <span style={{ color: '#fff', textAlign: 'center' }}>
                        <Link to="/register" className={styleConnexion['lien']}>Have an account ?</Link>
                    </span>
                    <h1 className={styleConnexion['header']}>LOGIN</h1>
                    <div className={styleConnexion['input-field']}>
                        <input type="text" className={styleConnexion['input']} placeholder="Username" required />
                        <i className="bx bx-user"></i>
                    </div>
                    <div className={styleConnexion['input-field']}>
                        <input type="password" className={styleConnexion['input']} placeholder="Password" required />
                        <i className="bx bx-lock-alt"></i>
                    </div>
                    <div className={styleConnexion['input-field']}>
                        <input type="submit" className={styleConnexion['submit']} value="Login" />
                    </div>
                    <div className={`${styleConnexion['bottom']} ${styleConnexion['center']}`}>
                        <span style={{ color: '#fff', textAlign: 'center' }}>
                            <Link to="/" className={styleConnexion['lien']}>Sign as a guest</Link>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default connexion;
