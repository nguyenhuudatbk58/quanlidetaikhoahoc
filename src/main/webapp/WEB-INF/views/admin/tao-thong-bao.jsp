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
		<jsp:include page="layouts/navigation.jsp"></jsp:include>
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Đăng thông báo
						   <a href="/quan-li/quan-li-thong-bao" style="font-size:15px;">Danh sách thông báo</a>
						</h1>
					</div>
				</div>
				<div class="col-md-10 col-md-offset-1">
                     <form id="taoThongBao">
						<div class="alert  alert-dismissible hidden" id="message">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						</div>
						<div class="form-group">
                            <label >Tiêu đề:</label>
                            <textarea rows="4" class="form-control" id="tieuDe" placeholder="Nhập tiêu đề của thông báo."></textarea>
                        </div>
                        <div class="form-group">
                            <label>Nội dung:</label>
                            <textarea id="richContentEditor"></textarea>
                        </div>
                        
                        <div class="form-group col-md-2 col-md-offset-4">
                            <input type="submit" value="Đăng" class="form-control btn btn-success"> 
                        </div>
                        <div class="form-group col-md-2 " style="padding-left:0px;">
                            <a type="button"  class="form-control btn btn-default" id="backBtn">Quay lại</a> 
                        </div>
                     </form>
                     
				</div>
			</div>
		</div>
	</div>
	<script src="/assets/js/jquery.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
	<script src="/assets/js/tinymce/tinymce.min.js" type="text/javascript"></script>
	 <script src="/assets/js/admin/tao-thong-bao.js" type="text/javascript" ></script>
</body>