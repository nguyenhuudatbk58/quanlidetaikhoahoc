<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Thông báo</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="favicon.ico" rel="shortcut icon">
<link rel="stylesheet" href="/assets/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" rel="stylesheet">
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
            <div id="header">
                <a href="#" title="">
                    <img src="/assets/img/slideshow/slide3.jpg" style="width: 100%; height:160px;" />
                </a>
            </div>
            
            <div id="post_header" class="container" style="height: 40px">
            </div>

            <jsp:include page="layouts/menu.jsp"></jsp:include>
            <div id="content-top-border" class="container">
            </div>
            <!-- === END HEADER === -->
            <!-- === BEGIN CONTENT === -->
            <div id="content">
                <div class="container background-white">
                    <div class="row margin-vert-40">
                        <!-- Begin Sidebar Menu -->
                        <!-- End Sidebar Menu -->
                         <div class="col-md-10 col-md-offset-1">
                           <h2>Thông báo</h2>
                            <!-- Paragraph Examples -->
                          <div id="dsThongBao">
                          </div>

                        </div>

                        <div class="text-right">
                           <ul class="pagination" id="pagination">
                           </ul>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="layouts/footer.jsp"></jsp:include>
         </div>
            <!-- JS -->
            <script type="text/javascript" src="/assets/js/bootstrap.min.js" type="text/javascript"></script>
            <script type="text/javascript" src="/assets/js/scripts.js"></script>
            <script type="text/javascript" src="/assets/js/jquery.isotope.js" type="text/javascript"></script>
            <script type="text/javascript" src="/assets/js/jquery.slicknav.js" type="text/javascript"></script>
            <script type="text/javascript" src="/assets/js/jquery.visible.js" charset="utf-8"></script>
            <script type="text/javascript" src="/assets/js/jquery.sticky.js" charset="utf-8"></script>
            <script type="text/javascript" src="/assets/js/slimbox2.js" charset="utf-8"></script>
            <script src="/assets/js/modernizr.custom.js" type="text/javascript"></script>
            <script type="text/javascript" src="/assets/js/bootstrap-paginator.js" charset="utf-8"></script>
            <script src="/assets/js/user/danh-sach-thong-bao.js" type="text/javascript"></script>
    </body>
</html>