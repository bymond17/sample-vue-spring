<template>
      <div class="hello">
        <h1>{{ message }}</h1>
        <button @click="checkHello">Check Hello</button>

        <p>DB Status: {{ dbStatus }}</p>
        <button @click="checkDb">Check DB Status</button>
      </div>
    </template>

    <script>
    import { getHello, getDbStatus } from '../services/api';

    export default {
      name: 'HelloWorld',
      data() {
        return {
          message: '',
          dbStatus: ''
        }
      },
      methods: {
        async checkHello() {
          try {
            this.message = await getHello();
          } catch (error) {
            console.error('Hello API 호출 오류:', error);
          }
        },
        async checkDb() {
          try {
            this.dbStatus = await getDbStatus();
          } catch (error) {
            console.error('DB Check API 호출 오류:', error);
          }
        }
      }
    }
    </script>