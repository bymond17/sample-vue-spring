<template>
  <div class="max-w-md mx-auto p-6 mt-10">
    <h2 class="text-2xl font-bold text-gray-800 mb-6 text-center">회원가입</h2>
    <form @submit.prevent="handleSubmit" class="space-y-6">
      <div class="space-y-2">
        <label for="email" class="block text-sm font-medium text-gray-700">이메일</label>
        <input
            type="email"
            id="email"
            v-model="form.email"
            required
            class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-emerald-500 focus:border-emerald-500 outline-none transition-colors"
        />
      </div>
      <div class="space-y-2">
        <label for="password" class="block text-sm font-medium text-gray-700">비밀번호</label>
        <input
            type="password"
            id="password"
            v-model="form.password"
            required
            class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-emerald-500 focus:border-emerald-500 outline-none transition-colors"
        />
      </div>
      <div class="space-y-2">
        <label for="username" class="block text-sm font-medium text-gray-700">사용자 이름</label>
        <input
            type="text"
            id="username"
            v-model="form.username"
            required
            class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-emerald-500 focus:border-emerald-500 outline-none transition-colors"
        />
      </div>
      <button
          type="submit"
          class="w-full py-3 bg-emerald-500 text-white font-semibold rounded-lg hover:bg-emerald-600 transition-colors duration-300"
      >
        가입하기
      </button>
    </form>
  </div>
</template>