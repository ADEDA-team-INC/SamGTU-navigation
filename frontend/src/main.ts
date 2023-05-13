import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import { createPinia } from 'pinia'
import App from './App.vue'
import mainRoute from './routes'
import { i18n } from './i18n'
import './scss/style.scss'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: mainRoute
})

const pinia = createPinia()

const app = createApp(App)
app.use(router)
app.use(pinia)
app.use(i18n)

app.mount('#app')
