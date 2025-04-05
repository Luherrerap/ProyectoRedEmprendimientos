import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { crearPerfilUsuario } from "../api";
import "../CSS/DatosPersonales.css";

/**
 * Componente DatosPersonales.
 * 
 * Este componente permite a los usuarios ingresar y guardar sus datos personales.
 * Incluye un formulario para capturar información como nombre, apellidos, biografía, país, etnia, género y región.
 * 
 * @returns {JSX.Element} Un componente que representa la página para ingresar datos personales.
 */
function DatosPersonales() {
    const [idUsuario, setIdUsuario] = useState("");
    const [nombreUsuario, setNombreUsuario] = useState("");
    const [apellidosUsuario, setApellidosUsuario] = useState("");
    const [biografiaUsuario, setBiografiaUsuario] = useState("");
    const [paisUsuario, setPaisUsuario] = useState("");
    const [etnia, setEtnia] = useState("");
    const [genero, setGenero] = useState("");
    const [region, setRegion] = useState("");
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
     * Maneja el envío del formulario para guardar los datos personales.
     * 
     * @param {React.FormEvent<HTMLFormElement>} event - Evento de envío del formulario.
     */
    const handleSubmit = async (event) => {
        event.preventDefault();

        const regionMap = {
            "Region Caribe": 1,
            "Region Andina": 2,
            "Region Pacifica": 3,
            "Region Orinoquia": 4,
            "Region Amazonia": 5,
            "Region Insular": 6,
        };

        const datosUsuario = {
            idDatosUsuario: null,
            nombreUsuario,
            apellidosUsuario,
            biografiaUsuario,
            paisUsuario,
            etnia,
            genero,
            region: { idRegion: regionMap[region] },
            idUsuario: { idUsuario: parseInt(idUsuario) },
        };

        try {
            const response = await crearPerfilUsuario(datosUsuario);
            setMessage("Perfil creado exitosamente");
            setRegistroExitoso(true);
            console.log("Perfil creado:", response);
        } catch (error) {
            setMessage("Error al crear el perfil");
            setRegistroExitoso(false);
            console.error("Error:", error);
        }
    };

    /**
     * Redirige al usuario a la página para ingresar información del emprendimiento.
     */
    const handleContinuar = () => {
        navigate("/informacion-emprendimiento");
    };

    return (
        <div className="datos-personales-page">
            <form onSubmit={handleSubmit} className="datos-personales-form">
                <h2>Datos Personales</h2>
                <input
                    type="hidden"
                    value={idUsuario}
                    readOnly
                />
                <label>
                    Nombre:
                    <input
                        type="text"
                        value={nombreUsuario}
                        onChange={(e) => setNombreUsuario(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Apellidos:
                    <input
                        type="text"
                        value={apellidosUsuario}
                        onChange={(e) => setApellidosUsuario(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Breve biografía (Opcional*):
                    <textarea
                        value={biografiaUsuario}
                        onChange={(e) => setBiografiaUsuario(e.target.value)}
                        required
                    />
                </label>
                <label>
                    País:
                    <input
                        type="text"
                        value={paisUsuario}
                        onChange={(e) => setPaisUsuario(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Etnia (Opcional*):
                    <input
                        type="text"
                        value={etnia}
                        onChange={(e) => setEtnia(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Género (Opcional*):
                    <input
                        type="text"
                        value={genero}
                        onChange={(e) => setGenero(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Región:
                    <select
                        className="region-select"
                        value={region}
                        onChange={(e) => setRegion(e.target.value)}
                        required
                    >
                        <option value="">Seleccione una región</option>
                        <option value="Region Caribe">Región Caribe</option>
                        <option value="Region Andina">Región Andina</option>
                        <option value="Region Pacifica">Región Pacífica</option>
                        <option value="Region Orinoquia">Región Orinoquía</option>
                        <option value="Region Amazonia">Región Amazonía</option>
                        <option value="Region Insular">Región Insular</option>
                    </select>
                </label>
                <button type="submit" className="submit-button">Guardar Perfil</button>
                {message && <p className="message">{message}</p>}
            </form>
            {registroExitoso && (
                <div className="continue-button-container">
                    <button onClick={handleContinuar} className="complete-data-button">
                        Continuar a llenar los datos de tu emprendimiento
                    </button>
                </div>
            )}
        </div>
    );
}

export default DatosPersonales;