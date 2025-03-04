import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

export default defineConfig({
    plugins: [vue()],
    server: {
        port: 3000,
        host: '0.0.0.0',
        proxy: {
            '/api': {
                target: 'http://backend:8080',
                changeOrigin: true,
                rewrite: (path) => path
            }
        },
        watch: {
            usePolling: true
        }
    },
    optimizeDeps: {
        include: ['vue']
    },
    minify: 'terser'
});