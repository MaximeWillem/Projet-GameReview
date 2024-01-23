import React from 'react';
import NavigationAdmin from '../components/navigationAdmin';
import AddUser from '../components/addUser';
import RemoveUser from '../components/removeUser';
import UpdateUser from '../components/updateUser';

const managementUser = () => {
    return (
        <div style={{ display: 'flex', marginTop: 80, textAlign:'center'}}>
            <NavigationAdmin />
                <div style={{ flex: 1 }}>
                    <AddUser/>
                </div>
                <div style={{ flex: 1 }}>
                    <RemoveUser/>
                </div>
                <div style={{ flex: 1 }}>
                    <UpdateUser/>
                </div>
        </div>
    );
};

export default managementUser;