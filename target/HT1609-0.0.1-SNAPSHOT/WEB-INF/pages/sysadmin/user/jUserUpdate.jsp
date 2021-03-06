<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户修改</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('update','_self');this.blur();">更新</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户更新
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tbody class="tableBody" >
		<tr>
			<td><input name="userId" value="${user.userId}" type="hidden"/></td>
		</tr>
		<tr class="odd">
			<td>用户名:</td>
			<td><input id="username" name="username" type="text" value="${user.username}"/></td>
			<td>密码:</td>
			<td><input id="password" name="password" type="password"/></td>
		</tr>
		<tr class="odd">
			<td>所在部门:</td>
			<td>
				<select name="dept.deptId" style="width:122px">
					<c:forEach items="${deptList}" var="d">
						<option value="${d.deptId}" 
							<c:if test="${d.deptId ==user.dept.deptId}">selected="selected"</c:if>
						>${d.deptName}</option>
					</c:forEach>
				</select>
			</td>
			<td>真实姓名:</td>
			<td><input name="userInfo.name" type="text" value="${user.userInfo.name}"/></td>
		</tr>
		<tr class="odd">
			<td>身份证号:</td>
			<td><input name="userInfo.cardNo" type="text" value="${user.userInfo.cardNo}"/></td>
			<td>上级领导:</td>
			<td>
				<select name="userInfo.manager.userInfoId" style="width:120px">
				
					<c:forEach items="${managerList}" var="m">
						<option value="${m.userInfoId}"  
							<c:if test="${m.userInfoId == user.userInfo.manager.userInfoId}">selected="selected"</c:if>
						>${m.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td>入职日期:</td>
			<td>
			<input type="text" style="width:90px;" name="userInfo.joinDate"
	   		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"
	   		value="<fmt:formatDate value='${user.userInfo.joinDate}' pattern='yyyy-MM-dd'/>"
	   		
	   		/>
			</td>
			<td>工资:</td>
			<td><input name="userInfo.salary" type="text" value="${user.userInfo.salary}"/></td>
		</tr>
		<tr class="odd">
			<td>生日:</td>
			<td>
				<input type="text" style="width:90px;" name="userInfo.birthday"
	   			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"
	   				value="<fmt:formatDate value='${user.userInfo.birthday}' pattern='yyyy-MM-dd'/>"
	   			/>
			</td>
			<td>性别:</td>
			<td>
				<input name="userInfo.gender" type="radio" value="男" <c:if test="${user.userInfo.gender =='男'}">checked="checked"</c:if>/>男
				<input name="userInfo.gender" type="radio" value="女" <c:if test="${user.userInfo.gender =='女'}">checked="checked"</c:if>/>女
				
			</td>
		</tr>
		<tr class="odd">
			<td>岗位:</td>
			<td><input name="userInfo.station" type="text" value="${user.userInfo.station}"/></td>
			<td>用户级别:</td>
			<td>
				<select name="userInfo.userLevel" style="width:120px">
					
					<option value="1"  <c:if test="${user.userInfo.userLevel ==1}">selected="selected"</c:if>>总经理</option>
					<option value="2"  <c:if test="${user.userInfo.userLevel ==2}">selected="selected"</c:if>>副总</option>
					<option value="3"  <c:if test="${user.userInfo.userLevel ==3}">selected="selected"</c:if>>部门经理</option>
					<option value="4"  <c:if test="${user.userInfo.userLevel ==4}">selected="selected"</c:if>>普通用户</option>
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td>电话号码:</td>
			<td><input name="userInfo.telephone" type="text" value="${user.userInfo.telephone}"/></td>
			<td>排序号:</td>
			<td><input name="userInfo.orderNo" type="text" value="${user.userInfo.orderNo}"/></td>
		</tr>
		<tr class="odd">
			<td>备注信息:</td>
			<td colspan="3">
				<textarea style="width:100%;height:120px" name="userInfo.remark" >
					${user.userInfo.remark}
				</textarea>
			</td>
		</tr>
		
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

