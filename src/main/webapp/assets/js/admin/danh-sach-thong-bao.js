$(document).ready(function(){
	
	
	var insertThongBao = function(response){
		 var dsThongBao = response.data;
		 $("#dsThongBao").empty();
		 var stt = (response.page -1 )* response.pageSize + 1;
		 dsThongBao.forEach(function(thongBao){
		   var row  = "<tr>\
			          <td>"+stt+"</td>\
			          <td>"+thongBao.tieuDe+"</td>\
					  <td>"+thongBao.thoiGianTao+"</td>\
					  <td>\
   					  <a href='/thong-bao/"+thongBao.idThongBao+"'><button type='button' class='btn btn-sm btn-info '>Xem</button></a>\
   					  <button type='button' class='btn btn-sm btn-danger xoaThongBao' data-id='"+thongBao.idThongBao+"'>Xóa</button>\
                     </td>\
					 </tr>";
		   $("#dsThongBao").append(row);
		   stt = stt + 1;
		 });
	 };
	 
	 
	 var  searchResponseHandler  = function(response){
		 $("#pagination").empty();
		 if(response.totalPages > 1){
			 var options = {
		 			 bootstrapMajorVersion : 3,
		 			 currentPage : response.page,
		 			 totalPages :  response.totalPage,
		 			 numberOfPages: 4,
		 			 onPageClicked : function(event, originEvent,type, page) {
		 				 requestData.page = page;
		 				searchThongBao(requestData,insertThongBao);
		 			 }
		 	 };
		    	 
		    $('#pagination').bootstrapPaginator(options);
		 }
		 insertThongBao(response);
	 };
	 
	 var searchThongBao = function(requestData,handler){
		 
		 $.ajax({
			method: "POST",
			url: "/quan-li/danh-sach-thong-bao",
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
	 };
	 searchThongBao(requestData,searchResponseHandler);
});