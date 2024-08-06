<template>
    <div class="container">
        <h1>紀錄</h1>
        <div class="item-input">
            <input type="text" placeholder="項目" v-model="form.name">
            <input type="text" placeholder="重量" v-model="form.weight">
            <input type="number" placeholder="組數" v-model="form.sets">
            <button type="submit" @click="submitForm()">送出</button>
        </div>
        <div class="custom-table">
            <table>
                <thead>
                    <th>Field 1</th>
                    <th>Field 1</th>
                    <th>Field 1</th>
                    <th>Field 1</th>
                </thead>
                <tbody>
                    <template v-for="rec in records" :key="rec.id">
                        <tr>
                            <td>{{ rec.id }}</td>
                            <td>{{ rec.name }}</td>
                            <td>{{ rec.weight }}</td>
                            <td>{{ rec.sets }}</td>
                        </tr>
                    </template>
                </tbody>
            </table>

        </div>
    </div>
</template>

<script>
export default {
    name: 'TrackProgress', 
    data() {
        return {
            form: {
                id: '', 
                name: '', 
                weight: '', 
                sets: '',
            }, 
            records: []
        }
    },
    mounted() {
        
    },
    methods: {
        async submitForm() {
            try {
                const response = await fetch("http://localhost:9000/api/v0/itemAdd", 
                    {
                        method: 'POST', 
                        headers: {
                            'Content-Type': 'application/json', 
                        }, 
                        body: JSON.stringify(this.form),
                    }
                )
                const data = await response.json();
                this.records = data;
            } catch (error) {
                console.error(error);
            }
        }
    }
}
</script>

<style scoped>
.container {
    background-color: #ddd;
    height: 100vh;
    background-color: #eee;
    border-radius: 5px;
    padding: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.item-input {
    display: flex;
    gap: 30px;
}

.item-input input {
    border-radius: 5px;
    padding-top: 10px;
    padding-bottom: 10px;
}

.item-input button {
    border-radius: 5px;
    padding: 10px;

}


table {
    width: 100%;
    border-collapse: collapse;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    background-color: white;
}

th, td {
    padding: 12px 15px;
    text-align: left;
}

thead {
    background-color: #4CAF50;
    color: white;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:hover {
    background-color: #ddd;
}

th {
    position: sticky;
    top: 0;
    z-index: 1;
}
</style>