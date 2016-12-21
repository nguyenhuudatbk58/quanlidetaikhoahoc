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
  <link href="/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>

    	<div id="wrapper">

    		<!-- Navigation -->
             <jsp:include page="layouts/navigation.jsp"></jsp:include>
    		<div id="page-wrapper">

    			<div class="container-fluid">

    				<!-- Page Heading -->
    				<div class="row">
    					<div class="col-lg-12">
    						<h1 class="page-header">
    							Quản lý tài khoản
    							<a href="/quan-li/tao-tai-khoan"><button type="button" class="btn btn-lg btn-primary">Cấp tài khoản mới</button></a>
    						</h1>

    					</div>
    				</div>

    				<div class="col-lg-5 col-md-5">
    					<div class="form-group input-group">
    						<input type="text" class="form-control" id="dieuKienTimKiem">
    						<span class="input-group-btn"><button class="btn btn-default form-control" type="button" id="searchBtn"><i class="fa fa-search"></i>Tìm kiếm</button></span>

    					</div>
    				</div>
    				<div class="col-lg-12">

    					<div class="table-responsive">
    						<table class="table table-bordered table-hover table-striped">
    							<thead>
    								<tr>
    									<th><p align="center">Mã tài khoản</p></th>
    									<th><p align="center">Tên tài khoản</p></th>
    									<th><p align="center">SĐT</p></th>
    									<th><p align="center">Email</p></th>
    									<th><p align="center">Tùy chọn</p></th>
    								</tr>
    							</thead>
    							<tbody align="center" id="dsNguoiDung">
    								<tr>
    									<td>1</td>
    									<td>2013001</td>
    									<td>Lê Văn Thắng</td>
    									<td>
    										<a href="admin_read_info_acc.html"><button type="button" class="btn btn-sm btn-info">Xem</button></a>
    										<button type="button" class="btn btn-sm btn-default">Reset Mật khẩu</button>
    										<button type="button" class="btn btn-sm btn-danger">Xóa</button>
    									</td>
    								</tr>
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
    		<!-- /.container-fluid -->

    	<!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/assets/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/assets/js/bootstrap-paginator.js" charset="utf-8"></script>
    <script src="/assets/js/admin/danh-sach-tai-khoan.js"></script>

</body>
</html>