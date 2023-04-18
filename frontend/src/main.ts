import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import { createPinia } from 'pinia'
import mainRoute from './routes'
import './scss/style.scss'
import App from './App.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: mainRoute
})

const pinia = createPinia()

const app = createApp(App)
app.use(router)
app.use(pinia)
app.mount('#app')
