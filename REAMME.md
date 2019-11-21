- 基于servlet的学生管理案例
- 项目分两个部分，前端与后台是独立的两个项目
- 前端存放在servlet_student_client目录，后台存放在servlet_student_web目录
- 前端项目下载完成之后，搭建好nodejs环境以及安装cnpm，全局安装webpack以及webpack-cli后使用cnpm install安装第三方依赖模块。
- 最后使用 npm run dev 运行vue项目，也可以使用webpack命令对代码进行压缩打包

- 后台项目下载完成后，首先idea中集成tomcat，然后把项目做为一个模块引入idea中。
- 没什么问题就可以直接在idea中运行了
- 后期进行项目部署的时候，要在idea工作目录的out目录寻找对应编译打包后的目录，把打包后的目录直接粘到tomcat的webapps目录中直接通过tomcat启动web服务器。
