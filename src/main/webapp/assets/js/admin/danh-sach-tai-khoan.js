/**
 * 
 */

$(document).ready(function(){
	 
	 var insertDeTai = function(response){
		 var dsNguoiDung = response.data;
		 $("#dsNguoiDung").empty();
		 dsNguoiDung.forEach(function(nguoiDung){
		   var row  = "<tr>\
			          <td>"+nguoiDung.maTacGia+"</td>\
					  <td>"+nguoiDung.tenTacGia+"</td>\
					  <td>"+nguoiDung.sdt+"</td>\
					  <td>"+nguoiDung.email+"</td>\
					  <td>\
    					  <a href='/quan-li/thong-tin-tai-khoan/"+nguoiDung.idNguoiDung+"'><button type='button' class='btn btn-sm btn-info '>Xem</button></a>\
    					  <button type='button' class='btn btn-sm btn-default resetMatKhau' data-id='"+nguoiDung.idNguoiDung+"'>Reset Mật khẩu</button>\
    					  <button type='button' class='btn btn-sm btn-danger xoaNguoiDung' data-id='"+nguoiDung.idNguoiDung+"'>Xóa</button>\
                      </td>\
					 </tr>";
		   $("#dsNguoiDung").append(row);
		 });
	 };
	 
	 
	 var  searchResponseHandler  = function(response){
		 if(response.totalPages > 1){
			 var options = {
		 			 bootstrapMajorVersion : 3,
		 			 currentPage : response.page,
		 			 totalPages :  response.totalPage,
		 			 numberOfPages: 4,
		 			 onPageClicked : function(event, originEvent,type, page) {
		 				 requestData.page = page;
		 				searchNguoiDung(requestData,insertDeTai);
		 			 }
		 	 };
		    	 
		    $('#pagination').bootstrapPaginator(options);
		 }
		 insertDeTai(response);
	 };
	 
	 var searchNguoiDung = function(requestData,handler){
		 
		 $.ajax({
			method: "POST",
			url: "/quan-li/tim-kiem-nguoi-dung",
			data: requestData,
			dataType:"json",
			success: function(response){
				handler(response);
			}
		});
		 
	 };
	 var requestData = {
			 page: 1,
			 pageSize: 5,
			 dieuKienTimKiem: "",
	 };
	 searchNguoiDung(requestData,searchResponseHandler);
	 
	 $("#searchBtn").click(function(e){
		requestData.dieuKienTimKiem = $("#dieuKienTimKiem").val().trim();
		searchNguoiDung(requestData,searchResponseHandler); 
	 });
	 
	 $(document).click(function(e){
		 var $target = $(e.target);
		 if($target.hasClass("resetMatKhau")){
			 var id = $target.data("id");
			 $.post("/quan-li/reset-mat-khau/"+id,{},function(){
				 alert("Reset mật khẩu thành công.");
			 });
		 }
		 if($target.hasClass("xoaNguoiDung")){
			 if(confirm("Bạn có chắc chắn muốn xóa tài khoản này?") === true){
				 var id = $target.data("id");
				 $.post("/quan-li/xoa-tai-khoan/"+id,{},function(){
					 alert("Xóa tài khoản thành công.");
					 $tr = $target.parent().parent();
					 $tr.remove();
				 });
			 }
		 }
	 })
});