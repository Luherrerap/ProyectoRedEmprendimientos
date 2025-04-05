import React from 'react';
import { useNavigate } from 'react-router-dom';
import { logoutUsuario } from '../api';
import '../CSS/NavbarUsuario.css';
import Icono from '../assets/Icono.jpg';

/**
 * Componente NavbarUsuario.
 * 
 * Este componente representa la barra de navegación para usuarios autenticados.
 * Incluye botones para navegar entre diferentes secciones de la aplicación y un botón para cerrar sesión.
 * 
 * @returns {JSX.Element} Un componente que representa la barra de navegación para usuarios autenticados.
 */
function NavbarUsuario() {
    const navigate = useNavigate();

    /**
     * Maneja el cierre de sesión del usuario.
     * Elimina el ID del usuario del almacenamiento local y redirige a la página principal.
     */
    const handleLogout = async () => {
        try {
            await logoutUsuario();
            localStorage.removeItem('userId');
            navigate('/');
        } catch (error) {
            console.error('Error al cerrar sesión:', error);
        }
    };

    return (
        <nav className="navbar-usuario">
            <div className="navbar-left">
                <img src={Icono} alt="Logo" className="logo" />
                <div className="title">StartupNexus</div>
            </div>
            <div className="navbar-right">
                <button
                    className="nav-button"
                    onClick={() => navigate('/crear-publicacion')}
                >
                    Crear Publicación
                </button>
                <button
                    className="nav-button"
                    onClick={() => navigate('/publicaciones')}
                >
                    Ver Todas las Publicaciones
                </button>
                <button
                    className="nav-button"
                    onClick={() => navigate('/emprendimientos')}
                >
                    Ver Todos los Emprendimientos
                </button>
                <button
                    className="nav-button"
                    onClick={() => navigate('/estadisticas')}
                >
                    Estadísticas
                </button>
                <button
                    className="nav-button"
                    onClick={() => navigate('/guias-recursos')}
                >
                    Guías y Recursos
                </button>
                <button
                    className="nav-button logout-button"
                    onClick={handleLogout}
                >
                    Cerrar Sesión
                </button>
            </div>
        </nav>
    );
}

export default NavbarUsuario;
