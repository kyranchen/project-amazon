<template>
    <div class="container">
        <div class="practices">
            <div class="column" v-for="(types, part) in practices" :key="types">
                <h3>{{ part }}</h3>
                <ul>
                    <li v-for="type in types" :key="type">{{ type }}</li>
                </ul>
            </div>
        </div>
        <div>
            <h1>紀錄</h1>
            <div class="item-input">
                <input type="text" placeholder="項目" v-model="form.name">
                <input type="text" placeholder="重量" v-model="form.weight">
                <input type="number" placeholder="組數" v-model="form.sets">
                <button type="submit" @click="submitForm()">送出</button>
            </div>
            <div class="showButton">
                <button @click="checkRecords()">check Record</button>
            </div>

            <div v-if="showTable" class="custom-table">
                <table>
                    <thead>
                        <th>{{ $t('progress.record.num') }}</th>
                        <th>{{ $t('progress.record.name') }}</th>
                        <th>{{ $t('progress.record.weight') }}</th>
                        <th>{{ $t('progress.record.sets') }}</th>
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
            records: [], 
            practices: {},
            showTable: false
        }
    },
    mounted() {
        this.setPractices();
    },
    methods: {
        setPractices() {
            this.practices = {
                "chest": ["bench press", "chest press"], 
                "leg": ["leg press", "glute"], 
                "shoulder": ["shoulder press"]
            }
        },
        async checkRecords() {
            try {
                const response = await fetch("http://localhost:9000/api/v0/items", 
                    {
                        method: 'GET', 
                        headers: {
                            'Content-Type': 'application/json', 
                        }, 
                    }
                )
                const data = await response.json();
                this.records = data;
                this.showTable = true;
            } catch (error) {
                console.error(error);
            }
        },
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
                this.showTable = true;
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

}

.practices {
    display: flex;
    justify-content: center;
}

/* Column styles */
.column {
    background-color: #fff;
    border-radius: 12px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 20px;
    width: 100%;
    transition: transform 0.2s ease;
}

/* Hover effect for a slight lift */
.column:hover {
    transform: translateY(-5px);
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
}

/* Heading style */
.column h3 {
    margin-top: 0;
    margin-bottom: 15px;
    font-size: 1.5em;
    color: #333;
}

/* List styles */
.column ul {
    list-style-type: none;
    padding-left: 0;
}

.column li {
    font-size: 1em;
    color: #555;
    padding: 8px 0;
    border-bottom: 1px solid #eee;
}

.column li:last-child {
    border-bottom: none;
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
    margin-top: 10px;
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