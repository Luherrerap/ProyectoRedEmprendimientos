import React from 'react';
import Navbar2 from '../components/Navbar2'; 
import "../CSS/Sobrenosotros.css";

const Sobrenosotros = () => {
    return (
        <div className="sobre-nosotros-container">
            
            <Navbar2 />

            <section className="hero-sobre-nosotros">
                <h1>Sobre Nosotros</h1>
                <p>Ayudamos en el proceso de emprender</p>
            </section>
            <section className="contenido">
                <div className="mision-vision">
                    <div className="mision">
                        <h2>Misión</h2>
                        <p> Nuestra misión es fomentar el emprendimiento a través de una plataforma digital abierta, accesible y orientada a la colaboración, 
                            donde cualquier persona interesada en emprender pueda registrar su emprendimiento, obtener consejos y 
                            conectarse con otros emprendedores que enfrentan desafíos similares.
                            Ofrecemos un espacio confiable y enriquecedor que combine contenido generado por los usuarios con estadísticas relevantes,
                            recursos educativos, herramientas prácticas y datos actualizados sobre el ecosistema emprendedor, tanto a nivel local como nacional.
                            Queremos contribuir activamente al fortalecimiento del tejido emprendedor colombiano, facilitando el acceso al conocimiento, visibilizando
                            las historias reales detrás de los emprendimientos y promoviendo una cultura de innovación, resiliencia y colaboración.</p>
                    </div>
                    <div className="vision">
                        <h2>Visión</h2>
                        <p> Convertirnos en un punto de encuentro digital para emprendedores
                            creando una comunidad sólida, colaborativa y en constante crecimiento personal, donde cada persona con una idea, una 
                            historia o un proyecto encuentre el espacio ideal para compartir su experiencia, aprender de los demás, y acceder
                            a herramientas que impulsen su desarrollo personal y profesional.
                            Aspiramos a empoderar a miles de emprendedores de todos los rincones del país para que pongan en marcha su deseo de emprender,
                            adquieran conocimiento colectivo, inspiración mutua y el acceso a recursos clave permitan transformar ideas en realidades sostenibles y de alto
                            impacto para la sociedad.</p>
                    </div>
                </div>
            </section>
        </div>
    );
};

export default Sobrenosotros;
