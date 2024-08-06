<!-- src/App.vue -->
<template>
	<div id="app">
		<nav>
			<ul>
				<li><router-link to="/">首頁</router-link></li>
				<li><router-link to="/videos">影片</router-link></li>
				<li><router-link to="/nutrition">營養計算</router-link></li>
				<li><router-link to="/progress">紀錄</router-link></li>
				<li><router-link to="/login">登入</router-link></li>
			</ul>
		</nav>
		<router-view></router-view>
	</div>
</template>

<script>
export default {
	name: 'App',
};
</script>

<style>

nav {
	padding: 1rem;
	display: flex;
	justify-content: center;
}

ul {
	list-style: none;
	display: flex;
	gap: 3rem;
	padding: 0;
	margin: 0;
}

li {
	display: inline;
}

a {
	color: black;
	text-decoration: none;
}

a.router-link-exact-active {
	font-weight: bold;
}
</style>
