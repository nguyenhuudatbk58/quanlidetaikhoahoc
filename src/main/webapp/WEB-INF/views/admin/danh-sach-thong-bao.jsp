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
    							Quản lý thông báo
    							<a href="/quan-li/tao-thong-bao"><button type="button" class="btn btn-lg btn-primary">Đăng thông báo mới</button></a>
    						</h1>

    					</div>
    				</div>

    				<div class="col-lg-12">

    					<div class="table-responsive">
    						<table class="table table-bordered table-hover table-striped">
    							<thead>
    								<tr>
    								    <th><p  >STT</p></th>
    									<th><p  >Tiêu đề</p></th>
    									<th><p  >Thời gian</p></th>
    									<th><p  >Tùy chọn</p></th>
    								</tr>
    							</thead>
    							<tbody   id="dsThongBao">
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
    <script src="/assets/js/admin/danh-sach-thong-bao.js"></script>

</body>
</html>