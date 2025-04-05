import React, { useState } from 'react';
import { registrarUsuario } from '../api';
import '../CSS/Registrarse.css';
import Icono from '../assets/Icono.jpg';
import { useNavigate } from 'react-router-dom';

/**
 * Componente Register.
 * 
 * Este componente permite a los usuarios registrarse en la plataforma.
 * Incluye un formulario para ingresar el correo electrónico y la contraseña.
 * 
 * @returns {JSX.Element} Un componente que representa la página de registro.
 */
function Register() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const [registroExitoso, setRegistroExitoso] = useState(false);
    const navigate = useNavigate();

    /**
     * Maneja el envío del formulario para registrar un nuevo usuario.
     * 
     * @param {React.FormEvent<HTMLFormElement>} event - Evento de envío del formulario.
     */
    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const data = await registrarUsuario(email, password);
            setMessage('Usuario registrado exitosamente');
            setRegistroExitoso(true);
            localStorage.setItem('idUsuario', data.idUsuario);
        } catch (error) {
            setMessage('Error al registrar el usuario');
            setRegistroExitoso(false);
        }
    };

    /**
     * Redirige al usuario a la página para completar los datos personales.
     */
    const handleRedirect = () => {
        navigate('/datos-personales');
    };

    return (
        <div className="register-page">
            <div className="icon-container">
                <img src={Icono} alt="Icono" className="register-icon" />
            </div>

            <form onSubmit={handleSubmit} className="register-form">
                <h2>Registrarse</h2>

                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="password">Contraseña</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>

                <button type="submit" className="register-button">Registrarse</button>

                {message && <p className="register-message">{message}</p>}
            </form>

            {registroExitoso && (
                <button
                    onClick={handleRedirect}
                    className="complete-data-button"
                >
                    Seguir a completar datos personales
                </button>
            )}
        </div>
    );
}

export default Register;
