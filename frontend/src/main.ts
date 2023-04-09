import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import mainRoute from './routes/cards-routes'
import './scss/style.scss'
import App from './App.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: mainRoute
})

const app = createApp(App)
app.use(router)
app.mount('#app')
