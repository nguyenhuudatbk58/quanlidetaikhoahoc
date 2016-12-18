<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Thông tin đề tài</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<link href="favicon.ico" rel="shortcut icon">
<link rel="stylesheet" href="/assets/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/assets/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="/assets/css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="/assets/css/custom.css" rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=PT+Sans"
	type="text/css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,300"
	rel="stylesheet" type="text/css">

</head>
<body>
	<div id="body-bg">
		<!-- === BEGIN HEADER === -->
		<div id="header">
			<a href="#" title=""> <img src="/assets/img/slideshow/slide3.jpg"
				style="width: 100%; height: 160px;" />
			</a>
		</div>


		<div id="post_header" class="container" style="height: 40px">
			<!-- Spacing below header -->
		</div>

		<jsp:include page="layouts/menu.jsp"></jsp:include>

		<div id="content-top-border" class="container"></div>
		<div id="content">
			<div class="container background-white">
				<div class="row margin-vert-40">
					<!-- Begin Sidebar Menu -->
					<!-- End Sidebar Menu -->
					<div class="col-md-11 col-md-offset-1">
						<div id="page-wrapper">
							<div class="container-fluid">

								<div class="row">
									<div class="col-md-11" align="center">
										<div class="panel panel-info">
											<div class="panel-heading">
												<h3 class="panel-title" style="font-size: 24px;">Thông
													tin đề tài</h3>
											</div>
											<div class="panel-body">
												<table class="table table-striped">
													<tbody>
														<tr>
															<td ><strong>Mã đề tài</strong></td>
															<td>${deTai.maDeTai}</td>
															<td></td>
														</tr>
														<tr>
															<td ><strong>Tên đề tài</strong></td>
															<td>${deTai.ten}</td>
															<td></td>
														</tr>
														<tr>
															<td ><strong>Tên tác giả</strong></td>
															<td>${deTai.tacGia.tenTacGia}</td>
															<td></td>
														</tr>
														<c:forEach var="dongTacGia" items="${deTai.tacGia.dsDongTacGia}">
															<tr>
																<td ><strong>Đồng tác giả</strong></td>
																<td>${dongTacGia}</td>
															</tr>
														</c:forEach>
														<tr>
															<td ><strong>Loại đề tài</strong></td>
															<td>${deTai.loaiDeTai.ten}</td>
															<td></td>
														</tr>
														<tr>
															<td ><strong>Hướng nghiên cứu</strong></td>
															<td>${deTai.huongNghienCuu.ten}</td>
															<td></td>
														</tr>
														<tr>
															<td ><strong>Mô tả đề tài</strong></td>
															<td>${deTai.moTa}</td>
															<td></td>
														</tr>
														<tr>
															<td ><strong>Thời gian</strong></td>
															<td><fmt:formatDate value="${deTai.thoiGianBatDau.time}" pattern="yyyy/MM/dd" />
															 - <fmt:formatDate value="${deTai.thoiGianKetThuc.time}" pattern="yyyy/MM/dd" /></td>
															<td></td>
														</tr>
														<tr>
															<td ><strong>Trạng thái</strong></td>
															<td>${deTai.trangThai.ten}</td>
															<td></td>
														</tr>
														<c:choose>
															<c:when test="${deTai.trangThai.id == 3 }">
																<tr>
																	<td ><strong>Thời gian nghiệm thu</strong></td>
																	<td><fmt:formatDate value="${deTai.thoiGianNghiemThu}" pattern="yyyy/MM/dd" /></td>
																	<td></td>
																</tr>
																<tr>
																	<td ><strong>Đánh giá</strong></td>
																	<td>${deTai.danhGia.ten}</td>
																	<td></td>
																</tr>
															</c:when>
														</c:choose>
														<c:choose>
															<c:when test="${deTai.trangThai.id == 5 }">
																<tr>
																	<td ><strong>Lý do hủy</strong></td>
																	<td>${deTai.lyDoHuy}</td>
																	<td></td>
																</tr>
															</c:when>
														</c:choose>
													</tbody>
												</table>
											</div>
										</div>
									</div>

								</div>

							</div>
							<!-- /#page-wrapper -->

						</div>
					</div>
				</div>
			</div>
			<!-- === END CONTENT === -->
			<!-- === BEGIN FOOTER === -->
			<jsp:include page="layouts/footer.jsp"></jsp:include>
			<script
				src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
			<script type="text/javascript" src="/assets/js/jquery.min.js"
				type="text/javascript"></script>
			<script type="text/javascript" src="/assets/js/bootstrap.min.js"
				type="text/javascript"></script>
			<script type="text/javascript" src="/assets/js/scripts.js"></script>
			<script type="text/javascript" src="/assets/js/jquery.isotope.js"
				type="text/javascript"></script>
			<script type="text/javascript" src="/assets/js/jquery.slicknav.js"
				type="text/javascript"></script>
			<script type="text/javascript" src="/assets/js/jquery.visible.js"
				charset="utf-8"></script>
			<script type="text/javascript" src="/assets/js/jquery.sticky.js"
				charset="utf-8"></script>
			<script type="text/javascript" src="/assets/js/slimbox2.js"
				charset="utf-8"></script>
			<script type="text/javascript" src="/assets/js/jquery.validate.js"
				charset="utf-8"></script>
			<script src="/assets/js/modernizr.custom.js" type="text/javascript"></script>
			<script src="/assets/js/user/tao-de-tai.js" type="text/javascript"></script>
</body>
</html>