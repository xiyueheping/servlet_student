<template>
<div id="app-box">
  <!-- 路由组件渲染在此处 -->
  <router-view></router-view>
  <!-- 导航链接 -->
  <div id="app-box-nav">
     <router-link class="link-page1" to="/login">登录</router-link>
     <router-link class="link-page2" to="/register">注册</router-link>
     <router-link class="link-page3" to="/manage">学生管理</router-link>
  </div>
</div>
</template>


<script>
// app根组件
export default {
     data:function(){
     return {}
     },
      methods:{
     }
}
</script>


<style>
/* 根组件样式 */
*{
    margin: 0px;
    padding: 0px;
}
#app-box{
    padding-top:20px;
    width: 1000px;
    height: 630px;
    margin: 0 auto;
    background-color: #b6def8;
    position: relative;
    color: red;
}

/* 导航栏样式 */
#app-box-nav{
    /* background: #494949; */
    width: 100px;
    height: 200px;
    font-size: 16px;
    position:absolute;
    right: 10px;
    top:20px;
}

/*默认导航链接样式*/
.link-page1{
   text-decoration: none;
   display: block;
   text-align: center;
   margin-top: 5px;
}
.link-page2{
   text-decoration: none;
   display: block;
   text-align: center;
   margin-top: 5px;
}
.link-page3{
   text-decoration: none;
   display: block;
   text-align: center;
   margin-top: 5px;
}
/*激活状态的导航链接样式*/
.router-link-active{
    /* font-weight: bold; */
    color:red;
}
</style>