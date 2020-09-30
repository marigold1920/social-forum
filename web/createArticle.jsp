<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;300;400;500;700&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="./css/blk-design-system.min.css" />
        <link rel="stylesheet" href="./css/index.css" />
        <script src="./js/jquery.min.js" type="text/javascript"></script>
        <script src="./js/bootstrap.min.js" type="text/javascript"></script>
        <title>Social Forum</title>
    </head>
    <body class="page">
        <c:set var="user" value="${sessionScope.USER}" />

        <c:if test="${empty user}">
            <c:redirect url="login.jsp" />
        </c:if>
        <c:set var="user" value="${sessionScope.USER}" />
        <c:set var="success" value="${requestScope.success}" />
        <c:set var="fail" value="${requestScope.fail}" />
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg bg-info">
            <div class="container">
                <div class="navbar-translate">
                    <a class="navbar-brand" href="ProcessServlet">Social Forum</a>
                    <button
                        class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#example-navbar-info"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                        >
                        <span class="navbar-toggler-bar bar1"></span>
                        <span class="navbar-toggler-bar bar2"></span>
                        <span class="navbar-toggler-bar bar3"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="example-navbar-info">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                id="navbarDropdownMenuLink"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                                >
                                <span>${user.name}</span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="ProcessServlet?action=showNotification">Thông báo</a>
                                <a class="dropdown-item" href="ProcessServlet?action=logout">Đăng xuất</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End navigation -->

        <!-- Body -->
        <div class="container" style="display: flex; justify-content: center">
            <form class="custom-form" action="ProcessServlet" method="post">
                <label class="text-success mt-3">${success}</label>
                <label class="text-error mt-3">${fail}</label>
                <input
                    class="form-control"
                    name="title"
                    type="text"
                    value=""
                    placeholder="Tiêu đề"
                    style="border-radius: 5px"
                    />
                <textarea
                    class="description"
                    rows="3"
                    name="description"
                    placeholder="Mô tả ngắn"
                    ></textarea>
                <textarea
                    class="description"
                    rows="10"
                    name="content"
                    placeholder="Nội dung"
                    style="resize: vertical"
                    ></textarea>
                <input class="mt-3" name="file" type="file" accept="image/png, iamge/jpeg" />
                <button style="display: block" class="btn btn-info mt-3" name="action" value="createArticle">
                    Đăng bài viết
                </button>
            </form>
        </div>
        <!-- End body -->
    </body>
</html>

