<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>
    <g:if test="${flash.message}">
        ${flash.message}
    </g:if>
    <g:form action="importFile">
        Select file to import: <g:select name="fileName" from="${files}"/>
        <g:submitButton name="Go"/>
    </g:form>
</body>
</html>