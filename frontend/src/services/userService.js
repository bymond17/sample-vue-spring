import axios from 'axios';

const API_URL = 'http://localhost:8080';

export const register = async (userData) => {
    const response = await axios.post(`${API_URL}/api/users/register`, userData);
    return response.data;
}

export const login = async (userData) => {
    const response = await axios.post(`${API_URL}/api/users/login`, userData);
    return response.data;
}