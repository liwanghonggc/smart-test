<%--
  Created by IntelliJ IDEA.
  User: lwh
  Date: 2018-06-02
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理-创建客户</title>
</head>
<body>
    <h1>创建客户界面</h1>

    <form id="customer_form" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/customer_create">
        <table>
            <tr>
                <td>客户名称:</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>联系人:</td>
                <td>
                    <input type="text" name="contact">
                </td>
            </tr>
            <tr>
                <td>电话号码:</td>
                <td>
                    <input type="text" name="telephone">
                </td>
            </tr>
            <tr>
                <td>邮箱地址:</td>
                <td>
                    <input type="text" name="email">
                </td>
            </tr>
            <tr>
                <td>照片:</td>
                <td>
                    <input type="file" name="photo">
                </td>
            </tr>
        </table>
        <button type="submit">保存</button>
    </form>

    <%--<script src="${BASE}/asset/lib/jquery/jquery.min.js"></script>
    <script src="${BASE}/asset/lib/jquery-form/jquery-form.js"></script>
    <script>
        $(function () {
            $("#customer_form").ajaxForm({
                type: 'post',
                url: '${BASE}/customer_create',
                success: function (data) {
                    if(data){
                        location.href = '${BASE}/customer';
                    }
                }
            });
        });
    </script>--%>
</body>
</html>
