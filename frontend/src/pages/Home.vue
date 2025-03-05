<template>
  <div class="max-w-[1200px] mx-auto px-8 py-4 text-center">
    <HelloWorld/>
    <AuthButtons/>
  </div>
</template>

<script>
import HelloWorld from '../components/HelloWorld.vue';
import AuthButtons from '../components/AuthButtons.vue';

export default {
  name: 'Home',
  components: {
    HelloWorld,
    AuthButtons
  }
};
</script>