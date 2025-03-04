<template>
  <div class="register-form">
    <h2>회원가입</h2>
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
      <div class="form-group">
        <label for="username">사용자 이름</label>
        <input
          type="text"
          id="username"
          v-model="form.username"
          required
        />
      </div>
      <button type="submit">가입하기</button>
    </form>
  </div>
</template>

<script>
import { ref } from 'vue'
import { register } from '@/services/userService'

export default {
  name: 'UserRegister',
  setup() {
    const form = ref({
      email: '',
      password: '',
      username: ''
    })

    const handleSubmit = async () => {
      try {
        const response = await register(form.value)
        console.log('회원가입 성공:', response)
        // TODO: 성공 처리 (예: 로그인 페이지로 리다이렉트)
      } catch (error) {
        console.error('회원가입 실패:', error)
        // TODO: 에러 처리
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
.register-form {
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
}

button:hover {
  background-color: #3aa876;
}
</style>