<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fom" %>--%>
<html>
<head>
    <title>Edit Post</title>
</head>
<body>

<!-- The edit function is not fully functional. Front/backend. -->

<div align="center">
    <h2>Edit Post</h2>
    <c:form method="POST" action="blogs" modelAttribute="blogs">
        <div style="border-radius:10px;border:1px solid gray;margin-top:50px;margin-left:700px;height: 400px;width:400px;padding-right:20px;padding-left:20px">
            <div class="mb-3">

                <label for="exampleFormControlInput1" class="form-label">Post Title</label>
                <input name="blogTitle" placeholder="Enter title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Post Description</label>
                <textarea name="blogBody" placeholder="Enter your blog description" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>
            <button type="submit">Save</button>
            <c:if test="${not empty message}">
                <div><p>${message}</p></div>
            </c:if>
        </div>
    </c:form>
</div>
</body>
</html>


