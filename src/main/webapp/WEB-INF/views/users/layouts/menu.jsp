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
				<p>
					<a href="/dang-xuat">Đăng xuất</a>
				</p>
			</sec:authorize>
		</div>
	</div>
</div>