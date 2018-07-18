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
                url : "testStudentWithComplexData.do",
                type : "post",
                data : {
                    amount : $("#amount").text(),
                    student : JSON.stringify($('form').serializeObject())
                },
                success : function (result) {
                    //alert(result)
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
    <span id="amount">33</span>
    <div id="textbox-style">
          <div id="response" style="text-align:center">
          </div>
    </div>
    <div>
        <p style="text-align: left; margin: 40px 0; color:blue">
           （1）说明： <br>
             表单还是上面的 Student 表单，但是在表单外增加了：span 标签的内容
             需求是：通过 Ajax 发送表单数据的同时，同时发送 "amount" 。

             经过测试，我就直接说结论了，有兴趣的童鞋可以自行探索，有新的发现欢迎和我交流。

             结论：

             不能对这样的数据，指定 "contentType:application/json"，否则后端SpringMVC或者第三方的Jar 包 不能进行自动的解析，增加了解析的复杂度，所以将 json 串传入后台，在后台进行解析。
        </p>
        <p  style="text-align: left; margin: 40px 0; color:blue">
            (2) 使用serializeObject()
        </p>
    </div>
</body>
</html>