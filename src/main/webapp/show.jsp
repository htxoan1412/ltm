<%@ page import="com.example.model.SinhvienModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.dao.SinhVienDao" %><%--
  Created by IntelliJ IDEA.
  User: ran
  Date: 8/17/2021
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (request.getParameter("msg") != null) {
        if ("1".equals(request.getParameter("msg"))) {
            out.print("<span>Thêm thành công</span>");
        } else if ("2".equals(request.getParameter("msg"))) {
            out.print("<span>Xóa thành công</span>");
        }
    }
    if (request.getParameter("err") != null) {
        if ("2".equals(request.getParameter("err"))) {
            out.print("<span>Xóa thất bại</span>");
        }
    }

%>
<table border="1">

    <tr>
        <th>MSSV</th>
        <th>Họ tên</th>
        <th>Giới tính</th>
        <th>Khoa</th>
    </tr>

    <%
            ArrayList<SinhvienModel> sv = (ArrayList<SinhvienModel>)new SinhVienDao().selectSinhvien();
            for (SinhvienModel item :sv){
    %>
    <tr>

<%--        <td><%=item.getId()%></td>--%>
        <td><%=item.getMssv()%></td>
        <td><%=item.getHoten()%></td>
        <td><%=item.getGioitinh()%></td>
         <td><%=item.getKhoa()%></td>

        <td>
            <a href="/delete?id=<%=item.getId()%>">Delete</a>
            <a href="/update?id=<%=item.getId()%>">Edit</a>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>
