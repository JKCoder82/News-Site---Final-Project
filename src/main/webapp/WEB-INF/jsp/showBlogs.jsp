<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Show Posts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .blogs {
            margin-top:10px;
        text-align: center;
        margin-left: 10px;
        height:500px;
        width:500px;
        border-radius:30px;
        }
        .delete {
            text-decoration: none;
            color:white;
            background-color:blue;
        }
        .edit {
            text-decoration: none;
            color:white;
            background-color:gray;
        }
        .blog-container {
            height: 500px;
            width:700px;
            box-shadow: 0 0 2px 1px gray;
        }
    </style>
       
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
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/blogs/createblog">Add Posts</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div style="margin-left:600px">


<!-- Adding a little info about us. -->

<h2 style="text-align:left;"><i>ABOUT THIS BLOG: A collection of news postings both from mainstream and alternative news sources. You must decide what information is truthful and that which is not. Don't let others do your thinking for you!</i></h2>
<br></br>

<h2 style="text-align:left center;"><u>News and Information: Fair and Balanced</u></h2>
<br></br>

    <h2>Posts:</h2>
    <div class="blogs">
    <c:forEach items="${blogs}" var="blog">
        <div class="blog-container">
        <p>${blog.blogTitle}</p>
        <p>${blog.blogBody}</p>
            <a class="edit btn" href="${pageContext.request.contextPath }/blogs/edit/${blog.id}">Edit Post</a> <span><a class="delete btn" href="${pageContext.request.contextPath }/blogs/delete/${blog.id}">Delete Post</a></span>
        </div>
            </c:forEach>
        <div>
        <c:if test="${not empty deleteMessage}">
            <c:forEach items="${remainingBlogs}" var="remainingBlog">
                <div class="blog-container">
                <p>${remainingBlog.blogTitle}</p>
                <p>${remainingBlog.blogBody}</p> <a class="edit" href="${pageContext.request.contextPath }/blogs/edit/${blog.id}">Edit Post</a> <span><a class="delete" href="${pageContext.request.contextPath }/blogs/delete/${blog.id}">Delete Post</a></span>
                </div>
            </c:forEach>
            <div><p>${deleteMessage}</p></div>
        </c:if>
        </div>
    </div>
</div>
</body>
</html>



