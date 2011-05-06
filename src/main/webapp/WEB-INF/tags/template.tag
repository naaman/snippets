<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="breadcrumb" required="false" rtexprvalue="true"%>
<%@ attribute name="hidesearch" required="false" rtexprvalue="false"%>
<%@ attribute name="includeAce" required="false" rtexprvalue="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>VMforce App: snippets</title>
	<link href="${pageContext.request.contextPath}/resources/layout.css" rel="stylesheet" type="text/css" />
	<c:if test="${includeAce == true}">
		<script src="${pageContext.request.contextPath}/resources/ace/src/ace.js" charset="UTF-8"></script>
	</c:if>
</head>
<body>
	<div id="header"><div id="app_title">snippets</div></div>
	<div id="navigation">${breadcrumb}</div>
	<div id="content">
	
		<jsp:doBody/>
	
	</div>
	<div id="footer"></div>
</body>
</html>
