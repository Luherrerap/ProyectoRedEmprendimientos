import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { loginUsuario } from '../api';
import "../CSS/Login.css"; 
import Icono from '../assets/Icono.jpg'; 

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate(); 

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {

            const data = await loginUsuario(email, password);

            
            localStorage.setItem('userId', data.userId);

            setMessage('Inicio de sesión exitoso'); 

            
            navigate('/usuario');
        } catch (error) {
            setMessage('Correo o contraseña inválidos'); 
        }
    };

    return (
        <div className="login-page">
            <div className="icon-container">
                <img src={Icono} alt="Icono" className="login-icon" />
            </div>
            <form onSubmit={handleSubmit} className="login-form">
                <h2>Iniciar Sesión</h2>
                <label>
                    Email:
                    <input
                        type="email"
                        name="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </label>
                <label>
                    Contraseña:
                    <input
                        type="password"
                        name="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </label>
                <button type="submit" className="login-button">Ingresar</button>
                {message && <p className="login-message">{message}</p>}
            </form>
        </div>
    );
}

export default Login;