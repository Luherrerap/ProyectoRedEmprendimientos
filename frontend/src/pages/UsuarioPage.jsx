import React from 'react';
import NavbarUsuario from '../components/NavbarUsuario';
import HeroSectionUsuario from '../components/HeroSectionUsuario';
import '../CSS/UsuarioPage.css';

/**
 * Componente UsuarioPage.
 * 
 * Este componente representa la página principal del usuario autenticado.
 * Incluye una barra de navegación, una sección destacada (Hero Section) y un espacio para contenido adicional.
 * 
 * @returns {JSX.Element} Un componente que representa la página principal del usuario.
 */
function UsuarioPage() {
    return (
        <div className="usuario-page">
            <header>
                <NavbarUsuario />
            </header>
            <HeroSectionUsuario />
            <main className="usuario-content">
                <h1>Recuerda</h1>
                <p>
                    <li>Nadie tiene todas las respuestas, pero todos tenemos algo valioso que compartir.</li>
                    <li>Emprender no es el destino, es el camino que transforma ideas en impacto.</li>
                    <li>Hoy puedes inspirarte. Mañana, podrías ser tú quien inspire.</li>
                    <li>Comparte tu historia, aprende de otras, y haz crecer tu idea junto a una comunidad que te entiende.</li>
                </p>
            </main>
        </div>
    );
}

export default UsuarioPage;