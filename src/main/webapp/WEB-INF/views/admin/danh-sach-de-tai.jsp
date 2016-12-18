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

				<div class="col-lg-12">
					<div class="col-lg-6">
						<div class="col-lg-1" align="left"
							style="float: center; font-size: 16px">
							<p>
								<strong>Năm </strong>
							</p>
						</div>
						<div class="col-lg-4">
							<select class="form-control">
								<option>2012</option>
								<option>2013</option>
								<option>2014</option>
								<option>2015</option>
								<option>2016</option>
							</select>
						</div>
					</div>
					<div class="col-lg-6" style="float: right">
						<div class="col-lg-8">
							<div class="form-group input-group">
								<input type="text" class="form-control" id="tenDeTai"> <span
									class="input-group-btn"><button
										class="btn btn-default form-control" id="searchBtn" type="button">
										<i class="fa fa-search"></i>
									</button></span>
							</div>
						</div>
						<a href="/quan-li/tim-kiem-nang-cao"><button type="button"
								class="btn btn btn-primary">Tìm kiếm nâng cao</button></a>
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
	<script src="/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/assets/js/bootstrap-paginator.js"
		charset="utf-8"></script>
	<script src="/assets/js/admin/danh-sach-de-tai.js"
		type="text/javascript"></script>
</body>