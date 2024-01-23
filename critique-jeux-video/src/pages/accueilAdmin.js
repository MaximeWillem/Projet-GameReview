import React from 'react';
import NavigationAdmin from '../components/navigationAdmin';
import ListGame from '../components/listGame';
import styleAccueil from '../styles/accueil.module.css';

const accueilAdmin = () => {
    return (
        <div className={styleAccueil['background']}>
            <NavigationAdmin/>
            <h1 className={styleAccueil['h1']}>Liste des jeux</h1>
            <ListGame/>
        </div>
    );
};

export default accueilAdmin;