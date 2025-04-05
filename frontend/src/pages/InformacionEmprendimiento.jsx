import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { guardarOActualizarEmprendimiento } from "../api";
import "../CSS/InformacionEmprendimiento.css";

/**
 * Componente InformacionEmprendimiento.
 * 
 * Este componente permite a los usuarios ingresar y guardar información sobre su emprendimiento.
 * Incluye un formulario para capturar datos como nombre, descripción, imagen, tipo de emprendimiento y región.
 * 
 * @returns {JSX.Element} Un componente que representa la página para ingresar información del emprendimiento.
 */
function InformacionEmprendimiento() {
    const [nombreEmprendimiento, setNombreEmprendimiento] = useState("");
    const [descripcionEmprendimiento, setDescripcionEmprendimiento] = useState("");
    const [imagenEmprendimientoUrl, setImagenEmprendimientoUrl] = useState("");
    const [tipoEmprendimiento, setTipoEmprendimiento] = useState("");
    const [region, setRegion] = useState("");
    const [idUsuario, setIdUsuario] = useState("");
    const [message, setMessage] = useState("");
    const [registroExitoso, setRegistroExitoso] = useState(false);
    const navigate = useNavigate();

    /**
     * Recupera el ID del usuario desde el almacenamiento local al cargar la página.
     */
    useEffect(() => {
        const storedIdUsuario = localStorage.getItem("idUsuario");
        if (storedIdUsuario) {
            setIdUsuario(storedIdUsuario);
        }
    }, []);

    /**
     * Maneja el envío del formulario para guardar o actualizar la información del emprendimiento.
     * 
     * @param {React.FormEvent<HTMLFormElement>} event - Evento de envío del formulario.
     */
    const handleSubmit = async (event) => {
        event.preventDefault();

        const regionMap = {
            "Caribe": 1,
            "Andina": 2,
            "Pacifica": 3,
            "Orinoquia": 4,
            "Amazonia": 5,
            "Insular": 6,
        };

        const tipoEmprendimientoMap = {
            "Tecnología": 1,
            "Comercio y Retail": 2,
            "Salud y Bienestar": 3,
            "Educación y Formación": 4,
            "Medio Ambiente y Sostenibilidad": 5,
            "Entretenimiento y Medios": 6,
            "Alimentación y Gastronomía": 7,
            "Finanzas y Negocios": 8,
        };

        const emprendimiento = {
            nombreEmprendimiento,
            descripcionEmprendimiento,
            imagenEmprendimientoUrl,
            fechaCreacionEmprendimiento: new Date().toISOString(),
            estadoEmprendimiento: true,
            tipoEmprendimiento: { idTipoEmprendimiento: tipoEmprendimientoMap[tipoEmprendimiento] },
            region: { idRegion: regionMap[region] },
            usuario: { idUsuario: parseInt(idUsuario) },
        };

        try {
            const response = await guardarOActualizarEmprendimiento(emprendimiento);
            setMessage("Emprendimiento guardado exitosamente");
            setRegistroExitoso(true);
            console.log("Emprendimiento guardado:", response);
        } catch (error) {
            setMessage("Error al guardar el emprendimiento");
            setRegistroExitoso(false);
            console.error("Error:", error);
        }
    };

    /**
     * Redirige al usuario a la página de inicio de sesión y elimina el ID del usuario del almacenamiento local.
     */
    const handleRedirect = () => {
        localStorage.removeItem("idUsuario");
        navigate("/ingresar");
    };

    return (
        <div className="informacion-emprendimiento-page">
            <form onSubmit={handleSubmit} className="informacion-emprendimiento-form">
                <h2>Información del Emprendimiento</h2>
                <label>
                    Nombre del Emprendimiento:
                    <input
                        type="text"
                        value={nombreEmprendimiento}
                        onChange={(e) => setNombreEmprendimiento(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Descripción:
                    <textarea
                        value={descripcionEmprendimiento}
                        onChange={(e) => setDescripcionEmprendimiento(e.target.value)}
                        required
                    />
                </label>
                <label>
                    URL de la imagen para su emprendimiento:
                    <input
                        type="text"
                        value={imagenEmprendimientoUrl}
                        onChange={(e) => setImagenEmprendimientoUrl(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Tipo de Emprendimiento:
                    <select
                        className="custom-select tipo-emprendimiento-select"
                        value={tipoEmprendimiento}
                        onChange={(e) => setTipoEmprendimiento(e.target.value)}
                        required
                    >
                        <option value="">Seleccione un tipo</option>
                        <option value="Tecnología">Tecnología</option>
                        <option value="Comercio y Retail">Comercio y Retail</option>
                        <option value="Salud y Bienestar">Salud y Bienestar</option>
                        <option value="Educación y Formación">Educación y Formación</option>
                        <option value="Medio Ambiente y Sostenibilidad">Medio Ambiente y Sostenibilidad</option>
                        <option value="Entretenimiento y Medios">Entretenimiento y Medios</option>
                        <option value="Alimentación y Gastronomía">Alimentación y Gastronomía</option>
                        <option value="Finanzas y Negocios">Finanzas y Negocios</option>
                    </select>
                </label>
                <label>
                    Región:
                    <select
                        className="custom-select region-select"
                        value={region}
                        onChange={(e) => setRegion(e.target.value)}
                        required
                    >
                        <option value="">Seleccione una región</option>
                        <option value="Caribe">Caribe</option>
                        <option value="Andina">Andina</option>
                        <option value="Pacifica">Pacífica</option>
                        <option value="Orinoquia">Orinoquía</option>
                        <option value="Amazonia">Amazonía</option>
                        <option value="Insular">Insular</option>
                    </select>
                </label>
                <input
                    type="hidden"
                    value={idUsuario}
                    readOnly
                />
                <button type="submit" className="submit-button">Guardar Emprendimiento</button>
                {message && <p className="message">{message}</p>}
            </form>
            {registroExitoso && (
                <div className="redirect-button-container">
                    <button onClick={handleRedirect} className="redirect-button">
                        Inicia sesión para empezar en Startup Nexus
                    </button>
                </div>
            )}
        </div>
    );
}

export default InformacionEmprendimiento;