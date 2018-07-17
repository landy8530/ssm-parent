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
    $.fn.serializeObject = function()
    {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };


    $(function() {
        $('form').submit(function() {
            $.ajax({
                url : "testStudent.do",
                data : JSON.stringify($('form').serializeObject()),
                contentType : "application/json;charset=utf-8",
                type : "post",
                success : function (result) {
                    var json = JSON.stringify(result, null, 4);
                    $('#response').html(json);
                    console.log(result);
                }
            });
            return false;
        });
    });

</script>

</head>
<body>


    <form action="" method="post" style="text-align: center; margin: 40px 0;">
        First Name:<input type="text" name="firstName" maxlength="12" size="12"/> <br/>
        Last Name:<input type="text" name="lastName" maxlength="36" size="12"/> <br/>
        Gender:<br/>
        Male:<input type="radio" name="gender" value="1"/><br/>
        Female:<input type="radio" name="gender" value="0"/><br/>
        Favorite Food:<br/>
        Steak:<input type="checkbox" name="foods" value="Steak"/><br/>
        Pizza:<input type="checkbox" name="foods" value="Pizza"/><br/>
        Chicken:<input type="checkbox" name="foods" value="Chicken"/><br/>
        <textarea wrap="physical" cols="20" name="quote" rows="5">Enter your favorite quote!</textarea><br/>
        Select a Level of Education:<br/>
        <select name="education">
            <option value="Jr.High">Jr.High</option>
            <option value="HighSchool">HighSchool</option>
            <option value="College">College</option>
        </select><br/>
        Select your favorite time of day:<br/>
        <select size="3" name="tOfD">
            <option value="Morning">Morning</option>
            <option value="Day">Day</option>
            <option value="Night">Night</option>
        </select>
        <p style="text-align: center; margin: 40px 0;"><input type="submit" class="ajax-button makble_button_large_green"/></p>
    </form>
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
           （2）基于表单的 Ajax 提交 提供一个序列化方法：<br>
            JSON.stringify($('form').serializeObject())：<br>

           {"firstName":"jack","lastName":"lily","gender":"1","foods":["Pizza","Chicken"],"quote":"hello hello","education":"Jr.High","tOfD":"Day"} <br>
        </p>
    </div>
</body>
</html>