import { createApp } from 'vue'
import Antd from 'ant-design-vue';
import App from './App.vue'
import router from "@/router";

import 'ant-design-vue/dist/antd.less';
import './assets/css/common.less'

createApp(App).use(Antd).use(router).mount('#app')
