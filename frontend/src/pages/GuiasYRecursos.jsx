import React from 'react';
import NavbarUsuario2 from "../components/NavbarUsuario2";
import '../CSS/GuiasYRecursos.css';

/**
 * Componente Guiasyrecursos.
 * 
 * Este componente muestra una recopilación de guías y recursos útiles para emprendedores.
 * Incluye enlaces a materiales como planes de negocio, fuentes de financiamiento, herramientas digitales y cursos gratuitos.
 * 
 * @returns {JSX.Element} Un componente que representa la página de guías y recursos.
 */
function Guiasyrecursos() {
    return (
        <div className="guias-recursos-page">
            <NavbarUsuario2 />
            <div className="guias-recursos-content">
                <h2>📚 Guías y Recursos para Emprendedores</h2>
                <p>Encuentra aquí una recopilación de materiales útiles para tu camino emprendedor.</p>
                <p>Este material se ira actualizando periodicamente para siempre ofrecerte la mejor y mas relevante informacion</p>
                
                <div className="recurso-card">
                    <h3>1. Cómo crear un plan de negocio</h3>
                    <p>Aprende a estructurar tu idea de negocio con estas guías prácticas y descargables:</p>
                    <ul>
                        <li>
                            <a href="https://www.jica.go.jp/paraguay/espanol/office/others/c8h0vm0000ad5gke-att/info_11_03.pdf" target="_blank" rel="noopener noreferrer">
                                Guía práctica para elaborar un plan de negocio (JICA)
                            </a>
                        </li>
                        <li>
                            <a href="https://lanzadera.es/como-hacer-plan-negocios/" target="_blank" rel="noopener noreferrer">
                                Cómo hacer un plan de negocios en 8 pasos (Lanzadera)
                            </a>
                        </li>
                    </ul>
                </div>

                <div className="recurso-card">
                    <h3>2. Fuentes de financiamiento y oportunidades para emprendedores</h3>
                    <p>Conoce opciones disponibles en Colombia para impulsar tu emprendimiento:</p>
                    <ul>
                        <li>
                            <a href="https://www.sena.edu.co/es-co/trabajo/Paginas/fondo-emprender.aspx" target="_blank" rel="noopener noreferrer">
                                Fondo Emprender del SENA
                            </a>
                        </li>
                        <li>
                            <a href="https://www.innpulsacolombia.com/" target="_blank" rel="noopener noreferrer">
                                iNNpulsa Colombia
                            </a>
                        </li>
                        <li>
                            <a href="https://www.bancoldex.com/" target="_blank" rel="noopener noreferrer">
                                Bancóldex – Soluciones Financieras para empresas
                            </a>
                        </li>
                    </ul>
                </div>

                <div className="recurso-card">
                    <h3>3. Herramientas digitales esenciales</h3>
                    <p>Utiliza estas plataformas para mejorar la gestión, productividad y operaciones de tu negocio:</p>
                    <ul>
                        <li>
                            <a href="https://xepelin.com/blog/pymes/herramientas-digitales-2025" target="_blank" rel="noopener noreferrer">
                                Herramientas digitales recomendadas para 2025 – Xepelin
                            </a>
                        </li>
                        <li>
                            <a href="https://gestifis.com/blog/los-6-mejores-softwares-para-emprendedores-en-2025/" target="_blank" rel="noopener noreferrer">
                                Mejores softwares para emprendedores 2025 – Gestifis
                            </a>
                        </li>
                        <li>
                            <a href="https://escala.uno/herramientas-digitales-pymes-2025/" target="_blank" rel="noopener noreferrer">
                                Herramientas digitales para pymes – Escala
                            </a>
                        </li>
                    </ul>
                </div>

                <div className="recurso-card">
                    <h3>4. Cursos gratuitos recomendados</h3>
                    <p>Capacítate gratis con estos cursos y plataformas en línea:</p>
                    <ul>
                        <li>
                            <a href="https://www.scu.edu/mobiespanol/" target="_blank" rel="noopener noreferrer">
                                Cursos de Negocios Gratuitos – MOBI (Universidad de Santa Clara)
                            </a>
                        </li>
                        <li>
                            <a href="https://emprendimiento.condusef.gob.mx/" target="_blank" rel="noopener noreferrer">
                                Curso de Emprendimiento – CONDUSEF
                            </a>
                        </li>
                        <li>
                            <a href="https://www.undp.org/es/Mooc_Negocio_Impacto" target="_blank" rel="noopener noreferrer">
                                Curso de Negocios de Impacto – PNUD
                            </a>
                        </li>
                        <li>
                            <a href="https://www.youtube.com/watch?v=6MvduTEHOVU" target="_blank" rel="noopener noreferrer">
                                Aprende a Emprender – Curso en YouTube
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    );
}

export default Guiasyrecursos;

