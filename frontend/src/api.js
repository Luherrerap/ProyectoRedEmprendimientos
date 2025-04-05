import axios from "axios";

const API_URL = "http://localhost:8080/api";

axios.defaults.withCredentials = true;

/**
 * Obtiene todos los usuarios registrados.
 * 
 * @returns {Promise<Array>} Una lista de usuarios.
 */
export const obtenerUsuarios = async () => {
    try {
        const response = await axios.get(`${API_URL}/usuarios`);
        return response.data;
    } catch (error) {
        console.error("Error obteniendo usuarios", error);
        return [];
    }
};

/**
 * Inicia sesión de un usuario.
 * 
 * @param {string} email - Correo electrónico del usuario.
 * @param {string} password - Contraseña del usuario.
 * @returns {Promise<Object>} Los datos del usuario autenticado.
 */
export const loginUsuario = async (email, password) => {
    try {
        const response = await axios.post(`${API_URL}/usuarios/login`, { email, password });
        return response.data;
    } catch (error) {
        console.error("Error durante el inicio de sesión", error);
        throw error;
    }
};

/**
 * Registra un nuevo usuario.
 * 
 * @param {string} email - Correo electrónico del usuario.
 * @param {string} password - Contraseña del usuario.
 * @returns {Promise<Object>} Los datos del usuario registrado.
 */
export const registrarUsuario = async (email, password) => {
    try {
        const response = await axios.post(`${API_URL}/usuarios/registrar`, { email, password });
        return response.data;
    } catch (error) {
        console.error("Error durante el registro", error);
        throw error;
    }
};

/**
 * Crea un perfil de usuario.
 * 
 * @param {Object} datosUsuario - Datos del perfil del usuario.
 * @returns {Promise<Object>} Los datos del perfil creado.
 */
export const crearPerfilUsuario = async (datosUsuario) => {
    try {
        const response = await axios.post(`${API_URL}/datosusuario/guardar/${datosUsuario.idUsuario.idUsuario}`, datosUsuario);
        return response.data;
    } catch (error) {
        console.error("Error al crear el perfil de usuario", error);
        throw error;
    }
};

/**
 * Guarda o actualiza un emprendimiento.
 * 
 * @param {Object} emprendimiento - Datos del emprendimiento.
 * @returns {Promise<Object>} Los datos del emprendimiento guardado o actualizado.
 */
export const guardarOActualizarEmprendimiento = async (emprendimiento) => {
    try {
        const response = await axios.post(`${API_URL}/emprendimientos/guardar`, emprendimiento);
        return response.data;
    } catch (error) {
        console.error("Error al guardar o actualizar el emprendimiento", error);
        throw error;
    }
};

/**
 * Crea una publicación asociada a un emprendimiento.
 * 
 * @param {number} idUsuario - ID del usuario.
 * @param {number} idEmprendimiento - ID del emprendimiento.
 * @param {Object} publicacion - Datos de la publicación.
 * @returns {Promise<Object>} Los datos de la publicación creada.
 */
export const crearPublicacion = async (idUsuario, idEmprendimiento, publicacion) => {
    try {
        const response = await axios.post(`${API_URL}/publicaciones/crear/${idEmprendimiento}`, publicacion);
        return response.data;
    } catch (error) {
        console.error("Error al crear la publicación", error);
        throw error;
    }
};

/**
 * Obtiene todas las publicaciones.
 * 
 * @returns {Promise<Array>} Una lista de publicaciones.
 */
export const obtenerTodasPublicaciones = async () => {
    try {
        const response = await axios.get(`${API_URL}/publicaciones/todas`);
        return response.data;
    } catch (error) {
        console.error("Error al obtener todas las publicaciones", error);
        throw error;
    }
};

/**
 * Obtiene los datos de un usuario por su ID.
 * 
 * @param {number} idUsuario - ID del usuario.
 * @returns {Promise<Object>} Los datos del usuario.
 */
export const obtenerDatosPorIdUsuario = async (idUsuario) => {
    try {
        const response = await axios.get(`${API_URL}/datosusuario/usuario/${idUsuario}`);
        return response.data;
    } catch (error) {
        console.error("Error al obtener los datos del usuario", error);
        throw error;
    }
};

/**
 * Obtiene todos los emprendimientos.
 * 
 * @returns {Promise<Array>} Una lista de emprendimientos.
 */
export const obtenerTodosEmprendimientos = async () => {
    try {
        const response = await axios.get(`${API_URL}/emprendimientos/todos`);
        return response.data;
    } catch (error) {
        console.error("Error al obtener todos los emprendimientos", error);
        throw error;
    }
};

/**
 * Cierra la sesión del usuario.
 * 
 * @returns {Promise<Object>} Los datos de la respuesta del cierre de sesión.
 */
export const logoutUsuario = async () => {
    try {
        const response = await axios.post(`${API_URL}/usuarios/logout`);
        return response.data;
    } catch (error) {
        console.error("Error durante el cierre de sesión", error);
        throw error;
    }
};

/**
 * Obtiene el total de emprendimientos registrados.
 * 
 * @returns {Promise<number>} El total de emprendimientos.
 */
export const obtenerTotalEmprendimientos = async () => {
    try {
        const response = await axios.get(`${API_URL}/estadisticas/total`);
        return response.data;
    } catch (error) {
        console.error("Error al obtener el total de emprendimientos", error);
        throw error;
    }
};

/**
 * Obtiene los emprendimientos agrupados por categoría.
 * 
 * @returns {Promise<Array>} Una lista de emprendimientos por categoría.
 */
export const obtenerEmprendimientosPorCategoria = async () => {
    try {
        const response = await axios.get(`${API_URL}/estadisticas/por-categoria`);
        return response.data;
    } catch (error) {
        console.error("Error al obtener los emprendimientos por categoría", error);
        throw error;
    }
};

/**
 * Obtiene los emprendimientos agrupados por región.
 * 
 * @returns {Promise<Array>} Una lista de emprendimientos por región.
 */
export const obtenerEmprendimientosPorRegion = async () => {
    try {
        const response = await axios.get(`${API_URL}/estadisticas/por-region`);
        return response.data;
    } catch (error) {
        console.error("Error al obtener los emprendimientos por región", error);
        throw error;
    }
};

/**
 * Obtiene los emprendimientos agrupados por género.
 * 
 * @returns {Promise<Array>} Una lista de emprendimientos por género.
 */
export const obtenerEmprendimientosPorGenero = async () => {
    try {
        const response = await axios.get(`${API_URL}/estadisticas/por-genero`);
        return response.data;
    } catch (error) {
        console.error("Error al obtener los emprendimientos por género", error);
        throw error;
    }
};

