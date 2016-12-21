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
                     <form id="formCreateUser">
                        <div class="col-lg-12">
                            <h1 class="page-header">Thêm tài khoản
                                <button type="submit" class="btn btn-lg btn-primary" >Lưu tài khoản mới</button>
                            </h1>
                            
                            <div class="alert alert-success alert-dismissible hidden" id="messageTaoTaiKhoan">
							    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							    Tạo tài khoản thành công
						    </div>

                        </div>
                        
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Tên tác giả</label>
                                <input class="form-control" placeholder="Tên tác giả" name="tenTacGia" id="tenTacGia">
                            </div>

                            <fieldset disabled>

                                <div class="form-group">
                                    <label for="disabledSelect">Mã tác giả</label>
                                    <input class="form-control" id="maTacGia" type="text" placeholder="Mã tác giả" value="${maTacGia}" disabled>
                                </div>
                            </fieldset>
                            <div class="form-group">
                                <label>Nghề nghiệp</label>
                                <input class="form-control" placeholder="Nghề nghiệp" id="ngheNghiep" name="ngheNghiep">
                            </div>
                            <div class="form-group">
                                <label>Số điện thoại</label>
                                <input class="form-control" placeholder="Số điện thoại" id="soDT" name="soDT">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" placeholder="Email" id="email" name="email">
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Đồng tác giả</h3>
                                </div>
                                <div class="panel-body" id="dsDongTacGia">
                                    <div class="form-group">
                                        <label>Tên đồng tác giả</label>
                                        <input class="form-control dongTacGia" placeholder="Đồng tác giả" >
                                    </div>
                                </div>
                            </div>
                            <div class="text-right">
                                <button type="button" class="btn btn btn-success" id="themDongTacGia">Thêm đồng tác giả</button>
                            </div>
                        </div>
                        
                        </form>
                    </div>
                </div>
                <!-- /.row -->

            </div>
    </div>
    <script src="/assets/js/jquery.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
     <script src="/assets/js/jquery.validate.js"></script>
     <script type="text/javascript" src="/assets/js/admin/tao-tai-khoan.js"></script>
</body>