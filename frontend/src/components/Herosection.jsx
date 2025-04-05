import React from 'react';
import '../CSS/Herosection.css';

/**
 * Componente Hero Section.
 * 
 * Este componente muestra una sección destacada en la página principal con información
 * sobre la plataforma y un llamado a la acción para los usuarios.
 * 
 * @returns {JSX.Element} Un componente que representa la sección destacada de la página.
 */
function Herosection() {
    return (
        <div className="hero-section">
            <div className="hero-content">
                <h1 className="hero-title">🚀 Impulsa tu Emprendimiento con Startup Nexus</h1>
                <p className="hero-description">
                    Descubre herramientas, recursos, datos y una comunidad de emprendedores en un solo lugar.
                </p>
                <h2 className="hero-subtitle">Registrate y empieza a: </h2>
                <ul className="hero-list">
                    <li>🔹 Compartir tu experiencia</li>
                    <li>🔹 Conocer sobre otros emprendedores y sus consejos</li>
                    <li>🔹 Obtener informacion util para tu camino emprendedor</li>
                </ul>
                <p className="hero-call-to-action">¡Únete hoy y comienza a construir tu futuro!</p>
            </div>
        </div>
    );
}

export default Herosection;