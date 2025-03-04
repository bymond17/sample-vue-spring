import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

export default defineConfig({
    plugins: [vue()],
    server: {
        port: 3000,
        host: '0.0.0.0',
        watch: {
            usePolling: true
        }
    },
    optimizeDeps: {
        include: ['vue']
    },
    minify: 'terser'
});