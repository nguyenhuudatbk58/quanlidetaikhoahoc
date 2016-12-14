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
    					  <a href='/thong-tin-nguoi-dung'><button type='button' class='btn btn-sm btn-info '>Xem</button></a>\
    					  <button type='button' class='btn btn-sm btn-default resetMatKhau'>Reset Mật khẩu</button>\
    					  <button type='button' class='btn btn-sm btn-danger xoaNguoiDung' data-id='"+nguoiDung.id+"'>Xóa</button>\
                      </td>\
					 </tr>";
		   $("#dsNguoiDung").append(row);
		 });
	 };
	 
	 
	 var  searchResponseHandler  = function(response){
		 if(response.data.length > 0){
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
		    insertDeTai(response);
		 }
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
			 
		 }
		 if($target.hasClass("xoaNguoiDung")){
			 if(confirm("Bạn có chắc chắn muốn xóa tài khoản này?") === true){
				 
			 }
		 }
	 })
});