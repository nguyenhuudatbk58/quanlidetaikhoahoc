<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
<link rel="stylesheet" href="/assets/css/chosen.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<jsp:include page="layouts/navigation.jsp"></jsp:include>
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Danh sách đề tài</h1>

					</div>
				</div>

				<div class="col-md-12 ">
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

				<div class="col-lg-12">

					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th style="width:30%;"><p >Tên đề tài</p></th>
									<th><p >Tên tác giả</p></th>
									<th><p >Loại đề tài</p></th>
									<th ><p >Hướng nghiên cứu</p></th>
									<th style="width:50px;"><p >Thời gian</p></th>
									<th><p >Trạng thái</p></th>
									<th colspan="3"><p >Tùy chọn</p></th>

								</tr>
							</thead>
							<tbody  id="dsDeTai">
							</tbody>
						</table>
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
			<!-- /.row -->

		</div>
	</div>
	<script src="/assets/js/jquery.js"></script>
	<script type="text/javascript" src="/assets/js/chosen.jquery.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/assets/js/bootstrap-paginator.js"	charset="utf-8"></script>
	<script src="/assets/js/admin/danh-sach-de-tai.js" 	type="text/javascript"></script>
</body>