<template>
<div id="manage-box">
    <h1 style="text-align: center;">学生管理界面</h1>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>sex</th>
            <th>age</th>
            <th>major</th>
            <th>city</th>
            <th>操作</th>
        </tr>
        <tr v-for="s in students" :key="s.id">
            <td align="center">{{ s.id }}</td>
            <td align="center">{{s.name}}</td>
            <td align="center">{{s.sex}}</td>
            <td align="center">{{s.age}}</td>
            <td align="center">{{s.major}}</td>
            <td align="center">{{s.city}}</td>
            <td align="center"><a style="color:blue" v-on:click=delstudent(s.id)>删除</a> / <a v-on:click=alterstudent(s) style="color:green">修改</a></td>
        </tr>
    </table>
    <button v-on:click="addstudent">添加学生</button>
</div>
</template>
<script>
export default {
    data:function(){
        return{
            students:[]
        }
    },
    methods:{
        //获取所有学生信息
        getallstudent(){
               axios.get('http://localhost:8080/servlet_student_web_war_exploded/student/getall',
                  {
                   withCredentials:true
                  }
               )   //请求url，一个本地json文件
            .then((response) => {  //请求成功回调函数
                console.log(response.data);
                if(response.data.msg!=null){
                     this.students=response.data.msg;
                }
            })
            .catch((error) =>{ // 请求失败回调函数
                console.log(error);
            });
        },
        //添加学生
        addstudent(){
           var str = prompt("输入学生信息(空格隔开)");
           var arr = str.split(" ");
           if(arr.length<5){
               alert("数据输入有误，请重新输入");
               return;
           }
           var data = {
               name:arr[0],
               sex:arr[1],
               age:Number(arr[2]),
               major:arr[3],
               city:arr[4]
           }
           if(!(data.age>0&&data.age<=120)){
               alert("年龄输入有误，请重新输入");
               return;
           }
           console.log(data);

           axios.get('http://localhost:8080/servlet_student_web_war_exploded/student/add',
                  {
                   params: data,
                   withCredentials:true
                  }
               )   //请求url，一个本地json文件
            .then((response) => {  //请求成功回调函数
                console.log(response.data);
                if(response.data.msg==="添加成功"){
                    this.getallstudent();
                }else{
                    alert(response.data.msg);
                }
            })
            .catch((error) =>{ // 请求失败回调函数
                console.log(error);
            });
        },
        //删除学生
        delstudent(id){
            var data = {
                id:id
            }
            axios.get('http://localhost:8080/servlet_student_web_war_exploded/student/del',
                  {
                   params: data,
                   withCredentials:true
                  }
               )   //请求url，一个本地json文件
            .then((response) => {  //请求成功回调函数
                console.log(response.data);
                if(response.data.msg==="删除成功"){
                     this.getallstudent();
                }else{
                    alert(response.data.msg)
                }
            })
            .catch((error) =>{ // 请求失败回调函数
                console.log(error);
            });
        },
        //修改学生
        alterstudent(s){
            var str = prompt("输入新的学生信息(空格隔开)");
            var arr = str.split(" ");
              var data = {
               id:s.id,
               name:arr[0],
               sex:arr[1],
               age:Number(arr[2]),
               major:arr[3],
               city:arr[4]
           }
           //对数据格式进行验证
            if(arr.length<5){
               alert("数据输入有误，请重新输入");
               return;
           }
           if(s.name===data.name&&s.sex===data.sex&&s.age===data.age&&s.major===data.major&&s.city===data.city){
               alert("数据输入有误，请重新输入");
               return;
           }

             if(!(data.age>0&&data.age<=120)){
               alert("年龄输入有误，请重新输入");
               return;
           }
            axios.get('http://localhost:8080/servlet_student_web_war_exploded/student/alter',
                  {
                   params: data,
                   withCredentials:true
                  }
               )   //请求url，一个本地json文件
            .then((response) => {  //请求成功回调函数
                console.log(response.data);
                if(response.data.msg==="修改成功"){
                     this.getallstudent();
                }else{
                    alert(response.data.msg)
                }
            })
            .catch((error) =>{ // 请求失败回调函数
                console.log(error);
            });
        }
    },
     //在组件data method加载完成就调用方法发送Ajax请求
     created: function() {
            this.getallstudent();
        }
}
</script>
<style scoped >
/* 引入scoped后当前文件的样式代码只在当前文件生效，不会影响其他组件的样式 */
#manage-box{
    padding-top: 10px;
    width: 760px;
    height: 600px;
    margin: 0 auto;
    background-color: pink;
    padding-left: 30px;
}
td,th{
    width: 100px;
    height: 25px;
    border:1px solid #d66333
}
</style>