import React from 'react';
import '../CSS/HeroSectionUsuario.css';

/**
 * Componente Hero Section Usuario.
 * 
 * Este componente muestra una sección destacada en el panel de usuario, proporcionando
 * opciones y motivación para interactuar con la plataforma.
 * 
 * @returns {JSX.Element} Un componente que representa la sección destacada del panel de usuario.
 */
function HeroSectionUsuario() {
    return (
        <div className="hero-section-usuario">
            <div className="hero-content-usuario">
                <h1 className="hero-title-usuario">🎯 Bienvenido a tu Panel</h1>
                <p className="hero-description-usuario">
                    Aquí puedes compartir experiencias y conocer lo que otros emprendedores tienen para decir.
                </p>
                <h2 className="hero-subtitle-usuario">¿Qué deseas hacer hoy?</h2>
                <ul className="hero-list-usuario">
                    <li>💡 Compartir tus consejos y experiencia</li>
                    <li>📊 Consultar estadísticas de emprendimiento</li>
                    <li>📚 Acceder a guías y recursos</li>
                    <li>🌐 Conocer la historia de otro emprendedor</li>
                </ul>
                <p className="hero-call-to-action-usuario">¡Explora, aprende y haz crecer tu idea! 🚀</p>
            </div>
        </div>
    );
}

export default HeroSectionUsuario;
