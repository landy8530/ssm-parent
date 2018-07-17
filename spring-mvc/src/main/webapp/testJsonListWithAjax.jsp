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
      var data = [{ "name": "Brett", "age":"12" }, { "name": "Jason", "age":"23" }, { "name": "Elliotte", "age":"33" }];
      $('.ajax-button').click(function() {
        $.ajax({
            url: "testJsonList.do",
            type:"post",
            //data: '[{ "name": "Brett", "age":"12" }, { "name": "Jason", "age":"23" }, { "name": "Elliotte", "age":"33" }]',
            data :  JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            success: function(data) {
                //alert(data)
                var json = JSON.stringify(data, null, 4);
                //alert(json)
                $('#response').html(json);
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
        <p  style="text-align: left; margin: 40px 0; color:blue">
            HTTP 400 错误 - 请求无效 (Bad request) <br>
            在ajax请求后台数据时有时会报 HTTP 400 错误 - 请求无效 (Bad request);出现这个请求无效报错说明请求没有进入到后台服务里；<br>
            原因：<br>
                 1）前端提交数据的字段名称或者是字段类型和后台的实体类不一致，导致无法封装；<br>
                 2）前端提交的到后台的数据应该是json字符串类型，而前端没有将对象转化为字符串类型；<br>
            解决方案：<br>
                1）对照字段名称，类型保证一致性<br>
                2）使用stringify将前端传递的对象转化为字符串    data: JSON.stringify(param)  ;<br>
        </p>
    </div>
</body>
</html>