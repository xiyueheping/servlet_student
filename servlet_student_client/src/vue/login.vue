<template>
<div id="login-box">
    <h1 style="text-align: center;">登录界面</h1>
    <form>
        <div style="margin-left:100px;margin-top:20px;"> 账 号：<input v-model="username" type="text"></div>
        <div style="margin-left:100px;margin-top:20px;"> 密 码：<input v-model="password" type="password"></div>
        <div style="margin-left:100px;margin-top:20px;">
            <img style="width:100px;height:50px;" v-bind:src="checkcodeurl">
            <a v-on:click="changecheckcode"> 看不清，换一张</a>
        </div>
        <div style="margin-left:100px;margin-top:20px;">验证码：<input v-model="checkcodelogin" type="text"></div>
    <button v-on:click="login" style="margin-left:200px;margin-top:20px;">提交</button>
    </form>
</div>
</template>
<script>
export default {
    data:function(){
        return{
            username:"",
            password:"",
            checkcodelogin:"",
            checkcodeurl:"http://localhost:8080/servlet_student_web_war_exploded/user/checkcodelogin"
        }
    },
    methods:{
        //登录方法
        login(){
           var data={
                username:this.username,
                password:this.password,
                checkcodelogin:this.checkcodelogin
            }
               axios.get('http://localhost:8080/servlet_student_web_war_exploded/user/login',
                  {
                   params: data,
                   withCredentials:true
                  } 
               )   //请求url，一个本地json文件
            .then((response) => {  //请求成功回调函数
                alert(response.data.msg);
                console.log(response.data);
                
            })
            .catch((error) =>{ // 请求失败回调函数
                console.log(error);
            });
        },
        //切换验证码图片
        changecheckcode(){
            this.checkcodeurl=this.checkcodeurl+"?"+Date.parse(new Date());
        }
    }
}
</script>
<style scoped >

/* 引入scoped后当前文件的样式代码只在当前文件生效，不会影响其他组件的样式 */
#login-box{
    padding-top: 10px;
    width: 500px;
    height: 400px;
    margin: 0 auto;
    background-color: pink;
}
</style>