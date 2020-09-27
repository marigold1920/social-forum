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
        <c:set var="article" value="${requestScope.article}" />
        <nav class="navbar navbar-expand-lg bg-info">
            <div class="container">
                <div class="navbar-translate">
                    <a class="navbar-brand" href="index.jsp">Social Forum</a>
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
                        <form class="form-custom" action="#" method="post">
                            <input
                                class="form-control form-control-round"
                                type="search"
                                value=""
                                name="search"
                                />
                            <button class="btn btn-primary btn-round" name="action">Search</button>
                        </form>
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
                                <span>Victor</span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Quản lí bài viết</a>
                                <a class="dropdown-item" href="#">Đăng xuất</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End navigation -->

        <!-- Body content -->
        <div class="container">
            <div class="news-header">
                <div class="line">
                    <h2>${article.title}</h2>
                    <div class="publish-info">
                        <p>Đăng vào <b>${article.publishedDate}</b></p>
                    </div>
                    <div class="emotions">
                        <span class="badge badge-info py-2 px-4"><a href="#">Like</a> 26</span>
                        <span class="badge badge-default py-2 px-4"><a href="#">Dislike</a> 2</span>
                    </div>
                </div>
            </div>
            <div class="news-content">
                <p>${article.content}</p>
            </div>
        </div>
        <!-- End body -->

        <!-- Comment -->
        <div class="container">
            <form class="comment">
                <h4>Để lại bình luận của bạn</h4>
                <textarea rows="3" style="width: 100%"></textarea>
                <button class="btn btn-default" name="action">Bình luận</button>
            </form>
            <div class="list">
                <h4>Các bình luận trước</h4>
                <div class="item">
                    <span>Peter Rain</span>
                    <button class="badge badge-warning ml-2" name="action">Xóa</button>
                    <p>
                        Bài viết khá hay, có điều nên focus nhiều vô concept, chứ chi tiết quá nó bị
                        loãng
                    </p>
                </div>
                <div class="item">
                    <span>Peter Rain</span>
                    <p>
                        Bài viết khá hay, có điều nên focus nhiều vô concept, chứ chi tiết quá nó bị
                        loãng
                    </p>
                </div>
                <div class="item">
                    <span>Peter Rain</span>
                    <p>
                        Bài viết khá hay, có điều nên focus nhiều vô concept, chứ chi tiết quá nó bị
                        loãng
                    </p>
                </div>
            </div>
        </div>
        <!-- End comment -->
    </body>
</html>
