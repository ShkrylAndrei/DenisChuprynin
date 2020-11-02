<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
   <head>
        <title>Title</title>
        <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
   </head>
<body bgcolor="<spring:theme code='background'/>">
<table>
  <form:form action="save" method="post">
	<tr><td><form:input  path="name"/> </td> </tr>
	<tr><td><form:input path="age"/> </td> </tr>
	<tr> <td colspan=2>
	   <input type="submit" value="Submit">
	</td></tr>
  </form:form>
 </table>
</body>
</html>
