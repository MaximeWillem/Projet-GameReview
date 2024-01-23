import React from 'react';

const addUser = () => {
    return (
        <div>
            <div className="top-header">
                <header>Add user</header>
            </div>
            <div className="input-field">
                <input type="text" className="input" placeholder="username" required />
                <i className="bx bx-user"></i>
            </div>
            <div className="input-field">
                <input type="text" className="input" placeholder="password" required />
                <i className="bx bx-user"></i>
            </div>
            <div className="input-field">
                <input type="submit" className="submit" value="Add user" />
            </div>
        </div>
    );
};

export default addUser;