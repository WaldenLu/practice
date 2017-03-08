<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <body>
	<div align ="center">
		<form action = "index" method = "post">
			<fieldset style ='width:300'>
				<lengend>请填写登录信息</lengend>
				<table align = "center" width = "400">
					<tr>
						<td align = "right" style = "font-weight:bold;">用户名：</td>
						<td>
							<input type = "text" name = "username" value = "" style = "width:200px;"/>
						</td>
					</tr>
					<tr>
						<td align = "right" style = "font-weight:bold;">密码：</td>
						<td>
							<input type = "password" name = "userpwd" value = "" style = "width:200px;"/>
						</td>
					</tr>
					<tr>
					<td align = "right" style = "font-weight:bold;"></td>
					<td>
						<input type = "submit"  value = "登录">
					</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>  
  </body>
</html>
