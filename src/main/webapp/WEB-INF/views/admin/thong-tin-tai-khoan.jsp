<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Tìm kiếm</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="/assets/css/sb-admin.css" rel="stylesheet">
<link href="/assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">
		<jsp:include page="layouts/navigation.jsp"></jsp:include>
		<div id="page-wrapper">
			<div id="content">
				<div class="container background-white">
					<div class="row margin-vert-40">
						<div class="col-md-10 col-md-offset-1" >
							<div class="panel panel-info">
								<div class="panel-heading">
									<h3 class="panel-title" style="font-size: 24px;">Thông tin
										tài khoản</h3>
								</div>
								<div class="panel-body">
									<table class="table table-striped">
										<tbody>
											<tr>
												<td ><strong>Mã tác giả</strong></td>
												<td>${nguoiDung.maTacGia }</td>
												<td></td>
											</tr>
											<tr>
												<td ><strong>Tên tác giả</strong></td>
												<td>${nguoiDung.tenTacGia}</td>
												<td></td>
											</tr>
											<tr>
												<td ><strong>Nghề nghiệp</strong></td>
												<td>${nguoiDung.ngheNghiep}</td>
												<td></td>
											</tr>
											<c:forEach var="dongTacGia" items="${nguoiDung.dsDongTacGia}">
												<tr>
													<td ><strong>Đồng tác giả</strong></td>
													<td>${dongTacGia}</td>
												</tr>
											</c:forEach>
											<tr>
												<td ><strong>Số điện thoại</strong></td>
												<td>${nguoiDung.sdt}</td>
												<td></td>
											</tr>
											<tr>
												<td ><strong>Email</strong></td>
												<td>${nguoiDung.email}</td>
												<td></td>
											</tr>
											<tr>
												<td ><strong>Số đề tài</strong></td>
												<td>${nguoiDung.dsDeTai.size()}</td>
												<td></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>

						</div>
						<div class="clearfix"></div>
						<div class="col-md-10 col-md-offset-1">
							<h2>Danh sách đề tài:</h2>
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped">
									<thead>
										<tr>
											<th><p>Mã đề tài</p></th>
											<th style="width: 40%;"><p>Tên đề tài</p></th>
											<th><p>Tên tác giả</p></th>
											<th><p>Loại đề tài</p></th>
											<th><p>Hướng nghiên cứu</p></th>
											<th><p>Thời gian</p></th>
											<th><p>Trạng thái</p></th>
											<th></th>

										</tr>
									</thead>
									<tbody>

										<c:forEach items="${nguoiDung.dsDeTai}" var="deTai">
											<tr>
												<td>${deTai.maDeTai}</td>
												<td>${deTai.ten}</td>
												<td>${nguoiDung.tenTacGia}</td>
												<td>${deTai.loaiDeTai.ten}</td>
												<td>${deTai.huongNghienCuu.ten}</td>
												<td>2/12/2013-12/5/2013</td>
												<td>${deTai.trangThai.ten}</td>
												<td><a href="/quan-li/thong-tin-de-tai/${deTai.idDeTai}"
													class="btn btn-sm btn-info">Xem</a></td>

											</tr>
										</c:forEach>


									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/assets/js/jquery.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
	<script src="/assets/js/jquery.validate.js"></script>
</body>