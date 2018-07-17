<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>

<title>test json list with ajax</title>

<script>
    $(function() {
      var personList = [];
      personList.push({name: "李四",age: "23"});
      personList.push({name: "张三",age: "12"});
      $('.ajax-button').click(function() {
        $.ajax({
            url: "testJsonListWithNonForm.do",
            type:"post",
            data :  JSON.stringify(personList),
            contentType: "application/json; charset=utf-8",
            success: function(data) {
                var json = JSON.stringify(data, null, 4);
                $('#response').html(json);
                console.log(json);
            },
            error : function(e) {
                var json = JSON.stringify(e, null, 4);
                $('#response').html(json);
                console.log("ERROR: ", e);
            },
            done : function(e) {
                console.log("DONE");
            }
         });
      });
    });

</script>

</head>
<body>
    <div>
      <p  style="text-align: center; margin: 40px 0;">
          <a class="ajax-button makble_button_large_green">Send Ajax request</a></p>
    </div>
    <div id="textbox-style">
          <div id="response" style="text-align:center">
          </div>
    </div>
    <div>
        <p style="text-align: left; margin: 40px 0; color:blue">
             （1）说明： <br>
             上面说的两个例子，仅仅是最简单的一种形式。现在对其进行扩展，在四里，所说的 SpringMVC 如何处理这些数据，不仅仅指的是SpringMVC，也包括SpringMVC处理不了，使用第三方来处理，或者第三方处理不了，我自己来处理。
             同时这里的数据也不仅仅指的 JSON 类型的数据。
        </p>
        <p  style="text-align: left; margin: 40px 0; color:blue">
           （2）对于非表单的 Ajax 提交，这里只提供比较简单的一种方式。还是以上面的 Person 为例。(其实跟testJsonListWithAjax.jsp效果一样)<br>
        </p>
    </div>
</body>
</html>