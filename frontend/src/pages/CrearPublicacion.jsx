import React, { useState } from "react";
import { crearPublicacion } from "../api";
import "../CSS/CrearPublicacion.css";
import NavbarUsuario2 from "../components/NavbarUsuario2";

/**
 * Componente CrearPublicacion.
 * 
 * Este componente permite a los usuarios autenticados crear una nueva publicación asociada a un emprendimiento.
 * Incluye un formulario para ingresar el título, contenido, URL de la imagen y el ID del emprendimiento.
 * 
 * @returns {JSX.Element} Un componente que representa la página para crear una publicación.
 */
function CrearPublicacion() {
    const [tituloPublicacion, setTituloPublicacion] = useState("");
    const [contenidoPublicacion, setContenidoPublicacion] = useState("");
    const [imagenPublicacion, setImagenPublicacion] = useState("");
    const [idEmprendimiento, setIdEmprendimiento] = useState("");
    const [message, setMessage] = useState("");

    /**
     * Maneja el envío del formulario para crear una publicación.
     * 
     * @param {React.FormEvent<HTMLFormElement>} event - Evento de envío del formulario.
     */
    const handleSubmit = async (event) => {
        event.preventDefault();

        const idUsuario = localStorage.getItem("userId");
        if (!idUsuario) {
            setMessage("Error: Usuario no autenticado.");
            return;
        }

        const publicacion = {
            tituloPublicacion,
            contenidoPublicacion,
            imagenPublicacion,
        };

        try {
            const response = await crearPublicacion(idUsuario, idEmprendimiento, publicacion);
            setMessage("Publicación creada exitosamente");
            console.log("Publicación creada:", response);
        } catch (error) {
            setMessage("Error al crear la publicación");
            console.error("Error:", error);
        }
    };

    return (
        <div className="crear-publicacion-page">
            <NavbarUsuario2 />
            <form onSubmit={handleSubmit} className="crear-publicacion-form">
                <h2>Crear Publicación</h2>
                <label>
                    Título de la Publicación:
                    <input
                        type="text"
                        value={tituloPublicacion}
                        onChange={(e) => setTituloPublicacion(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Contenido de la Publicación:
                    <textarea
                        value={contenidoPublicacion}
                        onChange={(e) => setContenidoPublicacion(e.target.value)}
                        required
                    />
                </label>
                <label>
                    URL de la Imagen:
                    <input
                        type="text"
                        value={imagenPublicacion}
                        onChange={(e) => setImagenPublicacion(e.target.value)}
                        required
                    />
                </label>
                <label>
                    ID del Emprendimiento:
                    <input
                        type="number"
                        value={idEmprendimiento}
                        onChange={(e) => setIdEmprendimiento(e.target.value)}
                        required
                    />
                </label>
                <button type="submit" className="submit-button">Crear Publicación</button>
                {message && <p className="message">{message}</p>}
            </form>
        </div>
    );
}

export default CrearPublicacion;