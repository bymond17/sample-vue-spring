<template>
    <div class="hello">
        <p>{{ message }}</p>
        <button @click="fetchHello">서버에서 메시지 가져오기</button>
        <p>{{ dbStatus }}</p>
        <button @click="checkDatabase">데이터베이스 연결 확인</button>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'HelloWorld',
    data() {
        return {
            message: '버튼을 클릭하여 서버에서 메시지를 가져오세요.',
            dbStatus: ''
        };
    },
    methods: {
        async fetchHello() {
            try {
                const response = await axios.get('http://localhost:8080/api/hello');
                this.message = response.data;
            } catch (error) {
                console.error('Error:', error);
                this.message = '서버 연결 오류가 발생했습니다.';
            }
        },
        async checkDatabase() {
            try {
                const response = await axios.get('http://localhost:8080/api/db-check');
                if (response.data.status === 'success') {
                    const version = response.data.data.version;
                    this.dbStatus = `DB 연결 성공: ${version}`;
                } else {
                    this.dbStatus = `DB 연결 실패: ${response.data.message}`;
                }
            } catch (error) {
                console.error('Error:', error);
                this.dbStatus = '서버 연결 오류가 발생했습니다.';
            }
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