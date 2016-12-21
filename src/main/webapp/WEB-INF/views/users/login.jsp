<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Đăng nhập</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<link href="favicon.ico" rel="shortcut icon">
<link rel="stylesheet" href="/assets/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/nexus.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300"  rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=PT+Sans"	type="text/css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,300" rel="stylesheet" type="text/css">
</head>
<body>

	<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
		tabindex="-1" id="loginModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-body">

				<form class="login-page" action="/dang-nhap" method="POST">
					<div class="login-header margin-bottom-30">
						<h2>Đăng nhập vào hệ thống</h2>
					</div>
					<c:choose>
					     <c:when test="${error}">
							<div class="alert alert-warning alert-dismissible " id="message">
								<a href="#" class="close" data-dismiss="alert"
									aria-label="close">&times;</a> Tên tài khoản hoặc mật khẩu
								không chính xác.
							</div>
						</c:when>
					</c:choose>
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"> <i class="fa fa-user"></i>
						</span> <input placeholder="Tài khoản" class="form-control" type="text"
							name="username">
					</div>
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"> <i class="fa fa-lock"></i>
						</span> <input placeholder="Mật khẩu" class="form-control"
							type="password" name="password">
					</div>
					<div class="row">
						<div class="col-md-6">
							<label class="checkbox"> <input type="checkbox">Lưu
								đăng nhập
							</label>
						</div>
						<div class="col-md-6">
							<button class="btn btn-primary pull-right" type="submit">Đăng
								nhập</button>
						</div>
					</div>
					<hr>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/assets/js/jquery.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="/assets/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$("#loginModal").modal();
		});
	</script>
</body>
</html>