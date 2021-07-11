import axios from 'axios'
import router from './router'
import store from './store'

import {ElMessage} from 'element-plus';

//设置请求前缀
axios.defaults.baseURL = "http://localhost:8080";
axios.defaults.crossDomain = true;
// axios.defaults.withCredentials = true;
axios.defaults.headers.common['Authorization'] = localStorage.getItem('token');

//前置拦截，在发起请求的时候的配置，在config中配置请求头等等的信息
axios.interceptors.request.use(config => {
	const token = window.localStorage.getItem("token");
	if(token!=null){
		config.headers.Authorization = token
	}
	console.log("前置拦截器");
	console.log(config)
	return config;
},
  error => {
    return Promise.error(error);
  });


//后置拦截
axios.interceptors.response.use(response => {
		console.log("后置拦截器"+response);
		let res = response.data;
		if (res.code === 200) {
			return response;
		} else {
			ElMessage.error(res.msg);
			//结束请求
			return Promise.reject(res);
		}
	},
	error => {
		//未授权：登录失败 
		if(error.response.status === 401){
			store.commit("REMOBVE_INFO");
			router.push("/login");
		}
		ElMessage.error(error.message);
		//结束请求
		return Promise.reject(error);
		
	}
);
