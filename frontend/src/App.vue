<!-- src/App.vue -->
<template>
	<div id="app">
		<nav>
			<ul>
				<li><router-link to="/">{{ $t('menu.nav.home') }}</router-link></li>
				<li><router-link to="/progress">{{ $t('menu.nav.record') }}</router-link></li>
				<li><router-link to="/nutrition">{{ $t('menu.nav.nutritious') }}</router-link></li>
				<li><router-link to="/videos">{{ $t('menu.nav.video') }}</router-link></li>
				<li><router-link to="/login">{{ $t('menu.nav.login') }}</router-link></li>
			</ul>
			<div class="lang-button">
				<button @click="languageChange('zh_TW')" class="lang-btn">{{ $t('menu.lang.tw') }}</button>
				<button @click="languageChange('en')" class="lang-btn">{{ $t('menu.lang.en') }}</button>
			</div>
		</nav>
		<router-view></router-view>
	</div>
</template>

<script>
import { setLanguage } from '@/locales/i18n';
export default {
	name: 'App',
	methods: {
		languageChange(lang) {
			setLanguage(lang);
		}
	}
};
</script>

<style scoped>
#app {
	font-family: "Montserrat", "Noto Sans TC", sans-serif;
}


nav {

	padding: 1rem;
	display: flex;
	justify-content: space-between;
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

.lang-button {
	display: flex;
	gap: 5px;
}

.lang-btn {
  background-color: #007bff; /* Primary button color */
  color: #ffffff;           /* Text color */
  border: none;             /* Remove default border */
  border-radius: 5px;      /* Rounded corners */
  padding: 10px 20px;      /* Padding inside the button */
  font-size: 16px;         /* Font size */
  cursor: pointer;         /* Pointer cursor on hover */
  transition: background-color 0.3s, box-shadow 0.3s; /* Smooth transition */
  display: flex;
  align-items: center;
  justify-content: center;
  min-width: 50px;        /* Minimum width for consistency */
  height: 30px;           /* Set height for uniformity */
  text-align: center;     /* Center text horizontally */
}

.lang-btn:hover {
  background-color: #0056b3; /* Darker shade for hover */
}

.lang-btn:active {
  background-color: #004085; /* Even darker shade for active state */
}

.lang-btn:focus {
  outline: none; /* Remove default focus outline */
  box-shadow: 0 0 0 3px rgba(38, 143, 255, 0.5); /* Custom focus outline */
  font-weight: bold;
}
</style>
