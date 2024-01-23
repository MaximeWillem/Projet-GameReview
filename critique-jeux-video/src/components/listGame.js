import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Game from './game';

function ListGame() {
  const [gameList, setGameList] = useState([]);

  useEffect(() => {
    // Utilisez useEffect pour effectuer la requête une fois que le composant est monté
    axios.get('https://backend-y8vx.onrender.com/game')
      .then(response => {
        setGameList(response.data);
      })
      .catch(error => {
        console.error('Une erreur s\'est produite lors de la récupération des données:', error);
      });
  }, []); // Les crochets vides signifient que cette fonction s'exécutera une seule fois à l'initialisation

  return (
    <div className="container mt-4">
      <div className="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
        {gameList.map((game) => (
          <div className="col mb-4" key={game.id}>
            <Game game={game} />
          </div>
        ))}
      </div>
    </div>
  );
}

export default ListGame;