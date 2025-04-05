import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../CSS/NavbarUsuario.css';

/**
 * Componente Navbar2.
 * 
 * Este componente representa una barra de navegación simplificada con un botón
 * para volver a la página principal.
 * 
 * @returns {JSX.Element} Un componente que representa la barra de navegación simplificada.
 */
function Navbar2() {
    const navigate = useNavigate();

    return (
        <nav className="navbar-usuario">
            <div className="navbar-left"></div>
            <div className="navbar-right">
                <button
                    className="nav-button"
                    onClick={() => navigate('/')}
                >
                    Volver a la página principal
                </button>
            </div>
        </nav>
    );
}

export default Navbar2;