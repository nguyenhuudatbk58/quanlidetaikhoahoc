<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>

  <div id="displayNotification" style="position:fixed; bottom:10px; right: 20px; width: 300px; z-index: 1043">
         
  </div>
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/quan-li/quan-li-tai-khoan">Trang Admin</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span id="nThongBao" class="badge" style="color:red;margin-right:10px;font-size:17px;"></span><i class="fa fa-bell"></i> <b class="caret"></b></a>
                <ul class="dropdown-menu alert-dropdown" id="notification-container">
                   <li id="xemThem"><a href="" class="xemThem">Xem thêm</a></li>
                </ul>
              </li>
              <li>
                <a href="/logout"><i class="fa fa-fw fa-power-off"></i> Đăng xuất</a>
              </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
              <ul class="nav navbar-nav side-nav">
                <li>
                  <a href="#"><i class="fa fa-fw fa-dashboard"></i> Quản lý tin tức</a>
                </li>
                <li>
                  <a href="#"><i class="fa fa-fw fa-bar-chart-o"></i> Quản lý thông báo</a>
                </li>
                <li class="active">
                  <a href="/quan-li/quan-li-tai-khoan"><i class="fa fa-fw fa-table"></i> Quản lý tài khoản</a>
                </li>
                <li>
                  <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Quản lý đề tài <i class="fa fa-fw fa-caret-down"></i></a>
                  <ul id="demo" class="collapse">
                    <li>
                      <a href="/quan-li/danh-sach-de-tai">Danh sách đề tài</a>
                    </li>
                    <li>
                      <a href="/quan-li/duyet-de-tai">Duyệt đề tài đăng ký</a>
                    </li>
                  </ul>
                </li>

              </ul>
            </div>
            <!-- /.navbar-collapse -->
          </nav>
    <script src="/assets/js/jquery.min.js" type="text/javascript"></script>          
    <script src="/assets/js/sockjs-0.3.4.min.js" type="text/javascript"></script>
	<script src="/assets/js/stomp.js" type="text/javascript"></script>
	<script src="/assets/js/admin/thong-bao-duyet-de-tai.js" type="text/javascript"></script>      
