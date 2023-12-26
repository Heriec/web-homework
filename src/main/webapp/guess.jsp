<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>猜数</title>
    <script>
        window.onload = function () {
            let restart = document.getElementById("restart");
            restart.onclick = function () {
                location.href = '<%=response.encodeURL("restart")%>';
            }
            let rankList = document.getElementById("rankList");
            rankList.onclick = function () {
                location.href = '<%=response.encodeURL("rankList")%>';
            }
            let logout = document.getElementById("logout");
            logout.onclick = function () {
                location.href = '<%=response.encodeURL("logout")%>';
            }

        }
    </script>
</head>
<body>
<h1>猜数</h1>
<form action="guess" method="post">
    <label for="guessNum">请输入一个数字：</label>
    <input type="number" id="guessNum" name="guessNum">
    <button type="submit">猜一下</button>
</form>
<p style="color: red">
    <%
        Integer guessCount = (Integer) session.getAttribute("guessCount");
        if (guessCount != null) {
    %>
    当前猜测次数： <%=guessCount%>
    <%
        }
    %>
</p>
<p>
    <%
        String message = (String) session.getAttribute("message");
        if (message != null) {
    %>
    提示：<%=message%>
    <%
        }
    %>
</p>
<div>
    <button id='restart' type="submit">重新开始</button>
    <button id='rankList' type="submit">查看排行榜</button>
    <button id='logout' type="submit">退出登录</button>
</div>
</body>
</html>