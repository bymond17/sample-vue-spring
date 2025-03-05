<template>
  <div class="max-w-md mx-auto p-6 mt-10">
    <div class="text-center">
      <h2 class="text-3xl font-bold tracking-tight text-gray-900">회원가입</h2>
      <p class="mt-2 text-sm text-gray-600">
        이미 계정이 있으신가요?
        <router-link to="/login" class="font-medium text-green-600 hover:text-green-500">
          로그인하기
        </router-link>
      </p>
    </div>

    <form class="mt-8 space-y-6" @submit.prevent="register">
      <div class="space-y-4">
        <div>
          <label for="username" class="block text-sm font-medium text-gray-700">사용자 이름</label>
          <input id="username"
                 v-model="form.username"
                 type="text"
                 required
                 class="mt-1 block w-full rounded-md border border-gray-300 px-3 py-2 shadow-sm focus:border-green-500 focus:outline-none focus:ring-1 focus:ring-green-500 sm:text-sm">
        </div>

        <div>
          <label for="email" class="block text-sm font-medium text-gray-700">이메일</label>
          <input id="email"
                 v-model="form.email"
                 type="email"
                 required
                 class="mt-1 block w-full rounded-md border border-gray-300 px-3 py-2 shadow-sm focus:border-green-500 focus:outline-none focus:ring-1 focus:ring-green-500 sm:text-sm">
        </div>

        <div>
          <label for="password" class="block text-sm font-medium text-gray-700">비밀번호</label>
          <input id="password"
                 v-model="form.password"
                 type="password"
                 required
                 class="mt-1 block w-full rounded-md border border-gray-300 px-3 py-2 shadow-sm focus:border-green-500 focus:outline-none focus:ring-1 focus:ring-green-500 sm:text-sm">
        </div>
      </div>

      <div>
        <button type="submit"
                class="flex w-full justify-center rounded-md bg-green-600 px-4 py-2 text-sm font-semibold text-white shadow-sm hover:bg-green-500 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-offset-2">
          회원가입
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import { register } from '@/services/userService'

export default {
  data() {
    return {
      form: {
        username: '',
        password: '',
        email: ''
      }
    }
  },
  methods: {
    async register() {
      try {
        await register(this.form)
        this.$router.push('/login')
      } catch (error) {
        console.error('Registration failed:', error)
      }
    }
  }
}
</script>