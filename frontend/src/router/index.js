import { createRouter, createWebHistory } from 'vue-router';
import Home from '../pages/Home.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/register',
            name: 'register',
            component: () => import('../components/user/UserRegister.vue')
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('../components/user/UserLogin.vue')
        }
    ]
})

    export default router;