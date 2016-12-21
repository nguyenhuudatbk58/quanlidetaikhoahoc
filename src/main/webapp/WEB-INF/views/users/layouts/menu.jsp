<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<div id="menu">
	<div class="container menu">
		<div class="item-home">
			<a href="/trang-chu">Trang chủ </a>
		</div>
		<div class="menu-item">
			<a href="/danh-sach-de-tai">Danh sách đề tài</a>
		</div>
		<div class="menu-item">
			<a href="/thong-bao">Thông báo</a>
		</div>
		<sec:authorize access="hasRole('USER')">
			<div class="menu-item">
				<a href="/dang-ki-de-tai">Đăng ký đề tài</a>
			</div>
			<div class="menu-item">
				<a href="/thong-tin-ca-nhan">Thông tin cá nhân</a>
			</div>
		</sec:authorize>
		<div class="item-login" style="color: #000000">
			<sec:authorize access="isAnonymous()">
				<p>
					<a href="/dang-nhap" >Đăng nhập</a>
				</p>
			</sec:authorize>
			<sec:authorize access="hasRole('USER')">
				<div class="dropdown">
					<a class=" dropdown-toggle" type="button" data-toggle="dropdown" style="cursor:pointer;">
						<sec:authentication property="principal.tenTacGia" /> <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="" data-toggle="modal" data-target="#myModal">Đổi mật khẩu</a></li>
						<li><a href="/dang-xuat">Đăng xuất</a></li>
					</ul>
				</div>
			</sec:authorize>
		</div>
	</div>
</div>
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Thay đổi mật khẩu</h4>
			</div>
			<form id="formChangePassword">
				<div class="modal-body">
					<div class="alert  alert-dismissible hidden"
						id="message">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					</div>
					<div class="form-group">
						<label>Mật khẩu hiện tại</label> <input type="password" value=""
							name="currentPassword" id="currentPassword" class="form-control">
					</div>
					<div class="form-group">
						<label>Mật khẩu mới</label> <input type="password" value=""
							name="newPassword" id="newPassword" class="form-control">
					</div>
					<div class="form-group">
						<label>Nhập lại mật khẩu</label> <input type="password"
							name="soDT" id="confirmPassword" name="confirmPassword" value=""
							class="form-control">
					</div>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Thay đổi</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="/assets/js/jquery.min.js"
			type="text/javascript"></script>
<script type="text/javascript" src="/assets/js/jquery.validate.js"
			type="text/javascript"></script>
<script type="text/javascript" src="/assets/js/user/thay-doi-mat-khau.js"
			type="text/javascript"></script>