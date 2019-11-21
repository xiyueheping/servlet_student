//导入vue模块
import Vue from 'vue';
//导入路由模块
import VueRouter from 'vue-router'
//启用路由模块
Vue.use(VueRouter)
//导入axios模块  命令行安装
import axios from 'axios'
//将axios赋值到全局作用域，便于子组件使用
window.axios = axios;
//导入jQuery  命令行安装
import $ from 'jquery'
window.$ = $;

//导入css文件
import "./css/index.css"

//导入.vue单文件组件
import app from "./vue/app.vue"
import login from "./vue/login.vue"
import register from "./vue/register.vue"
import manage from "./vue/manage.vue"

//创建路由对象
var router = new VueRouter({
  routes:[
     {path:'/',redirect:'/login'},  //重定向根路径
     {path:'/login',component:login},
     {path:'/register',component:register},
     {path:'/manage',component:manage}
  ]
})

//创建根实例
var root = new Vue({
  el: '#root',
  data: {},
  render:function(create){
      return create(app)
  },
  router:router
});