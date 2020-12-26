import Vue from 'vue'
import Router from "vue-router";

Vue.use(Router);

export const constantRoutes = [
    {
        path: '/login',
        component: () => import('@/views/login/index'),
    },
    {
        path: '/dashboard',
        component: () => import('@/views/dashboard/index')
    },
    {
        path: "/",
        redirect: '/dashboard'
    }
]


const createRouter = () => new Router({
    routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
    const newRouter = createRouter()
    router.matcher = newRouter.matcher // reset router
}

export default router
