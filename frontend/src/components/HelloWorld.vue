<template>
  <div class="p-8 max-w-2xl mx-auto">
    <div class="text-center space-y-6">
      <h1 class="text-3xl font-bold text-gray-800">{{ message }}</h1>
      <button
          @click="checkHello"
          class="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition-colors"
      >
        Check Hello
      </button>

      <div class="mt-8 space-y-4">
        <p class="text-lg font-medium text-gray-700">DB Status:
          <span class="text-blue-600">{{ dbStatus }}</span>
        </p>
        <button
            @click="checkDb"
            class="px-4 py-2 bg-green-500 text-white rounded-lg hover:bg-green-600 transition-colors"
        >
          Check DB Status
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import {getHello, getDbStatus} from '../services/api';

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