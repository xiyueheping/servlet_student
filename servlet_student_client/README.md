- 一个搭建vue开发环境的模板
  - public：是真正部署的项目
  - public/output.js: src目录打包的目标文件
  - src:整个项目源代码目录，它里面的所有内容最终会打包到public中的output.js中
  - src/vue:所有的单文件组件存放在此
  - src/css:存放css文件最终会被打包到output.js中
  - src/modele:存放一些第三方js文件，最终会被打包到output.js中
  - index.js:src目录打包的入口文件
  - webpack.config.js:webpack配置文件
  - package.json:说明了项目所用依赖以及版本信息

- 项目搭建步骤：
  - 1.安装nodejs cnpm 
  - 2.全局安装webpack webpack-cli 
  - 3.安装axios jquery 
  - 4.在项目根目录打开powershell，执行cnpm install安装package.json文件中的所有依赖模块 
  - 5.执行npm run dev运行整个项目或执行webpack对源码打包再点击public中html文件运行项目