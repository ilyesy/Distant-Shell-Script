

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

  </head>
  <body>
    <form role="form" method="get" action="Start">
  <div class="form-group">
    <label for="host">host address:</label>
    <input type="host" name="host"  class="form-control" id="host">
  </div>
  <div class="form-group">
    <label for="user">User name:</label>
    <input type="user" name="user"  class="form-control" id="user">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" name="password"   class="form-control" id="pwd">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
  </body>
</html>



