import React from 'react';
import NavigationAdmin from '../components/navigationAdmin';
import AddGame from '../components/addGame';
import RemoveGame from '../components/removeGame';
import UpdateGame from '../components/updateGame';

const ManagementGame = () => {
    return (
        <div style={{ display: 'flex', marginTop: 80, textAlign:'center'}}>
            <NavigationAdmin />

            <div style={{ flex: 1 }}>
                <AddGame />
            </div>

            <div style={{ flex: 1 }}>
                <RemoveGame />
            </div>

            <div style={{ flex: 1 }}>
                <UpdateGame />
            </div>
        </div>
    );
};

export default ManagementGame;
