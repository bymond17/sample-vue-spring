<template>
  <div class="login-form">
    <h2>로그인</h2>
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="email">이메일</label>
        <input
          type="email"
          id="email"
          v-model="form.email"
          required
        />
      </div>
      <div class="form-group">
        <label for="password">비밀번호</label>
        <input
          type="password"
          id="password"
          v-model="form.password"
          required
        />
      </div>
      <button type="submit">로그인</button>
      <router-link to="/register" class="register-link">회원가입</router-link>
    </form>
  </div>
</template>

<script>
import { ref } from 'vue'
import { login } from '@/services/userService'

export default {
  name: 'UserLogin',
  setup() {
    const form = ref({
      email: '',
      password: ''
    })

    const handleSubmit = async () => {
      try {
        const response = await login(form.value)
        console.log('로그인 성공:', response)
        // TODO: 토큰 저장 및 홈으로 리다이렉트
      } catch (error) {
        console.error('로그인 실패:', error)
      }
    }

    return {
      form,
      handleSubmit
    }
  }
}
</script>

<style scoped>
.login-form {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-bottom: 10px;
}

button:hover {
  background-color: #3aa876;
}

.register-link {
  display: block;
  text-align: center;
  color: #2c3e50;
  text-decoration: none;
}

.register-link:hover {
  text-decoration: underline;
}
</style>