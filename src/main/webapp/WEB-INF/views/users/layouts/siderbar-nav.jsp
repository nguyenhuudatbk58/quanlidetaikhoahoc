<%@ page language="java" trimDirectiveWhitespaces="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<ul class="list-group sidebar-nav" id="sidebar-nav">

	<li class="list-group-item">
	   <a href="/danh-sach-de-tai">Danh sách đề tài</a>
    </li>
	<li class="list-group-item">
	   <a href="/thong-bao">Thông báo</a>
	</li>
	<sec:authorize access="hasRole('USER')">
	    <li class="list-group-item">
             <a href="/dang-ki-de-tai">Đăng ký đề tài</a>
        </li>
                        
        <li class="list-group-item">
             <a href="/thong-tin-ca-nhan">Thông tin cá nhân</a>
        </li>
    </sec:authorize>
</ul>