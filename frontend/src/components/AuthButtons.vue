<template>
  <div class="auth-buttons">
    <div class="button-group">
      <router-link to="/login" class="btn login">
        <span class="btn-text">로그인</span>
      </router-link>
      <router-link to="/register" class="btn register">
        <span class="btn-text">회원가입</span>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AuthButtons'
}
</script>

<style scoped>
.auth-buttons {
  margin-top: 2rem;
}

.button-group {
  display: flex;
  gap: 1.5rem;
  justify-content: center;
}

.btn {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  padding: 0.8rem 2rem;
  border-radius: 8px;
  text-decoration: none;
  font-weight: 600;
  min-width: 120px;
  transition: all 0.3s ease;
}

.login {
  background-color: #42b983;
  color: white;
}

.register {
  background-color: #2c3e50;
  color: white;
}

.btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.btn-text {
  font-size: 1rem;
}
</style>