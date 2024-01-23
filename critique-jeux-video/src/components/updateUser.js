import React from 'react';

const updateUser = () => {
    return (
        <div>
            <div className="top-header">
                <header>Update user</header>
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
                <input type="submit" className="submit" value="Update user" />
            </div>
        </div>
    );
};

export default updateUser;