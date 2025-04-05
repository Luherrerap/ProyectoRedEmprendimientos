import React from 'react';
import Navbar from '../components/Navbar'; 
import Herosection from '../components/Herosection'; 
import '../CSS/Home.css'; 


function Home() {
    return (
        <div className="home-page">
            {/* Barra de navegación */}
            <Navbar />

            {/* Hero Section */}
            <Herosection />

            {/* Contenido adicional */}
            <div className="additional-content">
                <h2>¿Por qué es importante el emprendimiento?</h2>
                <p>
                ¿Por qué es importante el emprendimiento?
                El emprendimiento es mucho más que iniciar un negocio. Es una forma de transformar ideas en soluciones reales que impactan la economía, la sociedad
                y la vida de las personas. En Colombia, el emprendimiento es una fuente de crecimiento, empleo y progreso regional. 
                Cada nuevo proyecto tiene el poder de generar oportunidades, innovar y construir un mejor futuro.
                Emprender también es un acto de valentía y pasión. Requiere creatividad, perseverancia y una mentalidad abierta al aprendizaje constante. 
                Por eso es fundamental que los emprendedores cuenten con un espacio donde puedan compartir sus experiencias, aprender de los demás y acceder a los 
                recursos que necesitan para crecer.
                </p>
                <h3> 🌐 ¿Por qué usar esta plataforma? </h3>
                <p>
                StartupNexus nace con el propósito de acompañarte en tu camino como emprendedor, ofreciéndote mucho más que un simple blog. 
                Aquí encontrarás una comunidad dinámica, inspiradora y colaborativa, diseñada para ayudarte a crecer personal y profesionalmente. Te ofrecemos:
                <li>✅ Historias reales de emprendedores como tú, que comparten sus aprendizajes, consejos y desafíos.</li>
                <li>✅ Visibilidad para tu emprendimiento, permitiéndote registrarlo y mostrarlo a otros usuarios.</li>
                <li>✅ Estadísticas y datos que te ayudarán a entender mejor el ecosistema emprendedor local y nacional.</li>
                <li>✅ Recursos útiles, guías y herramientas prácticas para facilitar tu proceso emprendedor.</li>
                <li>✅ Inspiración y motivación en cada publicación, para que sepas que no estás solo en este camino.</li>
                </p>
            </div>
        </div>
    );
}

export default Home;