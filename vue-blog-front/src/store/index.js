import { createStore } from 'vuex'

export default createStore({
  state: {
	  token: localStorage.getItem("token"),
	  userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations: {
	  //==Java里的set方法
	  SET_TOKEN:(state,token)=>{
		  state.token=token;
		  localStorage.setItem("token",token);
	  },
	  SET_USERINFO:(state,userInfo)=>{
		  state.userInfo=userInfo;
		  //浏览器关闭状态会丢失，但是token还在
		  sessionStorage.setItem("userInfo",JSON.stringify(userInfo));
	  },
	  REMOVE_INFO:(state)=>{
		  state.token='';
		  state.userInfo={};
		  localStorage.setItem("token","");
		  sessionStorage.setItem("userInfo",JSON.stringify(""));
	  } 
  },
  getters:{
	  //==Java里的get方法
	  getUserInfo:(state)=>{
		  return state.userInfo;
	  },
	  getToken:(state)=>{
		  return state.token;
	  }
  },
  actions: {
  },
  modules: {
  }
})
