# maven+spring+spring-mvc+mybatis整合demo（SSM）

# 手动安装Jar到maven仓库

```
mvn install:install-file -Dfile=D:\tmp\pagehelper-4.1.6.jar -DgroupId=com.github.pagehelper -DartifactId=pagehelper -Dversion=4.1.6 -Dpackaging=jar
```
然后reimport或者重启idea解决无法下载依赖jar问题