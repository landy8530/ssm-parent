<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="addUserForm" method="post" action="/user/addUser">
		<table cellpadding="3">
			<tr>
				<td style="padding-right: 5px; text-align: right">
					姓名：
				</td>
				<td style="padding-left: 5px; text-align: left">
					<input type="text" name="name" />
				</td>
			</tr>
			<tr>
				<td style="padding-right: 5px; text-align: right">
					密码：
				</td>
				<td style="padding-left: 5px; text-align: left">
					<input type="text" name="password" />
				</td>
			</tr>
			<tr>
				<td style="padding-right: 5px; text-align: right" colspan="2">
					<a class="easyui-linkbutton" href="#" onclick="addUser('addUserForm');"
						data-options="iconCls : 'icon-ok'">提交</a>
				</td>
			</tr>
		</table>
	</form>
</div>
