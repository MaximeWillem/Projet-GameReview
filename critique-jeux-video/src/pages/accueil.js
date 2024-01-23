import React from 'react';
import Naviguation from '../components/navigation';
import ListGame from '../components/listGame';
import styleAccueil from '../styles/accueil.module.css';


const accueil = () => {
    return (
        <div className={styleAccueil['background']}>
            <Naviguation/>
            <h1 className={styleAccueil['h1']}>Liste des jeux</h1>
            <ListGame/>
        </div>
    );
};

export default accueil;