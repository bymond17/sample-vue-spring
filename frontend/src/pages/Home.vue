<template>
    <div class="home">
        <HelloWorld />
        <AuthButtons />
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

<style scoped>
.home {
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem;
  text-align: center;
}
</style>