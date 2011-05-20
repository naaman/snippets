<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Editor</title>
<style type="text/css" media="screen">
body, form {
	padding: 0px;
	margin:0px;
	//overflow: hidden;
}
.ui-corner-all {
    border-radius: 0px !important;
}
#toolbar {
	margin: 0px;
	padding: 0px;
	background: #DDD;
}

#editor {
	margin: 0px;
	position: relative;
	height: 100%;
	width: 100%;
}

#editor-tabs {
	position: relative;
	bottom: 0px;
	padding: 0px;
	border-width: 0px;
}

.tab-show {
	background: #AAA no-repeat right top;
	border-width: 0px 0px 0px 0px;
}
</style>
</head>
<body>
	<form>
		<div id="toolbar">
			<button id="save">save</button>
		</div>
		<div id="editor-tabs" class="tab-buttons-panel">
			<ul>
				<c:forEach var="snippet" items="${snippets}">
					<li><a href="#${snippet.id}">${snippet.name}</a></li>
				</c:forEach>
			</ul>
			<c:forEach var="snippet" items="${snippets}">
				<div id="${snippet.id}" style="display: none;">${snippet.body}</div>
			</c:forEach>
		</div>
		
		<div id="editor" style="width: 100%; height: 500px;"></div>

		<script src="/static/ace/src/ace.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="/static/ace/src/theme-twilight.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="/static/ace/src/mode-javascript.js"
			type="text/javascript" charset="utf-8"></script>
		<link type="text/css"
			href="/static/jquery/css/smoothness/jquery-ui-1.8.12.custom.css"
			rel="Stylesheet" />
		<script type="text/javascript"
			src="/static/jquery/js/jquery-1.5.1.min.js"></script>
		<script type="text/javascript"
			src="/static/jquery/js/jquery-ui-1.8.12.custom.min.js"></script>
		<script>
var editor;
$('#editor-tabs').tabs({
	select: function(event, ui) {
		var editorText = ui.panel.innerHTML;
		editor.getSession().setValue(editorText);
		return true;
	}
});
$("#save").button();
$(window).load(function() {
	editor = ace.edit("editor");
    editor.setTheme("ace/theme/twilight");
    var JavaScriptMode = require("ace/mode/javascript").Mode;
    editor.getSession().setMode(new JavaScriptMode());
	return true;
});
</script>
	</form>
</body>
</html>
