<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="container">
   
    <form role="form"  method="post" action="ScriptShell">

			<div class="form-group">
				<label for="command">Command:</label>
				<textarea name="command" class="form-control" rows="5" id="command"></textarea>
			</div>


			<div class="row">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </form>
</div>
<div style="text-align: center;">
<span  class="input-xlarge uneditable-input">
<c:forEach items="${ result }" var="res" varStatus="status">
    <c:out value="${ res }" /> </br>
</c:forEach>
</span>
</div>
  </body>
</html>