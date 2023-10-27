// 组件管理js，因为vant组件是按需引入，如果引入的组件过多，main.js中会堆积大量代码。
// 所以选择抽离出vant组件引入相关的代码放在utils文件夹的js文件中管理
import Vue from 'vue'
// 按需导入组件
import { Button, Slider } from 'element-ui'

Vue.use(Button)
  .use(Slider)

// Toast
// 在项目中任何地方使用导入调用
// import { Toast } from 'vant'
// Toast("提示内容")
// 在组件范围内使用
// this.$toast('提示内容')
