## 技术选型&文档

- Spring Boot（[查看Spring Boot学习&使用指南](http://www.jianshu.com/p/1a9fd8936bd8)）
- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- MyBatisb通用Mapper插件（[查看官方中文文档](https://mapperhelper.github.io/docs/)）
- MyBatis PageHelper分页插件（[查看官方中文文档](https://pagehelper.github.io/)）
- Druid Spring Boot Starter（[查看官方中文文档](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)）
- Fastjson（[查看官方中文文档](https://github.com/Alibaba/fastjson/wiki/%E9%A6%96%E9%A1%B5)）
- 其他略

## 其他

1. tag、user等oracle保留字，在数据库里用了其他单词替换
2. tag没有和其他表建立外码关联（因为他是个数组，我不会写外码关联）
3. 具体数据库表名、属性，参考Google Drive里 数据库文件夹下的gravity.sql（建库脚本）