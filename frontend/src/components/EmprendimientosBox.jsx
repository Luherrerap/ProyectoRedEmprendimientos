import React from "react";
import "../CSS/EmprendimientosBox.css";

/**
 * Componente que muestra la información de un emprendimiento.
 *
 * @param {Object} props - Propiedades del componente.
 * @param {string} props.nombre - Nombre del emprendimiento.
 * @param {string} props.descripcion - Descripción del emprendimiento.
 * @param {string} props.imagen - URL de la imagen del emprendimiento.
 * @param {string} props.fecha - Fecha de creación del emprendimiento.
 * @param {string} props.tipo - Tipo de emprendimiento.
 * @param {string} props.email - Email del creador del emprendimiento.
 * @param {string} props.region - Región asociada al emprendimiento.
 * @returns {JSX.Element} Un componente que muestra la información del emprendimiento.
 */
function EmprendimientosBox({ nombre, descripcion, imagen, fecha, tipo, email, region }) {
    return (
        <div className="emprendimientos-box">
            {/* Imagen del emprendimiento */}
            {imagen && <img src={imagen} alt={nombre} className="emprendimientos-image" />}

            {/* Información del emprendimiento */}
            <div className="emprendimientos-info">
                <h2>{nombre}</h2>
                <p><strong>Descripción:</strong> {descripcion}</p>
                <p><strong>Tipo:</strong> {tipo}</p>
                <p><strong>Región:</strong> {region}</p>
                <p><strong>Email del creador:</strong> {email}</p>
                <p><strong>Fecha de creación:</strong> {new Date(fecha).toLocaleDateString()}</p>
            </div>
        </div>
    );
}

export default EmprendimientosBox;