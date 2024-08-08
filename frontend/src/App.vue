<!-- src/App.vue -->
<template>
	<div id="app">
		<nav>
			<ul>
				<li><router-link to="/">{{ $t('menu.nav.home') }}</router-link></li>
				<li><router-link to="/videos">{{ $t('menu.nav.video') }}</router-link></li>
				<li><router-link to="/nutrition">{{ $t('menu.nav.nutritious') }}</router-link></li>
				<li><router-link to="/progress">{{ $t('menu.nav.record') }}</router-link></li>
				<li><router-link to="/login">{{ $t('menu.nav.login') }}</router-link></li>
			</ul>
			<div class="lang-button">
				<button @click="languageChange('zh_TW')">中</button>
				<button @click="languageChange('en')">英</button>
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

<style>

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
	text-align:end;
}
</style>
