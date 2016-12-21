<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Danh sách đề tài</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="favicon.ico" rel="shortcut icon">
<link rel="stylesheet" href="/assets/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="/assets/css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="/assets/css/custom.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/chosen.css" rel="stylesheet">

<!-- Google Fonts-->
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
					<!-- Begin Sidebar Menu -->
					<!-- End Sidebar Menu -->
					<div class="col-md-11 col-md-offset-1"">
						<div>
							<div class="col-md-6" style="padding-left:0px;">
								<div class="form-group input-group">
									<input type="text" class="form-control" id="tenDeTai" placeholder="Nhập tên đề tài">
									 <span 	class="input-group-btn">
										<button class="btn btn-default form-control" type="button" id="searchBtn">
											<i class="fa fa-search"></i>
											<span>Tìm kiếm</span>
										</button>
									</span>
								</div>
							</div>
							<button type="button" class="btn btn btn-primary" data-toggle="collapse" data-target="#advancedSearch">Tìm kiếm nâng cao</button>
							<div class="clearfix"></div>
						</div>
						<div id="advancedSearch" class="collapse" style="margin-bottom:20px;">
							<div class="col-lg-2 col-md-2" style="padding-left:0px;">
								<div class="form-group">
									<label>Năm</label> 
									<select class="form-control advancedSearchCriteria" id="nam">
										<option value="0">Tất cả</option>
										<c:forEach var="nam" items="${dsNam}">
										     <option value="${nam}">${nam}</option>
										</c:forEach>
									</select>
								</div>
							</div>

                        	<div class="col-lg-2 col-md-2">
								<div class="form-group">
									<label>Tên tác giả </label> 
									<select data-placeholder="Chọn tên tác giả..." class="chosen-select form-control advancedSearchCriteria" tabindex="2" id="tenTacGia" >
									    <option value="0">Tất cả</option>
										<c:forEach var="nguoiDung" items="${dsNguoiDung}">
										     <option value="${nguoiDung.idNguoiDung}">${nguoiDung.tenTacGia}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="col-md-2 col-lg-2">
								<div class="form-group">
									<label>Hướng nghiên cứu </label> <select class="form-control advancedSearchCriteria"
										id="huongNghienCuu">
										<option value="0">Tất cả</option>

									</select>
								</div>
							</div>
                           	<div class="col-lg-2 col-md-2">
								<div class="form-group">
									<label>Loại đề tài </label> <select class="form-control advancedSearchCriteria"
										id="loaiDeTai">
										<option value="0">Tất cả</option>
									</select>
								</div>
							</div>
							<div class="col-md-2 col-lg-2">
								<div class="form-group">
									<label>Trạng thái</label> 
									<select class="form-control advancedSearchCriteria" id="trangThai" >
									    <option value="0">Tất cả</option>
										<c:forEach var="trangThai" items="${dsTrangThai}">
										     <option value="${trangThai.id}">${trangThai.ten}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>

					</div>

					<div class="col-md-10 col-md-offset-1">
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th style="width:30%;"><p align="center">Tên đề tài</p></th>
										<th><p>Tên tác giả</p></th>
										<th><p>Loại đề tài</p></th>
										<th><p>Hướng nghiên cứu</p></th>
										<th style="width: 200px;"><p>Thời gian</p></th>
										<th><p>Trạng thái</p></th>
										<th><p>Năm</p></th>
										<th></th>

									</tr>
								</thead>
								<tbody  id="dsDeTai" >
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-10">
						<div class="text-right">
							<ul id="pagination">
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="layouts/footer.jsp"></jsp:include>
	<script type="text/javascript" src="/assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="/assets/js/scripts.js"></script>
	<script type="text/javascript" src="/assets/js/jquery.isotope.js" type="text/javascript"></script>
	<script type="text/javascript" src="/assets/js/jquery.slicknav.js" type="text/javascript"></script>
	<script type="text/javascript" src="/assets/js/jquery.visible.js" charset="utf-8"></script>
	<script type="text/javascript" src="/assets/js/jquery.sticky.js" charset="utf-8"></script>
	<script type="text/javascript" src="/assets/js/slimbox2.js" charset="utf-8"></script>
	<script type="text/javascript" src="/assets/js/bootstrap-paginator.js" charset="utf-8"></script>
	<script type="text/javascript" src="/assets/js/chosen.jquery.js"></script>
	<script type="text/javascript" src="/assets/js/prism.js"></script>
	<script src="/assets/js/modernizr.custom.js" type="text/javascript"></script>
	<script src="/assets/js/user/tim-kiem-de-tai.js" type="text/javascript"></script>
</body>
</html>