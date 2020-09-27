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
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg bg-info">
            <div class="container">
                <div class="navbar-translate">
                    <a class="navbar-brand" href="#pablo">Social Forum</a>
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

        <!-- Body -->
        <div class="container p-0">
            <div class="header">
                <h3 class="pt-5">Mới nhất</h3>
            </div>
            <div class="row pl-3">
                <div class="col-6 mb-5">
                    <div class="row news-item">
                        <div class="col-4 px-0">
                            <img src="images/TrainingDaotao-218x150.png" />
                        </div>
                        <div class="col-8 pl-1 pr-3">
                            <a href="details.html"
                                ><h4 class="custom-text px-2">
                                    Đào tạo (Training) – Đâu là thời điểm bạn cần trải nghiệm?
                                </h4></a
                            >
                            <p class="custom-text px-2">
                                Để thành công, bạn cần quan tâm đến việc tự thúc đẩy, phát triển
                                những kỹ năng.
                            </p>
                            <p class="date-published pl-2">25/09/2020</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End body -->

        <!-- Pagination -->
        <div class="container">
            <ul class="pagination pagination-primary align-center">
                <li class="page-item active">
                    <a class="page-link" href="#">1</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#link">2</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#link">3</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#link">4</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#link">5</a>
                </li>
            </ul>
        </div>
        <!-- End pagination -->
    </body>
</html>
