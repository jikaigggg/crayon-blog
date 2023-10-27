import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/layout'

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    { path: '/home', component: Layout },
    { path: '/', component: Layout }
  ]
})

export default router
