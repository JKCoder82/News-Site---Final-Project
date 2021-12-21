<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create a Post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Posts</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
            
            
<!-- Commenting this line of code until or unless I expand the # of jsp pages.  -->            
<!--                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="blogs">Home</a>
                </li>
 -->               
                
                
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/blogs/view">Show Posts</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<c:out value="${sessionScope.User}"/>
<form method="POST" action="createblog">
<div style="border-radius:10px;border:1px solid gray;margin-top:50px;margin-left:700px;height: 400px;width:400px;padding-right:20px;padding-left:20px">
    <div class="mb-3">
    <label for="exampleFormControlInput1" class="form-label">Post Title</label>
    <input name="blogTitle" placeholder="Enter title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
    </div>
    <div class="mb-3">
    <label for="exampleFormControlTextarea1" class="form-label">Post Description</label>
    <textarea name="blogBody" placeholder="Enter your blog description" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <button type="submit">Create Post</button>
    <c:if test="${not empty message}">
        <div><p>${message}</p></div>
    </c:if>
    <c:if test="${not empty deleteMessage}">
        <div><p>${deleteMessage}</p></div>
    </c:if>
</div>
</form>
</body>
</html>

