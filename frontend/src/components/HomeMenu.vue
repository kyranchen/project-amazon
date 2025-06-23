<template>
    <div class="container">
        <h1>Home Page</h1>
        <p>Welcome to the Gym App!</p>
    </div>

    <div class="slider-container">
        <input type="radio" name="slider" id="slide1" checked style="display: none;">
        <input type="radio" name="slider" id="slide2"  style="display: none;">
        <input type="radio" name="slider" id="slide3"  style="display: none;">
        
        <div class="slides">
            <div class="slide" id="slide-1">
                <h2>Slide 1</h2>
                <p>This is the first slide.</p>
            </div>
            <div class="slide" id="slide-2">
                <h2>Slide 2</h2>
                <p>This is the second slide.</p>
            </div>
            <div class="slide" id="slide-3">
                <h2>Slide 3</h2>
                <p>This is the third slide.</p>
            </div>
        </div>
        
        <div class="navigation">
            <label for="slide1" class="nav-btn"></label>
            <label for="slide2" class="nav-btn"></label>
            <label for="slide3" class="nav-btn"></label>
        </div>
    </div>
</template>

<script>
export default {
    name: 'HomeMenu'
};
</script>

<style scoped>
.container {
    font-family: "Montserrat", sans-serif;
    background-color: gray;
}

.slider-container {
    position: relative;
    width: 100%;
    height: 200px;
    border-radius: 5px;
    overflow: hidden;
}

.slides {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 300%;
    height: 100%;
    transition: transform 0.5s ease-in-out;
}

.slide {
    width: 33%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: #4CAF50;
    color: white;
    font-size: 20px;
}

#slide1:checked ~ .slides {
    transform: translateX(0);
}

#slide2:checked ~ .slides {
    transform: translateX(-33%);
}

#slide3:checked ~ .slides {
    transform: translateX(-66%);
}

.navigation {
    position: absolute;
    bottom: 10px;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    gap: 10px;
}

.nav-btn {
    width: 15px;
    height: 15px;
    background-color: #bbb;
    border-radius: 50%;
    cursor: pointer;
    transition: background-color 0.3s;
}

#slide1:checked ~ .navigation label[for="slide1"],
#slide2:checked ~ .navigation label[for="slide2"] {
    background-color: #717171;
}
</style>