<template>
    <div id="app">
        <header>
            <h1>Spring Boot + Vue.js 연동 테스트</h1>
        </header>
        <main>
            <HelloWorld />
        </main>
    </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
    name: 'App',
    components: {
        HelloWorld
    }
};
</script>

<style scoped>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}

header {
    background-color: #42b983;
    padding: 20px;
    color: white;
    margin-bottom: 20px;
}
</style>