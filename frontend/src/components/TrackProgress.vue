<template>
    <div class="container">
        <h1>紀錄</h1>
        <div class="item-input">
            <input type="text" placeholder="項目">
            <input type="text" placeholder="重量">
            <input type="number">
            <button type="submit">送出</button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'TrackProgress', 
    methods: {
        
    }
}
</script>

<style>
.container {
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
</style>