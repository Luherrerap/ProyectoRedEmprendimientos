import React, { useEffect, useState } from "react";
import {
    obtenerEmprendimientosPorCategoria,
    obtenerEmprendimientosPorRegion,
    obtenerEmprendimientosPorGenero,
} from "../api";
import {
    BarChart,
    Bar,
    XAxis,
    YAxis,
    CartesianGrid,
    Tooltip,
    Legend,
    ResponsiveContainer,
    RadarChart,
    PolarGrid,
    PolarAngleAxis,
    PolarRadiusAxis,
    Radar,
    PieChart,
    Pie,
    Cell,
} from "recharts";
import NavbarUsuario2 from "../components/NavbarUsuario2"; 
import "../CSS/Estadisticas.css";

/**
 * Componente Estadisticas.
 * 
 * Este componente muestra estadísticas visuales sobre los emprendimientos registrados en la plataforma.
 * Incluye gráficos de barras, radar y pastel para representar datos por categoría, región y género.
 * 
 * @returns {JSX.Element} Un componente que representa la página de estadísticas.
 */
function Estadisticas() {
    const [datosCategoria, setDatosCategoria] = useState([]);
    const [datosRegion, setDatosRegion] = useState([]);
    const [datosGenero, setDatosGenero] = useState([]);
    const [loadingCategoria, setLoadingCategoria] = useState(true);
    const [loadingRegion, setLoadingRegion] = useState(true);
    const [loadingGenero, setLoadingGenero] = useState(true);
    const [errorCategoria, setErrorCategoria] = useState("");
    const [errorRegion, setErrorRegion] = useState("");
    const [errorGenero, setErrorGenero] = useState("");

    const COLORS = ["#0088FE", "#00C49F", "#FFBB28", "#FF8042"];

    /**
     * Efecto para cargar los datos de estadísticas al montar el componente.
     * Obtiene datos por categoría, región y género desde la API.
     */
    useEffect(() => {
        const fetchDatosCategoria = async () => {
            try {
                const data = await obtenerEmprendimientosPorCategoria();
                const datosFormateados = data.map((item) => ({
                    categoria: item[0],
                    cantidad: item[1],
                }));
                setDatosCategoria(datosFormateados);
                setLoadingCategoria(false);
            } catch (err) {
                console.error("Error al cargar los datos de estadísticas por categoría:", err);
                setErrorCategoria("Hubo un error al cargar los datos de estadísticas por categoría.");
                setLoadingCategoria(false);
            }
        };

        const fetchDatosRegion = async () => {
            try {
                const data = await obtenerEmprendimientosPorRegion();
                const datosFormateados = data.map((item) => ({
                    region: item[0],
                    cantidad: item[1],
                }));
                setDatosRegion(datosFormateados);
                setLoadingRegion(false);
            } catch (err) {
                console.error("Error al cargar los datos de estadísticas por región:", err);
                setErrorRegion("Hubo un error al cargar los datos de estadísticas por región.");
                setLoadingRegion(false);
            }
        };

        const fetchDatosGenero = async () => {
            try {
                const data = await obtenerEmprendimientosPorGenero();
                const datosFormateados = data.map((item) => ({
                    genero: item.genero,
                    cantidad: item.cantidad,
                }));
                setDatosGenero(datosFormateados);
                setLoadingGenero(false);
            } catch (err) {
                console.error("Error al cargar los datos de estadísticas por género:", err);
                setErrorGenero("Hubo un error al cargar los datos de estadísticas por género.");
                setLoadingGenero(false);
            }
        };

        fetchDatosCategoria();
        fetchDatosRegion();
        fetchDatosGenero();
    }, []);

    if (loadingCategoria || loadingRegion || loadingGenero) {
        return <p className="loading">Cargando estadísticas...</p>;
    }

    if (errorCategoria || errorRegion || errorGenero) {
        return (
            <div>
                {errorCategoria && <p className="error">{errorCategoria}</p>}
                {errorRegion && <p className="error">{errorRegion}</p>}
                {errorGenero && <p className="error">{errorGenero}</p>}
            </div>
        );
    }

    return (
        <div className="estadisticas-page">
            {/* Barra de navegación */}
            <NavbarUsuario2 />

            <div className="estadisticas-content">
                <h1 className="page-title">📊 Estadísticas de Emprendimientos</h1>

                {/* Tarjeta: Categoría */}
                <div className="recurso-card">
                    <h3>Emprendimientos por Categoría en StartupNexus</h3>
                    <ResponsiveContainer width="100%" height={400}>
                        <BarChart data={datosCategoria} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
                            <CartesianGrid strokeDasharray="3 3" />
                            <XAxis dataKey="categoria" />
                            <YAxis />
                            <Tooltip />
                            <Legend />
                            <Bar dataKey="cantidad" fill="#8884d8" name="Cantidad de Emprendimientos" />
                        </BarChart>
                    </ResponsiveContainer>
                    <p className="context-text">
                    <p>
                    📊 Distribución de emprendimientos por categoría:
                    </p>
                    En los últimos años, la categoría de Tecnología ha liderado el crecimiento del ecosistema
                    emprendedor en Colombia, impulsada por la transformación digital y la demanda de soluciones innovadoras. Según datos de iNNpulsa y otras fuentes, 
                    aproximadamente el 30% de los nuevos emprendimientos están relacionados con el sector tecnológico, incluyendo desarrollo de software, apps, 
                    inteligencia artificial y servicios digitales.

                    <p>
                        Por otro lado, categorías como Salud y Bienestar, Educación y Comercio y Retail han ganado gran relevancia tras la pandemia, 
                        reflejando nuevas necesidades sociales y cambios en los hábitos de consumo. El auge de plataformas de educación online, e-commerce y soluciones 
                        para la salud mental y física han marcado una fuerte tendencia entre emprendedores jóvenes.
                    </p>
                    <p>     
                        Además, el interés por proyectos sostenibles también ha crecido: más del 10% de los nuevos emprendimientos tienen como eje el  
                        cuidado del medio ambiente, energías limpias y prácticas responsables. Esto demuestra un compromiso creciente con los 
                        Objetivos de Desarrollo Sostenible (ODS).
                    </p>
                    <p>🧠 ¿Cómo interpretar esta gráfica?</p>
                    <p> 
                        Cada barra representa el número total de emprendimientos registrados en la plataforma según su categoría. Este análisis permite identificar 
                        cuáles son los sectores con mayor presencia en nuestra comunidad y detectar nuevas oportunidades para innovar y colaborar.</p>
                    </p>
                </div>

                {/* Tarjeta: Región */}
                <div className="recurso-card">
                    <h3>Emprendimientos por Región en StartupNexus</h3>
                    <ResponsiveContainer width="100%" height={400}>
                        <RadarChart data={datosRegion}>
                            <PolarGrid />
                            <PolarAngleAxis dataKey="region" />
                            <PolarRadiusAxis />
                            <Tooltip />
                            <Radar
                                name="Cantidad de Emprendimientos"
                                dataKey="cantidad"
                                stroke="#82ca9d"
                                fill="#82ca9d"
                                fillOpacity={0.6}
                            />
                        </RadarChart>
                    </ResponsiveContainer>
                    <p className="context-text">
                        <p>🗺️ Distribución de emprendimientos por región:</p>
                        <p>Explorar estas estadísticas te ayudará a entender dónde están surgiendo nuevas oportunidades, qué sectores están creciendo 
                            en tu región y cómo puedes conectar con otros emprendedores que enfrentan desafíos similares al tuyo.</p>
                        <p> En Colombia, el emprendimiento se vive de manera distinta en cada región, influenciado por factores culturales, económicos y sociales. 
                            Según estudios de Confecámaras e iNNpulsa, la mayoría de los nuevos emprendimientos se concentran en regiones con alta urbanización y 
                            acceso a servicios tecnológicos, siendo Bogotá, Antioquia y Valle del Cauca las zonas con mayor número de iniciativas registradas.</p>
                        <p>Bogotá, como capital del país, lidera en volumen de emprendimientos, especialmente en los sectores de tecnología, educación y servicios financieros. 
                            Antioquia destaca por su ecosistema de innovación, con una fuerte presencia de startups en el ámbito de medios digitales y comercio, mientras que el 
                            Valle del Cauca muestra un crecimiento sostenido en alimentación, salud y logística.</p>
                        <p> Al mismo tiempo, regiones como la Costa Caribe, el Eje Cafetero y el Oriente del país están emergiendo con fuerza, impulsadas por 
                            el acceso a programas de formación, incubadoras regionales y una creciente mentalidad emprendedora en jóvenes y comunidades rurales.</p>
                        <p>Esta diversidad regional refleja las múltiples caras del emprendimiento colombiano, donde cada territorio aporta con ideas únicas, soluciones creativas y 
                            una visión propia del desarrollo.</p>

                    </p>
                </div>

                {/* Tarjeta: Género */}
                <div className="recurso-card">
                    <h3>Emprendimientos por Género en StartupNexus</h3>
                    <ResponsiveContainer width="100%" height={400}>
                        <PieChart>
                            <Pie
                                data={datosGenero}
                                dataKey="cantidad"
                                nameKey="genero"
                                cx="50%"
                                cy="50%"
                                outerRadius={150}
                                fill="#8884d8"
                                label
                            >
                                {datosGenero.map((entry, index) => (
                                    <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
                                ))}
                            </Pie>
                            <Tooltip />
                        </PieChart>
                    </ResponsiveContainer>
                    <p className="context-text">
                        <p>👥 Distribución de emprendimientos por género:</p>
                        <p>
                            El emprendimiento en Colombia ha demostrado ser una herramienta poderosa para cerrar brechas y empoderar a diferentes sectores de 
                            la población. En particular, el emprendimiento femenino ha ganado un papel protagónico en los últimos años, con un crecimiento constante en 
                            la participación de mujeres líderes de negocios.</p>
                        <p>
                            Según el Global Entrepreneurship Monitor (GEM), Colombia es uno de los países de América Latina con mayor proporción de mujeres emprendedoras. 
                            Se estima que 4 de cada 10 emprendimientos en el país son liderados por mujeres, muchas de ellas en sectores como comercio, salud, educación 
                            y gastronomía.</p>
                        <p>A su vez, el crecimiento del emprendimiento masculino sigue siendo notable, especialmente en áreas como tecnología, finanzas y medio ambiente, 
                            donde la innovación y la infraestructura juegan un rol estratégico.</p>
                        <p>💡 Dato curioso:</p>
                        <p>¿Sabías que las mujeres emprendedoras en Colombia tienen una tasa de éxito comparable o incluso superior a la de los hombres en muchos 
                            sectores? La perseverancia, creatividad y enfoque social de sus proyectos han sido clave para generar impacto real en sus comunidades.</p>

                    </p>
                </div>

                {/* Tarjeta: Estadísticas Nacionales */}
                <div className="recurso-card">
                    <h3>Estadísticas Nacionales sobre Emprendimiento en Colombia</h3>
                    <p className="context-text" style={{ fontSize: "1.1rem", lineHeight: "1.8" }}>
                        <ul>
                            <li>
                            <strong>Alta percepción de oportunidades y capacidades emprendedoras:</strong>
                            Más del 70% de los adultos en Colombia conocen a alguien que ha iniciado un negocio recientemente y una proporción similar considera tener las habilidades para emprender. Sin embargo, aproximadamente un tercio no lo haría por temor al fracaso.
                            <a href="https://www.gemconsortium.org/country-profile/52" target="_blank">[Fuente: GEM Consortium]</a>
                            </li>
                            <li>
                            <strong>Tasa de Actividad Emprendedora Temprana (TEA):</strong>
                            En 2023, cerca de 1 de cada 4 adultos en Colombia estaba iniciando o gestionando un nuevo negocio. Las mujeres superan a los hombres: por cada 4 hombres hay 5 mujeres emprendiendo.
                            <a href="https://www.gemconsortium.org/country-profile/52" target="_blank">[Fuente: GEM Consortium]</a>
                            </li>
                            <li>
                            <strong>Baja proporción de negocios establecidos:</strong>
                            Solo 1 de cada 30 adultos posee un negocio consolidado, una de las proporciones más bajas entre países evaluados.
                            <a href="https://www.gemconsortium.org/country-profile/52" target="_blank">[Fuente: GEM Consortium]</a>
                            </li>
                            <li>
                            <strong>Transformación digital en las mipymes:</strong>
                            El 63% de las empresas medianas están en los niveles más avanzados de digitalización. En contraste, solo el 42% de las microempresas alcanzan estos niveles.
                            <a href="https://www.innpulsacolombia.com/portfolio/el-63-de-las-empresas-medianas-se-encuentra-en-los-niveles-mas-avanzados-de-transformacion-digital-mientras-que-las-microempresas-solo-alcanzan-el-42/" target="_blank">[Fuente: iNNpulsa Colombia]</a>
                            </li>
                            <li>
                            <strong>Emprendimientos liderados por migrantes:</strong>
                            El 59% de estos emprendimientos generan al menos un empleo para población colombiana o venezolana.
                            <a href="https://www.innpulsacolombia.com/portfolio/encuesta-revela-que-el-59-de-los-emprendimientos-liderados-por-migrantes-en-colombia-estan-generando-al-menos-1-empleo-a-poblacion-colombiana-o-venezolana/" target="_blank">[Fuente: iNNpulsa Colombia]</a>
                            </li>
                            <li>
                            <strong>Censo Económico Nacional Urbano (CENU) 2024:</strong>
                            Proyecto del DANE para actualizar la información sobre el tejido empresarial colombiano, incluyendo pequeñas y grandes empresas.
                            <a href="https://censoeconomiconacionalurbano.dane.gov.co/" target="_blank">[Fuente: DANE - CENU 2024]</a>
                            </li>
                            <li>
                            <strong>Encuesta de Micronegocios (Emicron):</strong>
                            Proporciona datos sobre estructura, uso de TIC e inclusión financiera de micronegocios con hasta 9 empleados.
                            <a href="https://www.dane.gov.co/index.php/estadisticas-por-tema/mercado-laboral/micronegocios" target="_blank">[Fuente: DANE - Emicron]</a>
                            </li>
                        </ul>
                    </p>
                </div>

            </div>
        </div>
    );
}

export default Estadisticas;
