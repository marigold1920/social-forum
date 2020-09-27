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
        <title>Social Forum</title>
    </head>
    <body class="landing-page">
        <c:set var="errorMessage" value="${requestScope.errorMessage}" />
        <c:set var="errorObj" value="${requestScope.errorObj}" />
        <c:set var="isSuccess" value="${requestScope.isSuccess}" />
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg bg-info">
            <div class="container">
                <div class="navbar-translate">
                    <a class="navbar-brand" href="index.html">Social Forum</a>
                </div>
            </div>
        </nav>
        <!-- End navigation -->
        <div class="container container-center">
            <div class="row authentication equal">
                <div class="col-6 px-5">
                    <form class="custom-form" action="ProcessServlet">
                        <h4>Đăng nhập bằng email và mật khẩu</h4>
                        <input
                            class="form-control"
                            name="email"
                            value="${requestScope.email}"
                            type="email"
                            placeholder="Email"
                            required
                        />
                        <input
                            class="form-control"
                            name="password"
                            value=""
                            type="password"
                            placeholder="Mật khẩu"
                            required
                        />
                        <c:if test="${not empty errorMessage}">
                            <label class="text-error">Email hoặc mật khẩu không đúng</label>
                        </c:if>
                            <button class="btn btn-info btn-round mt-3" name="action" value="login">Đăng nhập</button>
                    </form>
                </div>
                <div class="col-6 px-5">
                    <form class="custom-form" action="ProcessServlet">
                        <c:if test="${isSuccess == true}">
                            <label class="success-action">Tạo thành công. Đăng nhập để tiếp tục</label>
                        </c:if>
                        <h4>Đăng ký tài khoản mới</h4>
                        <input
                            class="form-control"
                            name="email"
                            value="${requestScope.registerEmail}"
                            type="email"
                            placeholder="Email"
                            required
                        />
                        <c:if test="${not empty errorObj.mailExisted}">
                            <label class="text-error">${errorObj.mailExisted}</label>
                        </c:if>
                        <input
                            class="form-control"
                            name="password"
                            value=""
                            type="password"
                            placeholder="Mật khẩu"
                            required
                        />
                        <input
                            class="form-control"
                            name="confirmPassword"
                            value=""
                            type="password"
                            placeholder="Xác nhận mật khẩu"
                            required
                        />
                        <c:if test="${not empty errorObj.passwordNotMatch}">
                            <label class="text-error">${errorObj.passwordNotMatch}</label>
                        </c:if>
                        <input
                            class="form-control"
                            name="name"
                            value="${requestScope.registerName}"
                            type="text"
                            placeholder="Tên"
                            required
                        />
                        <button class="btn btn-success btn-round mt-3" name="action" value="register">
                            Tạo tài khoản
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

