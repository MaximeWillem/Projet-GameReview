import React from 'react';

const addGame = () => {
    return (
        <div>
            <div className="top-header">
                <header>Add Game</header>
            </div>
            <div className="input-field">
                <input type="text" className="input" placeholder="Title" required />
                <i className="bx bx-user"></i>
            </div>
            <div className="input-field">
                <input type="text" className="input" placeholder="Img" required />
                <i className="bx bx-user"></i>
            </div>
            <div className="input-field">
                <input type="submit" className="submit" value="Add game" />
            </div>
        </div>
    );
};

export default addGame;