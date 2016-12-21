<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false"%>

<html>
<head>
<title>Thông tin cá nhân</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="favicon.ico" rel="shortcut icon">
<link rel="stylesheet" href="/assets/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/font-awesome.css" 	rel="stylesheet">
<link rel="stylesheet" href="/assets/css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/responsive.css" 	rel="stylesheet">
<link rel="stylesheet" href="/assets/css/custom.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300"	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=PT+Sans"	type="text/css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,300" 	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,300" 	rel="stylesheet" type="text/css">
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
					<div class="col-md-10 col-md-offset-1" align="center">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title" style="font-size: 24px;">Thông tin
									tài khoản</h3>
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<tbody>
										<tr>
											<td align="center"><strong>Mã tác giả</strong></td>
											<td>${nguoiDung.maTacGia }</td>
											<td></td>
										</tr>
										<tr>
											<td align="center"><strong>Tên tác giả</strong></td>
											<td>${nguoiDung.tenTacGia}</td>
											<td></td>
										</tr>
										<tr>
											<td align="center"><strong>Nghề nghiệp</strong></td>
											<td>${nguoiDung.ngheNghiep}</td>
											<td></td>
										</tr>
										<c:forEach var="dongTacGia" items="${nguoiDung.dsDongTacGia}">
											<tr>
												<td align="center"><strong>Đồng tác giả</strong></td>
												<td>${dongTacGia}</td>
											</tr>
										</c:forEach>
										<tr>
											<td align="center"><strong>Số điện thoại</strong></td>
											<td>${nguoiDung.sdt}</td>
											<td></td>
										</tr>
										<tr>
											<td align="center"><strong>Email</strong></td>
											<td>${nguoiDung.email}</td>
											<td></td>
										</tr>
										<tr>
											<td align="center"><strong>Số đề tài</strong></td>
											<td>${nguoiDung.dsDeTai.size()}</td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>

					</div>
					<div class="clearfix"></div>
					<div class="col-md-offset-5" id="chinhSuaThongTin" >
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal">Chỉnh sửa</button>
						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Chỉnh sửa thông tin</h4>
									</div>
									<form id="formEditUser">
										<div class="modal-body">
											<div class="alert alert-success alert-dismissible hidden" id="messageChinhSuaThongTin">
												<a href="#" class="close" data-dismiss="alert"	aria-label="close">&times;</a> 
												Cập nhật thông tin thành công.
											</div>
											<div class="form-group">
												<label>Nghề nghiệp</label> <input type="text" value="${nguoiDung.ngheNghiep}"
													name="ngheNghiep"  id="ngheNghiep" class="form-control">
											</div>
											<div class="form-group">
												<label>Số điện thoại</label> <input type="text" name="soDT" id="sdt" value="${nguoiDung.sdt}" 
													class="form-control">
											</div>
											<div>
												<label>Email</label> <input type="text" name="email" id= "email"value="${nguoiDung.email}"
													class="form-control">
											</div>

										</div>
										<div class="modal-footer">
											<button type="submit" class="btn btn-primary">Cập
												nhật</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Hủy</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-10 col-md-offset-1">
						<h2>Danh sách đề tài:</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th style="width:35%;"><p >Tên đề tài</p></th>
										<th style="width:150px;"><p >Tên tác giả</p></th>
										<th><p >Loại đề tài</p></th>
										<th><p >Hướng nghiên cứu</p></th>
										<th><p >Thời gian</p></th>
										<th><p >Trạng thái</p></th>
										<th></th>

									</tr>
								</thead>
								<tbody >

									<c:forEach items="${nguoiDung.dsDeTai}" var="deTai">
										<tr>
											<td>${deTai.ten}</td>
											<td>${nguoiDung.tenTacGia}</td>
											<td>${deTai.loaiDeTai.ten}</td>
											<td>${deTai.huongNghienCuu.ten}</td>
											<td>
											      <fmt:formatDate value="${deTai.thoiGianBatDau.time}" pattern="yyyy/MM/dd" />
												- <fmt:formatDate value="${deTai.thoiGianKetThuc.time}" pattern="yyyy/MM/dd" />
											</td>
											<c:choose>
											     <c:when test="${deTai.duyet}">
											        <td>${deTai.trangThai.ten}</td>
											     </c:when>
											     <c:otherwise>
											        <td>Chưa duyệt</td>
											     </c:otherwise>
											</c:choose>
											<td><a href="/thong-tin-de-tai/${deTai.idDeTai}"
												class="btn btn-sm btn-info">Xem</a></td>

										</tr>
									</c:forEach>


								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="layouts/footer.jsp"></jsp:include>
		</div>
	</div>
		<!-- JS -->
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
		<script src="/assets/js/modernizr.custom.js" type="text/javascript"></script>
		<script src="/assets/js/user/chinh-sua-thong-tin-ca-nhan.js" type="text/javascript"></script>
</body>
</html>