$(document).ready(function(){
	
	
	var insertThongBao = function(response){
		 var dsThongBao = response.data;
		 $("#dsThongBao").empty();
		 var stt = (response.page -1 )* response.pageSize + 1;
		 dsThongBao.forEach(function(thongBao){
		   var row  = ' <div class="row" >\
			                <blockquote class="primary">\
                              <a href="/thong-bao/'+thongBao.idThongBao+'">\
                                  <span style="font-size:20px;">'+thongBao.tieuDe+'</span>\
                              </a>\
                              <p style="padding-left:10px;font-size:13px;">Đăng ngày: '+thongBao.thoiGianTao+'</p>\
                            </blockquote>\
                         </div>\
                        <div class="clearfix margin-bottom-10"></div>';
		   $("#dsThongBao").append(row);
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
			url: "/danh-sach-thong-bao",
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