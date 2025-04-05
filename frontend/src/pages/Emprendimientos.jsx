import React, { useEffect, useState } from "react";
import { obtenerTodosEmprendimientos } from "../api";
import NavbarUsuario2 from "../components/NavbarUsuario2"; // Importa la barra de navegación
import "../CSS/Publicaciones.css"; // Reutiliza los estilos de Publicaciones.css

/**
 * Componente Emprendimientos.
 * 
 * Este componente muestra una lista de emprendimientos obtenidos desde la API.
 * Los emprendimientos se ordenan por fecha de creación (más recientes primero).
 * 
 * @returns {JSX.Element} Un componente que representa la página de emprendimientos.
 */
function Emprendimientos() {
    const [emprendimientos, setEmprendimientos] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    /**
     * Efecto para cargar los emprendimientos al montar el componente.
     * Obtiene los datos desde la API y los ordena por fecha de creación.
     */
    useEffect(() => {
        const fetchEmprendimientos = async () => {
            try {
                // Obtener todos los emprendimientos
                const data = await obtenerTodosEmprendimientos();

                // Ordenar los emprendimientos por fecha de creación (más recientes primero)
                data.sort((a, b) => new Date(b.fechaCreacionEmprendimiento) - new Date(a.fechaCreacionEmprendimiento));

                setEmprendimientos(data);
                setLoading(false);
            } catch (err) {
                console.error("Error al cargar los emprendimientos:", err);
                setError("Hubo un error al cargar los emprendimientos.");
                setLoading(false);
            }
        };

        fetchEmprendimientos();
    }, []);

    if (loading) {
        return <p className="loading">Cargando emprendimientos...</p>;
    }

    if (error) {
        return <p className="error">{error}</p>;
    }

    return (
        <div className="publicaciones-page">
            {/* Barra de navegación */}
            <NavbarUsuario2 />

            <h1 className="page-title">Emprendimientos</h1>
            <div className="publicaciones-container">
                {emprendimientos.map((emprendimiento) => (
                    <div key={emprendimiento.idInformacionEmprendimiento} className="post-box">
                        {/* Información del creador */}
                        <div className="post-creator">
                            <h4>{emprendimiento.usuario?.emailUsuario || "Email no disponible"}</h4>
                            <p>{emprendimiento.region?.nombreRegion || "Región no especificada"}</p>
                        </div>

                        {/* Título del emprendimiento */}
                        <div className="post-title">
                            <h2>{emprendimiento.nombreEmprendimiento}</h2>
                        </div>

                        {/* Descripción del emprendimiento */}
                        <div className="post-content">
                            <p>{emprendimiento.descripcionEmprendimiento}</p>
                        </div>

                        {/* Tipo de emprendimiento */}
                        <div className="post-content">
                            <p><strong>Tipo:</strong> {emprendimiento.tipoEmprendimiento?.nombreTipoEmprendimiento || "Tipo no especificado"}</p>
                        </div>

                        {/* Fecha de creación */}
                        <div className="post-date">
                            <p>{new Date(emprendimiento.fechaCreacionEmprendimiento).toLocaleDateString()}</p>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Emprendimientos;