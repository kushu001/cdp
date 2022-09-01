# CDP（Chomolungma Development Platform）
## 介绍

![image](https://user-images.githubusercontent.com/3797320/185794835-8fed3b7d-c401-4b8b-a7d4-ecba007d2d09.png#pic_center)

cdp是Chomolungma Development Platform（珠峰开发平台）的缩写
从无到有做一个Springboot开发框架，用于学习整个开发流程，提高自己整合相关技术的能力
大家可以拿个这项目练手，学习基本的框架知识
争取做一个可以用来开发简单私活的框架，方便大家使用
## 软件架构
1. 前端： 目前是使用vue-element-admin为基础，加上自己研发的部分组件，开发的一套前端框架 cdp-web-vue
2. 后端： 以SpringBoot为基础，利用mybatis持久框架进行后端服务的实现，开发的一套后端框架 cdp

## 安装教程
前端
  ```
    npm install
    npm run dev
  ```
后端：
1. 装个Mysql数据库，将cdp项目中resources目录下的sql文件导入到数据库中
  <img width="385" alt="image" src="https://user-images.githubusercontent.com/3797320/187810047-ef8a5c7c-db71-403d-90fe-cb5c8a3c40d9.png">

2. application.properties中配置一下相关的路径即可
3. 启动ChomolungmaApplication.java

## 界面截图

<img width="1511" alt="image" src="https://user-images.githubusercontent.com/3797320/185793574-455ed3d4-1772-48d3-8433-bfef96aca105.png">
<img width="1507" alt="image" src="https://user-images.githubusercontent.com/3797320/185793597-fb79f67c-84b0-4df3-aa03-e53053522982.png">
<img width="1509" alt="image" src="https://user-images.githubusercontent.com/3797320/185793610-68853393-5d56-4546-b14b-b51467875399.png">
<img width="1511" alt="image" src="https://user-images.githubusercontent.com/3797320/185793625-219d8143-bf21-4c3e-9532-3f4c935ebf59.png">
<img width="1508" alt="image" src="https://user-images.githubusercontent.com/3797320/185793637-d6011d8f-fcd7-4417-99bf-89a576007422.png">
<img width="1507" alt="image" src="https://user-images.githubusercontent.com/3797320/185793649-0767d03d-8f78-4996-806a-f33586d71b95.png">
<img width="1509" alt="image" src="https://user-images.githubusercontent.com/3797320/185793657-23c1ec61-bd59-4088-84f3-57732db6e7c8.png">
<img width="1509" alt="image" src="https://user-images.githubusercontent.com/3797320/185793666-33241540-9986-42a7-9982-f0e652029a21.png">
<img width="1508" alt="image" src="https://user-images.githubusercontent.com/3797320/185793682-71c46204-cc20-4a57-ad01-8af88e7d97af.png">
<img width="1059" alt="image" src="https://user-images.githubusercontent.com/3797320/185793694-6cc65eb1-e87b-45b6-a137-e785924eb2e6.png">

本项目已经全部开源，如果您觉得帮到了你，请给 本项目 一个Star

前端：

github: https://github.com/kushu001/cdp-web-vue

gitee: https://gitee.com/kushu001/cdp-web-vue

后端：

github: https://github.com/kushu001/cdp

gitee: https://gitee.com/kushu001/cdp

如果发现Bug，请到GITHUB提交Issue。
友情提示：提问前Star是很礼貌和友善的行为，被问者也会更开心回答您的问题。
