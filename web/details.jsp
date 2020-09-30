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
        
        <c:set var="article" value="${requestScope.article}" />
        <c:set var="isLiked" value="${requestScope.isLiked}" />
        <c:set var="isDisliked" value="${requestScope.isDisliked}" />
        <c:set var="comments" value="${requestScope.comments}" />
        <c:set var="isOwnComment" value="${requestScope.isOwnComment}" />
        <c:set var="likeArticleAction" value="ProcessServlet?action=makeEmotion&isLike=${!isLiked}&isDislike=${!isLiked ? false : isDisliked}&articleId=${article.articleId}" />
        <c:set var="dislikeArticleAction" value="ProcessServlet?action=makeEmotion&&isDislike=${!isDisliked}&isLike=${!isDisliked ? false : isLiked}&articleId=${article.articleId}" />
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
                                <a class="dropdown-item" href="#">Quản lí bài viết</a>
                                <a class="dropdown-item" href="ProcessServlet?action=logout">Đăng xuất</a>
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
                        <span class="badge badge-info py-2 px-4"><a href="${likeArticleAction}">${isLiked ? "Liked" : "Like"}</a> ${article.likeNumber}</span>
                        <span class="badge badge-default py-2 px-4"><a href="${dislikeArticleAction}">${isDisliked ? "Disliked" : "Dislike"}</a> ${article.dislikeNumber}</span>
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
            <form class="comment" action="ProcessServlet" method="post">
                <h4>Để lại bình luận của bạn</h4>
                <textarea name="comment" value="" rows="3" style="width: 100%" required ></textarea>
                <input type="hidden" name="articleId" value="${article.articleId}" />
                <button class="btn btn-default" name="action" value="postComment">Bình luận</button>
            </form>
            <div class="list">
                <h4>Các bình luận trước</h4>
                <c:if test="${comments.size() > 0}">
                    <c:forEach var="comment" items="${comments}">
                        <div class="item">
                            <div class="group-info" method="post">
                                <c:if test="${comment.email == user.email}">
                                    <form action="ProcessServlet">
                                        <input type="hidden" name="articleId" value="${article.articleId}" />
                                        <input type="hidden" name="commentId" value="${comment.commentId}" />
                                        <button class="badge badge-warning mr-2 text-white" name="action" value="deleteComment">Xóa</button>
                                    </form>
                                </c:if>
                                <span>${comment.name} <span class="text-right text-black-50">${comment.datePosted}</span></span>
                            </div>
                            <p style="display: block">${comment.comment}</p>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <!-- End comment -->
    </body>
</html>
