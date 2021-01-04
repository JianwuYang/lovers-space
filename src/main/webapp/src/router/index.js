import { createRouter, createWebHashHistory } from 'vue-router'
import Layout from '@/layout'
import Login from '@/views/login'

const constantRoutes = [
    {
        path: '/',
        component: Layout,
    },
    {
        path: '/login',
        component: Login
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes: constantRoutes,
})

export default router