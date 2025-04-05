import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Registrarse from './pages/Registrarse'; // Importa la página Registrarse
import Login from './Pages/Login'; // Importa la página Login
import DatosPersonales from './pages/DatosPersonales'; // Importa la página DatosPersonales
import InformacionEmprendimiento from './pages/InformacionEmprendimiento'; // Importa la página InformacionEmprendimiento
import UsuarioPage from './pages/UsuarioPage'; // Importa la página UsuarioPage
import CrearPublicacion from './pages/CrearPublicacion'; // Importa la página CrearPublicacion
import Publicaciones from './pages/Publicaciones'; // Importa la página Publicaciones
import Emprendimientos from './pages/Emprendimientos'; // Importa la página Emprendimientos
import Estadisticas from './pages/Estadisticas'; // Importa la página Estadisticas
import Sobrenosotros from './pages/Sobrenosotros'; // Importa la página Sobrenosotros
import GuiasYRecursos from './pages/GuiasYRecursos'; // Importa la página GuiasYRecursos

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/registrarse" element={<Registrarse />} /> {/* Ruta para Registrarse */}
                <Route path="/ingresar" element={<Login />} /> {/* Ruta para Login */}
                <Route path="/datos-personales" element={<DatosPersonales />} /> {/* Ruta para DatosPersonales */}
                <Route path="/informacion-emprendimiento" element={<InformacionEmprendimiento />} /> {/* Ruta para InformacionEmprendimiento */}
                <Route path="/usuario" element={<UsuarioPage />} /> {/* Ruta para UsuarioPage */}
                <Route path="/crear-publicacion" element={<CrearPublicacion />} /> {/* Ruta para CrearPublicacion */}
                <Route path="/publicaciones" element={<Publicaciones />} /> {/* Ruta para Publicaciones */}
                <Route path="/emprendimientos" element={<Emprendimientos />} /> {/* Ruta para Emprendimientos */}
                <Route path="/estadisticas" element={<Estadisticas />} /> {/* Ruta para Estadisticas */}
                <Route path="/sobre-nosotros" element={<Sobrenosotros />} /> {/* Ruta para Sobrenosotros */}
                <Route path="/guias-recursos" element={<GuiasYRecursos />} /> {/* Ruta para GuiasYRecursos */}
            </Routes>
        </Router>
    );
}

export default App;