import axios from 'axios';

const API_URL = 'http://localhost:8080';

const handleAxiosError = (error) => {
    if (error.response) {
        // 서버에서 응답한 에러
        const message = error.response.data.message || '서버 오류가 발생했습니다';
        throw new Error(message);
    }
    if (error.request) {
        // 서버에 요청이 도달하지 못한 경우
        throw new Error('서버에 연결할 수 없습니다');
    }
    // 기타 에러
    throw new Error('요청 중 오류가 발생했습니다');
}

export const register = async (userData) => {
    try {
        const response = await axios.post(`${API_URL}/api/users/register`, userData);
        return response.data;
    } catch (error) {
        handleAxiosError(error);
    }
}

export const login = async (userData) => {
    try {
        const response = await axios.post(`${API_URL}/api/users/login`, userData);
        if (response.data.status === 'error') {
            // status가 error인 경우도 handleAxiosError와 같은 방식으로 처리
            throw new Error(response.data.message || '로그인에 실패했습니다');
        }
        return response.data;
    } catch (error) {
        // axios 에러와 커스텀 에러 모두 throw
        throw handleAxiosError(error);
    }
}