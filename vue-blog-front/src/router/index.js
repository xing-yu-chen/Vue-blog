import {createRouter,createWebHistory} from 'vue-router'
import Login from '../views/Login.vue'
import Blogs from '../views/Blogs.vue'
import BlogEdit from '../views/BlogEdit.vue'
import BlogDetail from '../views/BlogDetail.vue'

const routes = [
	{
		path: '/login',
		name: 'Login',
		component: Login
	},
	{
		path: '/blogs',
		name: 'Blogs',
		component: Blogs
	},
	{
		path: '/blogs/add',
		name: 'BlogEdit',
		meta: {
		    requireAuth: true
		  },
		component: BlogEdit
	},
	{
		path: '/blog/:blogId',
		name: 'BlogDetail',
		component: BlogDetail
	},
	{
		//:blogId作为一个参数被传过来
		path: '/blog/:blogId/edit',
		name: 'BlogEdit1',
		meta: {
		    requireAuth: true
		  },
		component: BlogEdit
	}
]

const router = createRouter({
	history: createWebHistory(process.env.BASE_URL),
	routes
})

export default router
