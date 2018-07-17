# maven+spring+spring-mvc+mybatis整合demo（SSM）

## 1 手动安装Jar到maven仓库

```
mvn install:install-file -Dfile=D:\tmp\pagehelper-4.1.6.jar -DgroupId=com.github.pagehelper -DartifactId=pagehelper -Dversion=4.1.6 -Dpackaging=jar
```
然后reimport或者重启idea解决无法下载依赖jar问题

## 2 SpringMVC——对Ajax的处理（包含 JSON 类型）

转自：https://www.cnblogs.com/solverpeng/p/5821726.html

### 2.1 首先要搞明白的一些事情。

1.从客户端来看，需要搞明白：

（1）要发送什么样格式的 JSON 数据才能被服务器端的 SpringMVC 很便捷的处理，怎么才能让我们写更少的代码，如何做好 JSON 数据和实体之间的对应。

（2）如何组织这些发送的数据。

2.从服务器端来看，需要搞明白：

（1）SpringMVC 如何返回 JSON 数据。

（2）SpringMVC 如何处理请求的复杂数据。

3.$.ajax 的几个参数：

（1）contentType：

contentType: 'application/json;charset=utf-8'，作为请求头，用来告诉服务器消息的主体是序列化后的 JSON 字符串。除了低版本的 ie 浏览器外，各大浏览器都原生支持 JSON.stringify() 对对象进行序列化。

（2）dataType:预期服务器返回的数据类型。

4.SpringMVC 是如何处理 JSON 数据的

5.总体的思想：

（1）SpringMVC 能完成的，尽量借助于 SpringMVC，而不是我们手动的去解析。

（2）SpringMVC 解析不了的，尽量借助于第三方的 Jar 包来解析。

（3）SpringMVC 和 第三方 Jar 包解决不了的时候，我们再自己去解析。



### 2.2 想要搞明白第一个问题，前提是先要搞明白第一个问题：SpringMVC 是如何处理 JSON 数据的。

1.使用 HttpMessageConverter<T> 来处理  JSON 数据的。

Spring 的 HttpMessageConverter<T> 负责将请求信息转换为一个对象，将对象输出为响应信息。

2.API

（1）boolean canRead(Class<?> clazz, MediaType mediaType);

转换器是否可将请求信息转换为 clazz 类型的对象，同时支持指定的 MIME 类型，如： text/html,application/json 等。

（2）boolean canWrite(Class<?> clazz, MediaType mediaType);

转换器是否可以将 clazz 类型的对象写到响应中，响应支持的类型在 mediaType 中定义。

（3）List<MediaType> getSupportedMediaTypes();

改转换器支持的 MediaType 类型。

（4）T read(Class<? extends T> clazz, HttpInputMessage inputMessage);

将请求信息流转换为 clazz 类型的对象。

（5）void write(T t, MediaType contentType, HttpOutputMessage outputMessage)。

将 T 类型的对象写到响应输出流中，同时指定 MediaType。

3. 添加Jackson Jar包

4.具体的处理方法：

（1）使用 @RequestBody 和 HttpEntity<T> 对请求进行处理。

（2）使用 @ResponseBody 和 ResponseEntity<T> 对响应进行处理。

（3）@RequestBody 对处理方法的入参进行标注。

（4）@ResponseBody 对处理方法的签名进行标注。

（5）HttpEntity<T> 和 ResponseEntity<T> 作为处理方法的入参使用。

具体的使用方法会在下面例子中进行说明。

5.@RequestBody 和 @ResponseBody 是可以同时使用的。

### 2.3 发送客户端Json数据

上面简单介绍了 SpringMVC 是怎么处理 JSON 数据的，现在来看第二个问题：发送什么样格式的 JSON 数据才能被服务器端的 SpringMVC 很便捷的处理，这里主要指的是请求的 JSON 字符串和实体的映射。