const path = require('path')
var VueLoaderPlugin = require("vue-loader/lib/plugin")
module.exports = {
    entry:'./src/index.js',  //指定入口文件
    output:{                //指定出口文件
        path:path.resolve(__dirname,'public'),
        filename:'output.js'
    },
    devServer:{//指定服务运行目录
        contentBase:path.join(__dirname,'public'),
        compress:true,
        port:9000
    },
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js'
        }
    },
    plugins:[
        new VueLoaderPlugin()
    ],
    module:{
        rules:[ //第三方文件的匹配规则
            {     //匹配后缀名为css的文件,然后分别用css-loader，vue-style-loader去解析
                  test: /\.css$/,
                  use: [
                      'style-loader',
                      'css-loader'
                  ],
            },
            {     //匹配后缀名为vue的文件
                test: /\.vue$/,
                use: [
                    'vue-loader'
                ]
          },
        ]
    }
}
