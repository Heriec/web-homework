<!DOCTYPE html>
<html>
<head>
    <title>计算最大公约数</title>
</head>
<body>
<h1>计算两个整数的最大公约数</h1>
<form action="gcd" method="post">
    <label for="num1">请输入第一个整数：</label>
    <input type="text" id="num1" name="num1">
    <br><br>
    <label for="num2">请输入第二个整数：</label>
    <input type="text" id="num2" name="num2">
    <br><br>
    <input type="submit" value="计算">
</form>
<p>
    <%
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        Integer result = (Integer) request.getAttribute("result");
        if (num1 != null && num2 != null && result != null) {
    %>
    The <%=num1%>, <%=num2%> 的最大公约数为： <%=result%>
    <%
        }
    %>
</p>
</body>
</html>