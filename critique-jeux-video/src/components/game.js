import React from 'react';
// Composant Game
function Game({ game }) {
  const openGameReview = () => {
    window.open(`/details/${game.id}`, '_blank');
  };

  return (
    <div className="card h-100" style={{ opacity: 0.9, backgroundColor: 'rgba(169, 169, 169, 0.5)', border: '1px solid white' }}>
      <div onClick={openGameReview} style={{ cursor: 'pointer' }}>
        <img src={game.images} className="card-img-top" alt={game.images} />
      </div>

      <div className="card-body">
        <h5 className="card-title" style={{ color: 'white' }}>{game.name}</h5>
      </div>
    </div>
  );
}

export default Game;