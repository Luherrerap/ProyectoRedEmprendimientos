import React from "react";
import "../CSS/PostBox.css";

/**
 * Componente PostBox.
 * 
 * Este componente muestra la información de una publicación, incluyendo los datos del creador,
 * el título, el contenido y la fecha de creación.
 * 
 * @param {Object} props - Propiedades del componente.
 * @param {string} props.nombre - Nombre del creador de la publicación.
 * @param {string} props.apellidos - Apellidos del creador de la publicación.
 * @param {string} props.biografia - Biografía del creador de la publicación.
 * @param {string} props.genero - Género del creador de la publicación.
 * @param {string} props.correo - Correo electrónico del creador de la publicación.
 * @param {string} props.titulo - Título de la publicación.
 * @param {string} props.contenido - Contenido de la publicación.
 * @param {string} props.fecha - Fecha de creación de la publicación.
 * @returns {JSX.Element} Un componente que muestra la información de una publicación.
 */
function PostBox({ nombre, apellidos, biografia, genero, correo, titulo, contenido, fecha }) {
    return (
        <div className="post-box">
            <div className="post-creator">
                <h4>{nombre} {apellidos}</h4>
                <p>{correo}</p>
                <p>{genero}</p>
                <p>{biografia}</p>
            </div>
            <div className="post-title">
                <h2>{titulo}</h2>
            </div>
            <div className="post-content">
                <p>{contenido}</p>
            </div>
            <div className="post-date">
                <p>{fecha}</p>
            </div>
        </div>
    );
}

export default PostBox;