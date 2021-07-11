import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import axios from 'axios'
import 'mavon-editor/dist/css/index.css'

import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';
import Prism from 'prismjs';

import './axios'

VueMarkdownEditor.use(vuepressTheme, {
  Prism,
});

const app = createApp(App)
app.config.globalProperties.$store=store;
app.config.globalProperties.$axios=axios;
installElementPlus(app)
app.use(VueMarkdownEditor);
app.use(store).use(router).mount('#app')