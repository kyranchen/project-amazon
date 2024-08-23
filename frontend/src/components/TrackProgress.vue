<template>
    <div class="container">
        <div class="practice-container">
            <h1>{{ $t('progress.list') }}</h1>
            <div class="practices">
                <div class="column" v-for="(types, part) in practices" :key="types">
                    <h3>{{ $t(`part.${part}`) }}</h3>
                    <ul>
                        <li v-for="type in types" :key="type">{{ type }}</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="record-container">
            <h1>{{ $t('progress.record') }}</h1>
            <div class="record">
                <div class="item-input">
                    <input type="text" :placeholder="$t('progress.record.name')" v-model="form.name">
                    <input type="text" :placeholder="$t('progress.record.weight')" v-model="form.weight">
                    <input type="number" :placeholder="$t('progress.record.sets')" v-model="form.sets">
                    <input type="date" v-model="form.date">
                    <button type="submit" @click="submitForm()">{{ $t('progress.send') }}</button>
                </div>
                <div class="custom-table">
                    <table>
                        <thead>
                            <th style="width: 20vw;">{{ $t('progress.record.num') }}</th>
                            <th style="width: 20vw;">{{ $t('progress.record.date') }}</th>
                            <th style="width: 20vw;">{{ $t('progress.record.name') }}</th>
                            <th style="width: 20vw;">{{ $t('progress.record.weight') }}</th>
                            <th style="width: 20vw;">{{ $t('progress.record.sets') }}</th>
                        </thead>
                        <tbody>
                            <template v-for="rec in records" :key="rec.id">
                                <tr>
                                    <td>{{ rec.id }}</td>
                                    <td>{{ rec.date }}</td>
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
                date: '',
            }, 
            records: [], 
            practices: {},
        }
    },
    mounted() {
        this.fetchPractices();
        this.checkRecords();
    },
    methods: {
        async fetchPractices() {
            try {
                const response = await fetch("http://localhost:9000/api/v0/practices", 
                    {
                        method: 'GET', 
                        headers: {
                            'Content-Type': 'application/json', 
                        }, 
                    }
                )
                const data = await response.json();
                this.practices = data;
                this.buildPracticeMap(this.practices);
            } catch (error) {
                console.error(error);
            }
        },
        buildPracticeMap(practices) {
            let obj = {};
            for (let practice of practices) {
                if (!(practice.bodyPart in obj)) {
                    obj[practice.bodyPart] = [];
                    obj[practice.bodyPart].push(practice.name);
                } else {
                    obj[practice.bodyPart].push(practice.name);
                }
            }
            this.practices = obj;
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
                this.form = {}
            } catch (error) {
                console.error(error);
            }
        }
    }
}
</script>

<style scoped>

.container {
    font-family: "Montserrat", "Noto Sans TC", sans-serif;
    background-color: #ddd;
    height: 100vh;
    background-color: #eee;
    border-radius: 5px;
    padding: 10px;
    display: flex;
    flex-direction: column;
    overflow: auto;

}

.practice-container {
    margin-top: 20px;
    text-align: center;
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

/* Container for the form items */
.item-input {
    width: 50%;
    display: flex;
    flex-direction: column;
    gap: 15px;
    background-color: #f9f9f9;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* Input field styles */
.item-input input {
    border: 1px solid #ddd;
    border-radius: 5px;
    padding: 12px;
    font-size: 16px;
    width: 100%;
    box-sizing: border-box;
    transition: border-color 0.3s ease;
}

/* Focus state for inputs */
.item-input input:focus {
    border-color: #007bff;
    outline: none;
}

/* Button styling */
.item-input button {
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 12px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    width: 100%;
}

/* Hover effect for button */
.item-input button:hover {
    background-color: #0056b3;
}

/* Additional styles for form alignment */
.item-input input[type="date"] {
    padding: 10px 12px;
}

.record-container {
    text-align: center;
}

.record {
    display: flex;
    gap: 10px;
    align-items: center;
}

.custom-table {
    width: 100%;
    border-collapse: collapse;
    border-radius: 5px;
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