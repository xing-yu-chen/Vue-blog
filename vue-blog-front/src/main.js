import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import axios from 'axios'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

import './axios'

const app = createApp(App)
app.config.globalProperties.$store=store;
app.config.globalProperties.$axios=axios;
installElementPlus(app)
app.use(store).use(router).use(mavonEditor).mount('#app')