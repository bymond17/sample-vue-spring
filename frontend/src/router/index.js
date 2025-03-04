import { createRouter, createWebHistory } from 'vue-router';
    import Home from '../pages/Home.vue';

    const routes = [
        {
            path: '/',
            name: 'Home',
            component: Home
        }
    ];

    // VITE_API_URL은 API 기본 주소로 사용해야 하므로, 라우터의 base URL에서는 제거
    const router = createRouter({
        history: createWebHistory(),  // base URL 제거
        routes
    });

    export default router;