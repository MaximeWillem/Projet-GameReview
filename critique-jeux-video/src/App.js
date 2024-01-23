import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Accueil from './pages/accueil';
import Connexion from './pages/connexion';
import Inscription from './pages/inscription';
import AccueilAdmin from './pages/accueilAdmin';
import ManagementGame from './pages/managementGame';
import ManagementUser from './pages/managementUser';
import GameReview from './pages/gamereview';


import 'bootstrap/dist/css/bootstrap.min.css';



const App = () => {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Accueil/>}/>
          <Route path='*' element={<Accueil/>}/>
          <Route path='/login' element={<Connexion/>}/>
          <Route path='/register' element={<Inscription/>}/>
          <Route path='/accueilAdmin' element={<AccueilAdmin/>}/>
          <Route path='/accueilAdmin/ManagementGame' element={<ManagementGame/>}/>
          <Route path='/accueilAdmin/ManagementUser' element={<ManagementUser/>}/>
          <Route path='/details/:id' element={<GameReview/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;