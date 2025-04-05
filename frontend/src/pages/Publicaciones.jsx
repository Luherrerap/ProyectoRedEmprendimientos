import React, { useEffect, useState } from "react";
import { obtenerTodasPublicaciones, obtenerDatosPorIdUsuario } from "../api";
import PostBox from "../components/PostBox";
import NavbarUsuario2 from "../components/NavbarUsuario2";
import "../CSS/Publicaciones.css";

/**
 * Componente Publicaciones.
 * 
 * Este componente muestra una lista de publicaciones obtenidas desde la API.
 * Las publicaciones se ordenan por fecha de creación (más recientes primero).
 * También se obtienen y muestran los datos de los usuarios asociados a cada publicación.
 * 
 * @returns {JSX.Element} Un componente que representa la página de publicaciones.
 */
function Publicaciones() {
    const [publicaciones, setPublicaciones] = useState([]);
    const [usuarios, setUsuarios] = useState({});
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    /**
     * Efecto para cargar las publicaciones y los datos de los usuarios al montar el componente.
     * Obtiene las publicaciones desde la API y los datos de los usuarios asociados.
     */
    useEffect(() => {
        const fetchPublicaciones = async () => {
            try {
                const publicacionesData = await obtenerTodasPublicaciones();
                publicacionesData.sort((a, b) => new Date(b.fechaCreacionPublicacion) - new Date(a.fechaCreacionPublicacion));

                const usuariosData = {};

                for (const publicacion of publicacionesData) {
                    const idUsuario = publicacion.usuario.idUsuario;

                    if (!usuariosData[idUsuario]) {
                        try {
                            const datosUsuario = await obtenerDatosPorIdUsuario(idUsuario);

                            if (datosUsuario.length > 0) {
                                const usuarioData = datosUsuario[0];
                                usuariosData[idUsuario] = {
                                    nombreUsuario: usuarioData.nombreUsuario || "Nombre no disponible",
                                    apellidosUsuario: usuarioData.apellidosUsuario || "Apellidos no disponibles",
                                    biografiaUsuario: usuarioData.biografiaUsuario || "Biografía no disponible",
                                    genero: usuarioData.genero || "Género no disponible",
                                };
                            }
                        } catch (err) {
                            console.error(`Error al obtener datos del usuario con id ${idUsuario}:`, err);
                        }
                    }
                }

                setPublicaciones(publicacionesData);
                setUsuarios(usuariosData);
                setLoading(false);
            } catch (err) {
                console.error("Error al cargar las publicaciones:", err);
                setError("Hubo un error al cargar las publicaciones.");
                setLoading(false);
            }
        };

        fetchPublicaciones();
    }, []);

    if (loading) {
        return <p className="loading">Cargando publicaciones...</p>;
    }

    if (error) {
        return <p className="error">{error}</p>;
    }

    return (
        <div className="publicaciones-page">
            <NavbarUsuario2 />
            <h1 className="page-title">Publicaciones</h1>
            <div className="publicaciones-container">
                {publicaciones.map((publicacion) => {
                    const datosUsuario = usuarios[publicacion.usuario.idUsuario];
                    return (
                        <PostBox
                            key={publicacion.idPublicaciones}
                            nombre={datosUsuario?.nombreUsuario || "Usuario desconocido"}
                            apellidos={datosUsuario?.apellidosUsuario || "Apellidos no disponibles"}
                            biografia={datosUsuario?.biografiaUsuario || "Biografía no disponible"}
                            genero={datosUsuario?.genero || "Género no disponible"}
                            correo={publicacion.usuario.emailUsuario || "Correo no disponible"}
                            titulo={publicacion.tituloPublicacion}
                            contenido={publicacion.contenidoPublicacion}
                            fecha={publicacion.fechaCreacionPublicacion}
                        />
                    );
                })}
            </div>
        </div>
    );
}

export default Publicaciones;