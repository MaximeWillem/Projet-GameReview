// GameReview.js
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import stylesDetail from '../styles/details.module.css';

const GameReview = () => {
  const { id } = useParams();
  const [game, setGame] = useState(null);

  useEffect(() => {
    // Utilisez useEffect pour effectuer la requête une fois que le composant est monté
    axios.get(`https://backend-y8vx.onrender.com/game/${id}`)
      .then(response => {
        setGame(response.data);
      })
      .catch(error => {
        console.error('Une erreur s\'est produite lors de la récupération des données:', error);
      });
  }, [id]); // Assurez-vous de recharger les données lorsque l'ID change

  if (!game) {
    return <div>Chargement...</div>;
  }

  return (
    <div style={{ display: 'flex', textAlign: 'center' }} className={stylesDetail['background']}>
      <div style={{ flex: 3, padding: '20px' }}>
        <h1 style={{ color: '#fff', textTransform: 'uppercase' }}>{game.name}</h1>

        <img src={game.images} alt={game.name.toUpperCase()} style={{ width: '500px', height: '500px' }} />
        <h2 style={{ color: '#fff' }}>Description du jeu : </h2>
        <p style={{ color: '#fff', fontSize: '21px' }}>{game.description}</p>
      </div>
      <div style={{ flex: 1, padding: '20px'} }>
        <div style={{ position: 'fixed', bottom: 25 }}>
          <input type="text" placeholder="Ajouter un commentaire" required style={{ width:'300px' }} />
          <input type="submit"  value="send" style={{ marginLeft: 3 }}/>
        </div>
      </div>
    </div>
  );
}

export default GameReview;
