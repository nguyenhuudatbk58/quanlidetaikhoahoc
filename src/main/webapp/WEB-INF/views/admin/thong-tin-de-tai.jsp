<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    Chi tiết đề tài
                  </h1>

                </div>
				<div class="col-md-12" >
				   <div>
                     <div class="alert alert-success hide alert-dismissible" id="message">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					</div>
                  </div>
                  <div class="panel panel-info">
                    <div class="panel-heading">
                      <h3 class="panel-title" style=" font-size: 24px;text-align:center;">Thông tin đề tài</h3>
                    </div>
                    <div class="panel-body">
                      <table class="table table-striped">
                        <tbody>
                          <tr >
                            <td ><strong>Mã đề tài</strong></td>
                            <td>${deTai.maDeTai}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td  ><strong>Tên đề tài</strong></td>
                            <td>${deTai.ten}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td ><strong>Mã tác giả</strong></td>
                            <td>${deTai.tacGia.maTacGia}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td ><strong>Tên tác giả</strong></td>
                            <td>${deTai.tacGia.tenTacGia}</td>
                            <td></td>
                          </tr>
                          <c:forEach var="dongTacGia" items="${deTai.tacGia.dsDongTacGia}" >
									<tr>
										<td ><strong>Đồng tác giả</strong></td>
										<td>${dongTacGia}</td>
									</tr>
						  </c:forEach>
                          <tr >
                            <td ><strong>Loại đề tài</strong></td>
                            <td>${deTai.loaiDeTai.ten}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td ><strong>Hướng nghiên cứu</strong></td>
                            <td>${deTai.huongNghienCuu.ten}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td ><strong>Mô tả đề tài</strong></td>
                            <td>${deTai.moTa}</td>
                            <td></td>
                          </tr>
                          <tr>
                                <td ><strong>Thời gian</strong></td>
								<td><fmt:formatDate value="${deTai.thoiGianBatDau.time}" pattern="yyyy/MM/dd" />
								    - <fmt:formatDate value="${deTai.thoiGianKetThuc.time}" pattern="yyyy/MM/dd" /></td>
							 	<td></td>
						  </tr>
                          <tr>
                            <td ><strong>Trạng thái</strong></td>
                            <c:choose>
                                 <c:when test="${deTai.duyet}">
                                     <td>
                                          ${deTai.trangThai.ten}
                                     </td>
                                 </c:when>
                                 <c:otherwise>
                                       <td>
                                         Chưa Duyệt 
                                       </td>
                                 </c:otherwise>
                            </c:choose>
                          </tr>
						 <c:choose>
						      <c:when test="${deTai.trangThai.id == 3 }">
								 <tr>
								    <td><strong>Thời gian nghiệm thu</strong></td>
									<td><fmt:formatDate value="${deTai.thoiGianNghiemThu.time}"
													pattern="yyyy/MM/dd" /></td>
									<td></td>
								</tr>
								<tr>
									<td><strong>Đánh giá</strong></td>
									<td>${deTai.danhGia.ten}</td>
									<td></td>
								</tr>
							  </c:when>
						 </c:choose>
					     <c:choose>
						      <c:when test="${deTai.trangThai.id == 5 }">
								<tr>
								 	<td><strong>Lý do hủy</strong></td>
									<td>${deTai.lyDoHuy}</td>
									<td></td>
							    </tr>
							 </c:when>
						 </c:choose>
					  	</tbody>
                      </table>
                      <div class="col-md-offset-5">
                          <c:choose>
                              <c:when test="${not deTai.duyet}">
                                  <button class="btn btn-success duyetDeTai" data-id='${deTai.idDeTai}'>Duyệt</button>
                                  <button class="btn btn-danger xoaDeTai" data-id='${deTai.idDeTai}' >Xóa</button>
                              </c:when>
                              <c:otherwise>
                                  <button class="btn btn-warning suaDeTai " data-id='${deTai.idDeTai}'>Sửa</button>
                                  <button class="btn btn-danger xoaDeTai" data-id='${deTai.idDeTai}'>Xóa</button>
                              </c:otherwise>
                          </c:choose>
                      </div>
                    </div>
                  </div>
                </div>

              </div>

              <!-- /.row -->

            </div>
    			<!-- /.row -->

    		</div>
     </div>
      <script src="/assets/js/jquery.js"></script>
      <script src="/assets/js/bootstrap.min.js"></script>
      <script type="text/javascript">
              $(document).ready(function(){
            	  $(document).click(function(e){
            		  var $target = $(e.target);
            		  if($target.hasClass("duyetDeTai")){
            			  var id = $target.data("id");
            			  $.post("/quan-li/duyet-de-tai/"+id,{},function(){
            				  $("#message").append("Duyệt đề tài thành công!")
            				  $("#message").removeClass("hide");
            				  setTimeout(function(){
            					  window.location.reload();
            				  },2000);
            			  });
            		  }
            		  
            		  if($target.hasClass("xoaDeTai")){
            			  var id = $target.data("id");
            			  $.post("/quan-li/xoa-de-tai/"+id,{},function(){
            				  $("#message").append("Xóa đề tài thành công!")
            				  $("#message").removeClass("hide");
            				  setTimeout(function(){
            					  window.location = "/quan-li/danh-sach-de-tai/";
            				  },2000);
            			  });
            		  }
            		  if($target.hasClass("suaDeTai")){
            			  var id = $target.data("id");
            			  window.location = "/quan-li/sua-de-tai/"+id;
            		  }
            	  });
              });
      
      </script>
</body>