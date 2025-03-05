<template>
  <div id="app" class="font-sans text-center text-gray-800 mt-16">
    <header class="bg-emerald-500 py-5 text-white mb-5">
      <h1 class="text-2xl font-semibold">Spring Boot + Vue.js 연동 테스트</h1>
    </header>
    <main>
      <router-view/>
    </main>
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>