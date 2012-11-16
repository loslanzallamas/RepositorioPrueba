<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo</title>
<style type="text/css">
	a.test {font-weight: bold;}
</style>
</head>
<body>
	<a href="http://jquery.com/">jQuery</a>
	<script src="<%=request.getContextPath() %>/resources/jquery.js"></script>
	<script>
		$(document).ready(function(){
			$("a").click(function(event){
				alert("As you can see, the link no longer took you to jquery.com");
				event.preventDefault();
			$("a").addClass("test");
			});
		});
	</script>
</body>
</html>