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
    						<h1 class="page-header">
    							Duyệt đăng ký đề tài
    						</h1>

    					</div>
    				</div>

    				<div class="col-lg-4">
    					<div class="form-group input-group">
    						<input type="text" class="form-control">
    						<span class="input-group-btn"><button class="btn btn-default form-control" type="button"><i class="fa fa-search"></i></button></span>

    					</div>
    				</div>
    				<div class="col-lg-12">

    					<div class="table-responsive">
    						<table class="table table-bordered table-hover table-striped">
                  <thead>
                    <tr>
                     <th><p align="center">STT</p></th>
                     <th><p align="center">Mã đề tài</p></th>
                     <th><p align="center">Tên đề tài</p></th>
                     <th><p align="center">Tên tác giả</p></th>
                     <th><p align="center">Loại đề tài</p></th>
                     <th><p align="center">Hướng nghiên cứu</p></th>
                     <th><p align="center">Thời gian</p></th>
                     <th colspan="3"><p align="center">Tùy chọn</p></th>

                   </tr>
                 </thead>
                 <tbody align="center" id="dsDeTai">
                 <tr>
                   <td>1</td>
                   <td>KH04</td>
                   <td>Đề tài về xử lý tiếng nói abcugdw ggqgdq ygqsd ysv gqwd ywqgdss svqsuj</td>
                   <td>Lê Văn Thắng</td>
                   <td>Cấp trường</td>
                   <td>Nghiên cứu cơ bản</td>
                   <td>22/11/2016 - 12/12/2016</td>

                   <td><a href="admin_detail_topic.html"><button type="button" class="btn btn-sm btn-info">Xem</button></a></td>

                   <td><button type="button" class="btn btn-sm btn-success">Duyệt</button></td>

                 </tr>
               </tbody>
             </table>
    					</div>
    				</div>
    			</div>
    			<!-- /.row -->

    		</div>
     </div>
   <script src="/assets/js/jquery.js"></script>
   <script src="/assets/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="/assets/js/sockjs-0.3.4.min.js"></script>
   <script src="/assets/js/stomp.js"></script>
    <script type="text/javascript" src="/assets/js/bootstrap-paginator.js" charset="utf-8"></script>
      <script src="/assets/js/admin/duyet-de-tai.js" type="text/javascript"></script>
</body>