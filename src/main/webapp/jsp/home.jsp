<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>

</head>
<body>
<center>

<br/>
	<br/>
		<div style="padding:17px 17px; width:1024px;">
		
			<table cellpadding="0" cellspacing="0"class="patient-tab">
			<tr class="patient_head">
				<td>userId</td>
				<td>userName</td>
				<td>password</td>
				<td>userRole</td>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr  class="patient_tr">
					<td style="color:#0078C1">${user['userId']}</td>
					<td>${user['userName']}</td>
					<td>${user['password']}</td>
					<td>${user['userRole']}</td>
				</tr>
			</c:forEach>
			</table>
			<br>
		<div>
				<c:if test="${patientsPaginator.page>1}"><a class="pageNum" href="patientlist.do?pageNum=${patientsPaginator.page-1}"> << </a>&nbsp;</c:if>
				   <c:forEach var="i" begin="1" end="${patientsPaginator.totalPages}" step="1">
				   		<c:choose>
				   			<c:when test="${patientsPaginator.page==i}"><a href="patientlist.do?pageNum=${i}" class="currentPage">${i}</a></c:when> 
      						<c:otherwise><a class="pageNum" href="patientlist.do?pageNum=${i}">${i}</a></c:otherwise>
      					</c:choose>
    				</c:forEach> 
				<c:if test="${patientsPaginator.totalPages >patientsPaginator.page}"><a class="pageNum" href="patientlist.do?pageNum=${patientsPaginator.page+1}"> >> </a></c:if>
					
		
		</div>	
		</div>
		</center>
</body>
</html>