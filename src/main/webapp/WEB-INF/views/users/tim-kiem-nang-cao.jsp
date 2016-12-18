<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Tìm kiếm nâng cao</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="favicon.ico" rel="shortcut icon">
<link rel="stylesheet" href="/assets/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/responsive.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/custom.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=PT+Sans" type="text/css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,300" rel="stylesheet" type="text/css">

</head>
<body>
<div id="body-bg">

<!-- === BEGIN HEADER === -->
<div id="header">
        <a href="#" title="">
            <img src="/assets/img/slideshow/slide3.jpg" style="width:100%; height:160px;"  />
        </a>   
</div>

<div id="post_header" class="container" style="height: 40px">
    <!-- Spacing below header -->
</div>

<jsp:include page="layouts/menu.jsp"></jsp:include>
<div id="content-top-border" class="container"></div>
<div id="content">
    <div class="container background-white">
        <div class="row margin-vert-40">
            <!-- Begin Sidebar Menu -->
            <!-- End Sidebar Menu -->                  
                <div class="col-md-11 col-md-offset-1">
                
              <div class="col-lg-2 col-md-2">
                 <div class="form-group">
                    <label>Năm</label>
                    <select class="form-control" id="nam">
                         <option value="0">Tất cả</option>
                         <option value="2012">2012</option>
                         <option value="2013">2013</option>
                         <option value="2014">2014</option>
                         <option value="2015">2015</option>
                         <option value="2016">2016</option>
                     </select>
                 </div>

              <div class="form-group">
                <label>Tên tác giả </label>
                <input class="form-control" placeholder="Tên tác giả" id="tenTacGia">
              </div>
            </div>
            
            <div class="col-md-2 col-lg-2">
              <div class="form-group">
                <label>Hướng nghiên cứu </label>
                <select class="form-control" id="huongNghienCuu">
                  <option value="0">Tất cả</option>
                  
                </select>
              </div>

              <div class="form-group">
                <label>Loại đề tài </label>
                <select class="form-control" id="loaiDeTai">
                  <option value="0">Tất cả</option>
                </select>
              </div>
            </div>
            <div class="col-md-2 col-lg-2">
              <div class="form-group">
                <label>Ngày nghiệm thu</label>
                <input class="form-control" type="date" id="thoiGianNghiemThu" >
              </div>
              <div class="form-group">
                <label>Đánh giá </label>
                <select class="form-control" id="danhGia">
                    <option value="0">Tất cả</option>
                </select>
              </div>
            </div>
            <div class="col-lg-3">

              <br><br><button type="button" class="btn btn btn-success" id="advancedSearchBtn">Tìm kiếm</button>
            </div>


              <div class="col-md-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                               <th><p align="center">Mã đề tài</p></th>
                               <th><p align="center">Tên đề tài</p></th>
                               <th><p align="center">Tên tác giả</p></th>
                               <th><p align="center">Loại đề tài</p></th>
                               <th><p align="center">Hướng nghiên cứu</p></th>
                               <th><p align="center">Thời gian</p></th>
                               <th><p align="center">Trạng thái</p></th>
                               <th></th>

                        </tr>
                    </thead>
                    <tbody align="center" id="dsDeTai">
                        <tr>
                           <td>KH04</td>
                           <td>Đề tài về xử lý tiếng nói abcugdw ggqgdq ygqsd ysv gqwd ywqgdss svqsuj</td>
                           <td>Lê Văn Thắng</td>
                           <td>Cấp trường</td>
                           <td>Nghiên cứu cơ bản</td>
                           <td>22/11/2016 - 12/12/2016</td>
                           <td>Đang thực hiện</td>
                           <td> <a href="detail_topic.html"><button type="button" class="btn btn-sm btn-info">Xem</button> </a></td>
                        </tr>
                        
                    </tbody>
                </table>
                </div>
                </div>
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
  </div>
  <jsp:include page="layouts/footer.jsp"></jsp:include>
</div>
<script type="text/javascript" src="/assets/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/assets/js/scripts.js"></script>
<script type="text/javascript" src="/assets/js/jquery.isotope.js" type="text/javascript"></script>
<script type="text/javascript" src="/assets/js/jquery.slicknav.js" type="text/javascript"></script>
<script type="text/javascript" src="/assets/js/jquery.visible.js" charset="utf-8"></script>
<script type="text/javascript" src="/assets/js/jquery.sticky.js" charset="utf-8"></script>
<script type="text/javascript" src="/assets/js/slimbox2.js" charset="utf-8"></script>
<script type="text/javascript" src="/assets/js/bootstrap-paginator.js" charset="utf-8"></script>
<script src="/assets/js/modernizr.custom.js" type="text/javascript"></script>
<script src="/assets/js/user/tim-kiem-de-tai.js" type="text/javascript"></script>
</body>
</html>