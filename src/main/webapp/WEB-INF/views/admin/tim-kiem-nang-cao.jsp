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
                    Tìm kiếm nâng cao
                  </h1>

                </div>

                <div class="col-lg-3">
                 <div class="form-group">
                  <label>Năm</label>
                  <label>
                    <select class="form-control">
                     <option>2012</option>
                     <option>2013</option>
                     <option>2014</option>
                     <option>2015</option>
                     <option>2016</option>
                   </select>
                 </label><br>
                 <label class="checkbox-inline">
                  <input type="checkbox">Tất cả các năm
                </label>
              </div>

              <div class="form-group">
                <label>Tên tác giả/Mã tác giả <input class="form-control" placeholder="Tên tác giả/Mã tác giả"></label>
              </div>
            </div>
            <div class="col-lg-3">
              <div class="form-group">
                <label>Hướng nghiên cứu <input class="form-control" placeholder="Hướng nghiên cứu"></label>
              </div>

              <div class="form-group">
                <label>Loại đề tài <input class="form-control" placeholder="Loại đề tài"></label><br>
              </div>
            </div>
            <div class="col-lg-3">
              <div class="form-group">
                <label>Ngày nghiệm thu <input class="form-control" placeholder="Ngày nghiệm thu"></label>
              </div>
              <div class="form-group">
                <label>Đánh giá <input class="form-control" placeholder="Đánh giá"></label><br>
                <label class="checkbox-inline">
                  <input type="checkbox">Tất cả đánh giá
                </label>
              </div>
            </div>
            <div class="col-lg-3">

              <br><br><button type="button" class="btn btn btn-success">Tìm kiếm</button>
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
                     <th><p align="center">Trạng thái</p></th>
                     <th colspan="3"><p align="center">Tùy chọn</p></th>

                   </tr>
                 </thead>
                 <tbody align="center">
                   <tr>
                     <td>1</td>
                     <td>KH04</td>
                     <td>Đề tài về xử lý tiếng nói abcugdw ggqgdq ygqsd ysv gqwd ywqgdss svqsuj</td>
                     <td>Lê Văn Thắng</td>
                     <td>Cấp trường</td>
                     <td>Nghiên cứu cơ bản</td>
                     <td>22/11/2016 - 12/12/2016</td>
                     <td>Đang thực hiện</td>

                     <td><a href="admin_detail_topic.html"><button type="button" class="btn btn-sm btn-info">Xem</button></a></td>

                     <td><button type="button" class="btn btn-sm btn-danger">Xóa</button></td>

                   </tr>
                   <tr>
                     <td>1</td>
                     <td>KH04</td>
                     <td>Đề tài về xử lý tiếng nói abcugdw ggqgdq ygqsd ysv gqwd ywqgdss svqsuj</td>
                     <td>Lê Văn Thắng</td>
                     <td>Cấp trường</td>
                     <td>Nghiên cứu cơ bản</td>
                     <td>22/11/2016 - 12/12/2016</td>
                     <td>Đang thực hiện</td>

                     <td><a href="admin_detail_topic.html"><button type="button" class="btn btn-sm btn-info">Xem</button></a></td>

                     <td><button type="button" class="btn btn-sm btn-danger">Xóa</button></td>

                   </tr>
                   <tr>
                     <td>1</td>
                     <td>KH04</td>
                     <td>Đề tài về xử lý tiếng nói abcugdw ggqgdq ygqsd ysv gqwd ywqgdss svqsuj</td>
                     <td>Lê Văn Thắng</td>
                     <td>Cấp trường</td>
                     <td>Nghiên cứu cơ bản</td>
                     <td>22/11/2016 - 12/12/2016</td>
                     <td>Đang thực hiện</td>

                     <td><a href="admin_detail_topic.html"><button type="button" class="btn btn-sm btn-info">Xem</button></a></td>
                     <td><button type="button" class="btn btn-sm btn-danger">Xóa</button></td>

                   </tr>
                   <tr>
                     <td>1</td>
                     <td>KH04</td>
                     <td>Đề tài về xử lý tiếng nói abcugdw ggqgdq ygqsd ysv gqwd ywqgdss svqsuj</td>
                     <td>Lê Văn Thắng</td>
                     <td>Cấp trường</td>
                     <td>Nghiên cứu cơ bản</td>
                     <td>22/11/2016 - 12/12/2016</td>
                     <td>Đang thực hiện</td>

                     <td><a href="admin_detail_topic.html"><button type="button" class="btn btn-sm btn-info">Xem</button></a></td>

                     <td><button type="button" class="btn btn-sm btn-danger">Xóa</button></td>

                   </tr>
                   <tr>
                     <td>1</td>
                     <td>KH04</td>
                     <td>Đề tài về xử lý tiếng nói abcugdw ggqgdq ygqsd ysv gqwd ywqgdss svqsuj</td>
                     <td>Lê Văn Thắng</td>
                     <td>Cấp trường</td>
                     <td>Nghiên cứu cơ bản</td>
                     <td>22/11/2016 - 12/12/2016</td>
                     <td>Đang thực hiện</td>

                     <td><a href="detail_topic.html"><button type="button" class="btn btn-sm btn-info">Xem</button></a></td>

                     <td><button type="button" class="btn btn-sm btn-danger">Xóa</button></td>

                   </tr>
                 </tbody>
               </table>
             </div>
           </div>
         </div>
         <!-- /.row -->

       </div>
       <!-- /.container-fluid -->

     </div>
     <!-- /#page-wrapper -->

   </div>
   <!-- /#wrapper -->

   <script src="/assets/js/jquery.js"></script>
   <script src="/assets/js/bootstrap.min.js"></script>


 </body>
</html>