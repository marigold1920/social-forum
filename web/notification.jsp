<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <c:set var="notifications" value="${sessionScope.notifications}" />
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
                        <li class="nav-item active">
                            <a class="btn btn-success btn-round" href="#pablo">Tạo bài viết</a>
                        </li>
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
                                <a class="dropdown-item" href="#">Quản lí bài viết</a>
                                <a class="dropdown-item" href="ProcessServlet?action=logout">Đăng xuất</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End navigation -->

        <div class="container mt-3">
            <div class="list" style="max-height: 85vh; overflow: hidden; overflow-y: scroll;">
                <h4 class="header" style="text-transform: uppercase; font-size: 1.35rem; font-weight: 400">Thông báo mới nhất</h4>
                <c:choose>
                    <c:when test="${notifications.size() > 0}">
                        <c:forEach var="notification" items="${notifications}">
                            <a href="ProcessServlet?action=getArticleDetails&articleId=${notification.articleId}"><div class="item bottom-line">
                                    <div class="group-info mt-4" method="post">
                                        <span>${notification.owner} <span class="text-right text-black-50">${notification.createdDate}</span></span>
                                    </div>
                                    <p style="display: block">${notification.content}</p>
                                </div>
                            </a>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <label>Không có thông báo nào</label>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
