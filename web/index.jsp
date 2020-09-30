<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/blk-design-system.min.css" />
        <link rel="stylesheet" href="./css/index.css" />
        <script src="./js/jquery.min.js" type="text/javascript"></script>
        <script src="./js/bootstrap.min.js" type="text/javascript"></script>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;300;400;500;700&display=swap"
            rel="stylesheet"
            />
        <!-- Nucleo Icons -->
        <title>Social Forum</title>
    </head>
    <body class="page">
        <c:set var="aritcles" value="${sessionScope.articles}" />
        <c:set var="user" value="${sessionScope.USER}" />
        <c:set var="keyword" value="${sessionScope.keyword}" />
        <c:set var="totalPage" value="${sessionScope.totalPage}" />
        <c:set var="currentPage" value="${sessionScope.currentPage}" />
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
                    <ul class="navbar-nav ml-auto"><c:choose>
                            <c:when test="${not empty user}">
                                <form class="form-custom" action="ProcessServlet" method="post">
                                    <input
                                        class="form-control form-control-round"
                                        type="search"
                                        value="${keyword}"
                                        name="keyword"
                                        placeholder="Tìm kiếm nội dung"
                                        />
                                    <button class="btn btn-primary btn-round" name="action" value="search">Search</button>
                                </form>
                                <li class="nav-item active">
                                    <a class="btn btn-success btn-round" href="createArticle.jsp">Tạo bài viết</a>
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
                            </c:when>
                            <c:otherwise>
                                <li class="nav-item">
                                    <a class="nav-link" href="login.jsp">Đăng nhập</a> hoặc <a class="nav-link" href="login.jsp">Đăng ký</a> để Tìm kiếm hoặc Đăng bài.
                                </li>
                            </c:otherwise>
                        </c:choose>                           
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End navigation -->

        <!-- Body -->
        <div class="container p-0">
            <c:if test="${articles.size() > 0}">
                <div class="header">
                    <h3 class="pt-5">Mới nhất</h3>
                </div>
                <div class="row pl-3">
                    <c:forEach var="article" items="${articles}">
                        <div class="col-6 mb-5">
                            <div class="row news-item">
                                <div class="col-4 px-0">
                                    <img src="images/${article.image}" />
                                </div>
                                <div class="col-8 pl-1 pr-3">
                                    <a href="ProcessServlet?action=getArticleDetails&articleId=${article.articleId}"
                                       ><h4 class="custom-text px-2">
                                            ${article.title}
                                        </h4></a
                                    >
                                    <p class="custom-text px-2">
                                        ${article.description}
                                    </p>
                                    <p class="date-published pl-2">${article.publishedDate}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </div>
        <!-- End body -->

        <!-- Pagination -->
        <div class="container">
            <ul class="pagination pagination-primary align-center">
                <c:forEach var="page" begin="1" end="${totalPage}">
                    <li class="page-item ${page == currentPage ? "active" : ""}">
                        <a class="page-link" href="ProcessServlet?page=${page}">${page}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <!-- End pagination -->
        ${totalPage}
    </body>
</html>

