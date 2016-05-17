<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL SQL标签</title>
</head>
<body>
	<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root" password="yshin1992" url="jdbc:mysql://127.0.0.1:3306/mldn"/>
	<sql:query var="queryFault" startRow="100" maxRows="50">SELECT * FROM mldn.bs_fault_machinery_log order by id desc</sql:query>
	sql:query查询出来的结果 它有以下属性：rows(结果集) rowsByIndex 根据字段索引取出列的内容 columnNames取得字段名称
	&nbsp;rowCount 取得全部的记录数 limitedByMaxRows 取出的最大数据长度
	<br/>
	共取出 ${queryFault.rowCount }条记录!
	<table border="1">
		<tr>
			<th>故障ID</th><th>车辆ID</th><th>故障码</th>
		</tr>
		<c:forEach items="${queryFault.rows }" var="row">
			<tr>
				<td>${row.id }</td><td>${row.machinery_id }</td>
				<td>${row.fault_code }</td>
			</tr>
		</c:forEach>
	</table>
	<hr/>
	sql:update var="保存更新的记录数" scope dataSource="数据源"
	<%-- 注释以防止测试时再次被执行
	<sql:update var="insertCount">
		insert into dept(deptno,dname,loc) values(2,"管理部","二楼左侧"),(3,"运营部","二楼右侧");
	</sql:update>
	共插入${insertCount }条数据 --%>
	<hr/>
	<sql:query var="result">select * from dept where deptno=?
		<sql:param>2</sql:param>
	</sql:query>
	<c:forEach items="${result.rows }" var="row">
		${row.deptno } | ${row.dname } | ${row.loc }
	</c:forEach>
	
	<hr/>
	sql:transaction dataSource="数据源" isolation="read_committed|read_uncommitted|repeatable|serializable"
	<%-- 注释以防止测试时再次被执行
	<sql:transaction isolation="read_committed">
	<sql:update var="insertCount">
		insert into dept(deptno,dname,loc) values(2,"管理部","二楼左侧"),(3,"运营部","二楼右侧");
	</sql:update>
	</sql:transaction>
	共插入${insertCount }条数据 --%>
	
</body>
</html>