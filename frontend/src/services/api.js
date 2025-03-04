import axios from 'axios';

const api = axios.create({
    baseURL: '/api',
    timeout: 5000
});

export const getHello = async () => {
    try {
        const response = await api.get('/hello');
        return response.data;
    } catch (error) {
        console.error('API Error:', error);
        throw error;
    }
};

export const getDbStatus = async () => {
    try {
        const response = await api.get('/db-check');
        return response.data;
    } catch (error) {
        console.error('DB Check Error:', error);
        throw error;
    }
};