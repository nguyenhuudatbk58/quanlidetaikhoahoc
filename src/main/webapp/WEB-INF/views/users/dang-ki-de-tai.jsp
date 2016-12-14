<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Đăng kí đề tài</title>
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
		<!-- === END HEADER === -->
		<!-- === BEGIN CONTENT === -->
		<div id="content">
			<div class="container background-white">
				<div class="row margin-vert-40">
					<!-- End Sidebar Menu -->
					<div class="col-md-11 col-md-offset-1">
						<!-- Nội dung chi tiết -->
						<div class="headline">
							<h2>Đăng ký đề tài</h2>
						</div>
						<form id="formTaoDeTai">
							<div class="col-md-6">
								<div class="form-group">
									<label>Tên đề tài</label> <input class="form-control"
										placeholder="Tên đề tài" id="tenDeTai" name="tenDeTai">
								</div>


								<div class="form-group">
									<label>Thời gian bắt đầu</label> <input class="form-control" type="date" id="thoiGianBatDau"
							name="thoiGianBatDau"			placeholder="Bắt đầu">
								</div>
								<div class="form-group">
									<label>Thời gian hoàn thành</label> <input class="form-control" type="date" id="thoiGianHoanThanh"
							name="thoiGianHoanThanh"			placeholder="Hoàn thành">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Loại đề tài</label> 
									<select class="form-control" id="loaiDeTai" name="loaiDeTai">
									     <option>Cấp trường</option>
									</select>
								</div>
								<div class="form-group">
									<label>Hướng nghiên cứu</label>
									 <select class="form-control" name="huongNghienCuu" id="huongNghienCuu">
									</select>
								</div>
								<div class="form-group">
									<label>Mô tả đề tài</label>
									<textarea class="form-control" rows="3" id="moTa" name="moTa"></textarea>
								</div>

								<div class="col-md-3">
									<button type="button" class="btn btn-aqua" id="resetForm">Thiết lập	lại</button>
								</div>
								<div class="col-md-3">
									<button type="submit" class="btn btn-success" id="taoDeTai">Gửi đăng	ký</button>
								</div>
							</div>
						</form>

					</div>

				</div>
			</div>
		</div>
		<!-- === END CONTENT === -->
		<!-- === BEGIN FOOTER === -->
		<div id="content-bottom-border" class="container"></div>
		<div id="base">
			<div class="container padding-vert-30 margin-top-60">
				<div class="row">
					<!-- Contact Details -->
					<div class="col-md-4 margin-bottom-20">
						<h3 class="margin-bottom-10">Liên hệ với chúng tôi</h3>
						<p>
							<span class="fa-phone">Điện thoại:</span> (+84)948 713 xxx <br>
							<span class="fa-envelope">Email:</span> <a
								href="mailto:info@joomla51.com">vanthang0508@gmail.com</a> <br>
						</p>
						<p>
							Viện Công nghệ thông tin và Truyền thông, <br>Đại học Bách
							Khoa Hà Nội, <br> Số 1 Đại Cồ Việt, <br> Hai Bà Trưng,
							<br> Hà Nội.
						</p>
					</div>

					<!-- End Contact Details -->

					<div class="col-md-1"></div>
					<!-- Disclaimer -->
					<div class="col-md-3 margin-bottom-20 padding-vert-30 text-center">
						<h3 class="color-gray margin-bottom-10">Đăng ký nhận thông
							báo</h3>
						<p>
							Nhập email của bạn <br>để nhận những thông báo mới nhất
						</p>
						<input type="email"> <br>
						<button class="btn btn-primary btn-lg margin-top-20" type="button">Đăng
							ký</button>
					</div>
					<!-- End Disclaimer -->
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="container">
				<div class="row">
					<div id="copyright" class="col-md-4">
						<p class="pull-right">2016 Copyright@thanglv</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- JS -->
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
	<script type="text/javascript" src="/assets/js/jquery.validate.js" charset="utf-8"></script>
	<script src="/assets/js/modernizr.custom.js" type="text/javascript"></script>
	<script src="/assets/js/user/tao-de-tai.js" type="text/javascript"></script>
</body>
</html>