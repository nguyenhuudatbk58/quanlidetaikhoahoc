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
                <div class="col-md-12" align="center">
                  <div class="panel panel-info">
                    <div class="panel-heading">
                      <h3 class="panel-title" style=" font-size: 24px;">Thông tin đề tài</h3>
                    </div>
                    <div class="panel-body">
                      <table class="table table-striped">
                        <tbody>
                          <tr >
                            <td align="center"><strong>Mã đề tài</strong></td>
                            <td>${deTai.maDeTai}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td  align="center"><strong>Tên đề tài</strong></td>
                            <td>${deTai.ten}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td align="center"><strong>Mã tác giả</strong></td>
                            <td>${deTai.tacGia.maTacGia}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td align="center"><strong>Tên tác giả</strong></td>
                            <td>${deTai.tacGia.tenTacGia}</td>
                            <td></td>
                          </tr>
                          <c:forEach var="dongTacGia" items="${deTai.tacGia.dsDongTacGia}" >
									<tr>
										<td align="center"><strong>Đồng tác giả</strong></td>
										<td>${dongTacGia}</td>
									</tr>
						  </c:forEach>
                          <tr >
                            <td align="center"><strong>Loại đề tài</strong></td>
                            <td>${deTai.loaiDeTai.ten}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td align="center"><strong>Hướng nghiên cứu</strong></td>
                            <td>${deTai.huongNghienCuu.ten}</td>
                            <td></td>
                          </tr>
                          <tr>
                            <td align="center"><strong>Mô tả đề tài</strong></td>
                            <td>${deTai.moTa}</td>
                            <td></td>
                          </tr>
                          <tr>
                                <td align="center"><strong>Thời gian</strong></td>
								<td><fmt:formatDate value="${deTai.thoiGianBatDau.time}" pattern="yyyy/MM/dd" />
								    - <fmt:formatDate value="${deTai.thoiGianKetThuc.time}" pattern="yyyy/MM/dd" /></td>
							 	<td></td>
						  </tr>
                          <tr>
                            <td align="center"><strong>Trạng thái</strong></td>
                            <c:choose>
                                 <c:when test="${deTai.duyet}">
                                     <td>
                                     <div class="col-md-5">
                                         <select class="form-control" id="disabledInput"  disabled="disabled">
                                             <c:forEach var="trangThai" items="${dsTrangThai}">
                                                  <c:choose>
                                                      <c:when test="${trangThai.id == deTai.trangThai.id }">
                                                           <option value="${trangThai.id}" selected="selected">${trangThai.ten}</option>
                                                      </c:when>
                                                      <c:otherwise>
                                                           <option value="${trangThai.id}">${trangThai.ten}</option>
                                                      </c:otherwise>
                                                 </c:choose>
                                             </c:forEach>
                                         </select>
                                     </div>
                                    
                                     <div class="col-md-5"><button type="button" class="btn btn btn-primary">Cập nhật trạng thái</button></div>
                                     </td>
                                 </c:when>
                                 <c:otherwise>
                                       <td>
                                         Chưa Duyệt 
                                         <button type="button" class="btn btn-primary">Duyệt</button>
                                       </td>
                                 </c:otherwise>
                            </c:choose>
                          </tr>
                        </tbody>
                      </table>
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
</body>