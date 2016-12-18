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
                <c:set var="thoiGianBatDau">
                     <fmt:formatDate value="${deTai.thoiGianBatDau.time}" pattern="yyyy-MM-dd" />
                </c:set>
                <c:set var="thoiGianKetThuc">
                     <fmt:formatDate value="${deTai.thoiGianKetThuc.time}" pattern="yyyy-MM-dd" />
                </c:set>
                 <c:set var="thoiGianNghiemThu">
                     <fmt:formatDate value="${deTai.thoiGianNghiemThu.time}" pattern="yyyy-MM-dd" />
                </c:set>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header" align="center">Chỉnh sửa thông tin đề tài</h1>
                        </div>
					<div class="col-md-offset-2 col-md-8">
						<div>
							<div class="alert alert-success  alert-dismissible hidden" id="message">
								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								Cập nhật thông tin đề tài thành công .
							</div>
						</div>
						<form id="formSuaDeTai">
                           <div class="form-group">
                               <label>Tên đề tài</label>
                               <textarea rows="3" class="form-control" id="tenDeTai" name="tenDeTai" >${deTai.ten}</textarea>
                           </div>
                           <div class="col-md-6" style="padding-left:0px;">
                                  <div class="form-group">
                                     <label>Thời gian bắt đầu</label>
                                     <input type="date" value="${thoiGianBatDau}"  class="form-control" name="thoiGianBatDau" id="thoiGianBatDau">
                                 </div>
                           </div>
                           <div class="col-md-6" style="padding-right:0px;">
                                 <div class="form-group">
                                     <label>Thời gian kết thúc</label>
                                     <input type="date" value="${thoiGianKetThuc}"  class="form-control" name="thoiGianKetThuc" id="thoiGianKetThuc">
                                </div>
                           </div>
                            <div class="col-md-6" style="padding-left:0px;">
                               <div class="form-group">
                                <label>Loại đề tài</label>
                                <select  class="form-control" id="loaiDeTai" >
                                   <c:forEach var="loaiDeTai" items="${dsLoaiDeTai}">
                                       <c:choose>
                                           <c:when test="${loaiDeTai.id == deTai.loaiDeTai.id }">
                                                 <option value="${loaiDeTai.id}" selected="selected">${loaiDeTai.ten}</option>
                                           </c:when>
                                           <c:otherwise>
                                                  <option value="${loaiDeTai.id}" >${loaiDeTai.ten}</option>
                                           </c:otherwise>
                                       </c:choose>
                                   </c:forEach>
                                </select>
                              </div>
                            </div>
                             <div class="col-md-6" style="padding-right:0px;"> 
                               <div class="form-group">
                                <label>Hướng nghiên cứu</label>
                                <select  class="form-control" id="huongNghienCuu">
                                     <c:forEach var="huongNghienCuu" items="${dsHuongNghienCuu}">
                                       <c:choose>
                                           <c:when test="${huongNghienCuu.id == deTai.huongNghienCuu.id }">
                                                 <option value="${huongNghienCuu.id}" selected="selected">${huongNghienCuu.ten}</option>
                                           </c:when>
                                           <c:otherwise>
                                                  <option value="${huongNghienCuu.id}" >${huongNghienCuu.ten}</option>
                                           </c:otherwise>
                                       </c:choose>
                                   </c:forEach>
                                 </select>
                              </div>
                             </div>
                           <div class="form-group">
                                <label>Trạng thái</label>
                                <select  class="form-control" id="trangThai">
                                    <c:forEach var="trangThai" items="${dsTrangThai}">
                                       <c:choose>
                                           <c:when test="${trangThai.id == deTai.trangThai.id }">
                                                 <option value="${trangThai.id}" selected="selected">${trangThai.ten}</option>
                                           </c:when>
                                           <c:otherwise>
                                                   <option value="${trangThai.id}" >${trangThai.ten}</option>
                                           </c:otherwise>
                                       </c:choose>
                                   </c:forEach>
                                </select>
                           </div>
                            <div class="form-group hidden ">
                                <label>Lý do hủy</label>
                                <textarea rows="2"  class="form-control" placeholder="Lý do hủy" id="lyDoHuy" >${deTai.lyDoHuy}</textarea>
                           </div>
                           <div class="col-md-6 " style="padding-left:0px;">
                                  <div class="form-group hidden">
                                     <label>Thời gian nghiệm thu</label>
                                     <input type="date" value="${thoiGianNghiemThu}"  class="form-control"  id="thoiGianNghiemThu">
                                 </div>
                           </div>
                           <div class="col-md-6 " style="padding-right:0px;">
                                 <div class="form-group hidden">
                                     <label>Đánh giá</label>
                                      <select class="form-control"  id="danhGia">
                                        <option value="0"> --- Chọn kết quả ---</option>
										<c:forEach var="danhGia" items="${dsDanhGia}">
											<c:choose>
												<c:when test="${danhGia.id == deTai.danhGia.id }">
													<option value="${danhGia.id}" selected="selected">${danhGia.ten}</option>
												</c:when>
												<c:otherwise>
													<option value="${danhGia.id}">${danhGia.ten}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
                           </div>
                           <div class="form-group">
                                <label>Mô tả</label>
                                <textarea rows="3"  class="form-control" id="moTa" >${deTai.moTa}</textarea>
                           </div>
                           <div class="col-md-offset-4 " >
                                 <button type="submit" class="btn btn-success" data-id="${deTai.idDeTai}">Chỉnh sửa</button>
                                 <button type="button" class="btn btn-default ">Quay lại</button>
                           </div>
                           
                        </form>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

            </div>
    </div>
    <script src="/assets/js/jquery.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
     <script src="/assets/js/jquery.validate.js"></script>
     <script type="text/javascript" src="/assets/js/admin/chinh-sua-de-tai.js"></script>
</body>