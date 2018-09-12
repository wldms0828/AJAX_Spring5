<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<link rel="shortcut icon" href="${context}/resources/img/favicon.ico" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${context}/resources/css/style.css" />
<link  rel="stylesheet" href="${context}/other_resources/dist/css/AdminLTE.min.css"type="text/css" />
<link rel="stylesheet" href="${context}/other_resources/dist/css/skins/_all-skins.min.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<%-- <script src="${context}/resources/js/app.js"></script> --%>
<script src="${context}/resources/js/algo.js"></script>
<script src="${context}/resources/js/router.js"></script>
</head>
<body>
<div id="wrapper"></div>	
<script>
	algo.init('${context}');
</script>
</body>
</html>





