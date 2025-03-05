<template>
  <div class="mt-8">
    <div class="flex justify-center gap-6">
      <router-link
          to="/login"
          class="inline-flex items-center justify-center px-8 py-3 min-w-[120px] rounded-lg bg-emerald-500 text-white font-semibold hover:-translate-y-0.5 hover:shadow-lg transition-all duration-300"
      >
        <span class="text-base">로그인</span>
      </router-link>
      <router-link
          to="/register"
          class="inline-flex items-center justify-center px-8 py-3 min-w-[120px] rounded-lg bg-gray-800 text-white font-semibold hover:-translate-y-0.5 hover:shadow-lg transition-all duration-300"
      >
        <span class="text-base">회원가입</span>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AuthButtons'
}
</script>