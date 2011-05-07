<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Editor</title>
  <style type="text/css" media="screen">
    body {
        overflow: hidden;
    }
    
    #editor { 
        margin: 0;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
    }
  </style>
</head>
<body>
<form>
<input type="submit" value="save" />
<div id="editor" style="height:90%">${snippet.body}</div>
   
<script src="/ace/src/ace.js" type="text/javascript" charset="utf-8"></script>
<script src="/ace/src/theme-twilight.js" type="text/javascript" charset="utf-8"></script>
<script src="/ace/src/mode-javascript.js" type="text/javascript" charset="utf-8"></script>
<script>
window.onload = function() {
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/twilight");
    
    var JavaScriptMode = require("ace/mode/javascript").Mode;
    editor.getSession().setMode(new JavaScriptMode());
};
</script>
</form>
</body>
</html>
