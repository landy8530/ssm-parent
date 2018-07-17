<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>

<title>test simple json with ajax</title>

<script>
    $(function() {
      $('.ajax-button').click(function() {
        $.ajax({
            url: "testJson.do",
            type:"post",
            data: ({
                name : "abc",
                age : "23"
            }),
            success: function(data) {
                //alert(data)
                var json = JSON.stringify(data, null, 4);
                //alert(json)
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

</body>
</html>