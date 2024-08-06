// src/router.js
import { createRouter, createWebHistory } from 'vue-router';
import HomeMenu from './components/HomeMenu.vue';
import TutorialVideos from './components/TutorialVideos.vue';
import TrackNutrition from './components/TrackNutrition.vue';
import TrackProgress from './components/TrackProgress.vue';
import LoginPage from './components/LoginPage.vue';

const routes = [
  { path: '/', component: HomeMenu, name: 'HomeMenu' },
  { path: '/videos', component: TutorialVideos, name: 'TutorialVideos' },
  { path: '/nutrition', component: TrackNutrition, name: 'TrackNutrition' },
  { path: '/progress', component: TrackProgress, name: 'TrackProgress' },
  { path: '/login', component: LoginPage, name: 'LoginPage' },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
