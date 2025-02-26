<template>
    <div class="hello">
        <p>{{ message }}</p>
        <button @click="fetchHello">서버에서 메시지 가져오기</button>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'HelloWorld',
    data() {
        return {
            message: '버튼을 클릭하여 서버에서 메시지를 가져오세요.'
        };
    },
    methods: {
        async fetchHello() {
            axios.get('http://localhost:8080/api/hello')
                .then(response => {
                    this.message = response.data;
                })
                .catch(error => {
                    console.error('Error:', error);
                    this.message = '서버 연결 오류가 발생했습니다.';
                });
        }
    }
};
</script>

<style scoped>
.hello {
    margin: 20px;
}

button {
    background-color: #42b983;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    margin-top: 20px;
}

button:hover {
    background-color: #3aa876;
}
</style>