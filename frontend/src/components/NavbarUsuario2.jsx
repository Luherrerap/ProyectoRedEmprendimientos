import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../CSS/NavbarUsuario.css';
import Icono from '../assets/Icono.jpg';

/**
 * Componente NavbarUsuario2.
 * 
 * Este componente representa una barra de navegación simplificada para usuarios.
 * Incluye un botón para redirigir a la página de usuario.
 * 
 * @returns {JSX.Element} Un componente que representa la barra de navegación simplificada para usuarios.
 */
function NavbarUsuario2() {
    const navigate = useNavigate();

    return (
        <nav className="navbar-usuario">
            <div className="navbar-left">
                <img src={Icono} alt="Logo" className="logo" />
                <div className="title">StartupNexus</div>
            </div>
            <div className="navbar-right">
                <button
                    className="nav-button"
                    onClick={() => navigate('/usuario')}
                >
                    Ir a Usuario
                </button>
            </div>
        </nav>
    );
}

export default NavbarUsuario2;