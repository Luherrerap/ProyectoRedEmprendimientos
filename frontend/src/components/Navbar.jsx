import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../CSS/NavbarUsuario.css'; 
import Icono from '../assets/Icono.jpg';

/**
 * Componente Navbar.
 * 
 * Este componente representa la barra de navegación principal de la aplicación.
 * Incluye enlaces y botones para navegar entre diferentes páginas.
 * 
 * @returns {JSX.Element} Un componente que representa la barra de navegación.
 */
function Navbar() {
    const navigate = useNavigate(); // Hook para manejar la navegación

    return (
        <nav className="navbar-usuario">
            {/* Izquierda: logo + título */}
            <div className="navbar-left">
                <img src={Icono} alt="Logo" className="logo" />
                <div className="title">StartupNexus 🚀</div>
            </div>

            {/* Derecha: enlaces y botones */}
            <div className="navbar-right">
                <span
                    className="nav-link"
                    onClick={() => navigate('/sobre-nosotros')} // Redirige a la página Sobre Nosotros
                >
                    Sobre Nosotros
                </span>
                <button
                    className="nav-button"
                    onClick={() => navigate('/registrarse')} // Redirige a la página de registro
                >
                    Registrarse
                </button>
                <button
                    className="nav-button"
                    onClick={() => navigate('/ingresar')} // Redirige a la página de inicio de sesión
                >
                    Ingresar
                </button>
            </div>
        </nav>
    );
}

export default Navbar;
