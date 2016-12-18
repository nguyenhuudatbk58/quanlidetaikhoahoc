/**
 * 
 */

$(document).ready(function(){
	
	 var insertDeTai = function(response){
		 var dsDeTai = response.data;
		 $("#dsDeTai").empty();
		 dsDeTai.forEach(function(deTai){
		   var row  = "<tr>\
					  <td style='width:40%;'>"+deTai.ten+"</td>\
					  <td>"+deTai.tacGia.tenTacGia+"</td>\
					  <td>"+deTai.loaiDeTai.ten+"</td>\
					  <td>"+deTai.huongNghienCuu.ten+"</td>\
					  <td>"+deTai.thoiGianBatDau+ " - " + deTai.thoiGianKetThuc+ "</td>\
					  <td><a href='/quan-li/thong-tin-de-tai/"+deTai.idDeTai+"'><button type='button' class='btn btn-sm btn-info'>Xem</button></a></td>\
                      <td><button type='button' class='btn btn-sm btn-success duyetDeTai' data-id='"+deTai.idDeTai+"'>Duyệt</button></td>\
                      <td><button type='button' class='btn btn-sm btn-danger xoaDeTai' data-id='"+deTai.idDeTai+"'>Xóa</button></td>\
                      </tr>";
		   $("#dsDeTai").append(row);
		 });
	 };
	 
	 
	 var  searchResponseHandler  = function(response){
		 var options = {
	 			 bootstrapMajorVersion : 3,
	 			 currentPage : response.page,
	 			 totalPages :  response.totalPages,
	 			 numberOfPages: 4,
	 			 onPageClicked : function(event, originEvent,type, page) {
	 				 requestData.page = page;
	 				 searchDeTai(requestData,insertDeTai);
	 			 }
	 	 };
	    	 
	    $('#pagination').bootstrapPaginator(options);
	    insertDeTai(response);
	 };
	 
	 var searchDeTai = function(requestData,handler){
		 
		 $.ajax({
			method: "POST",
			url: "/de-tai-chua-duyet",
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
			 tenDeTai: "",
	 };
	 searchDeTai(requestData,searchResponseHandler);
	 
	 $("#searchBtn").click(function(e){
		requestData.tenDeTai = $("#tenDeTai").val().trim();
		searchDeTai(requestData,searchResponseHandler); 
	 });
	 
	 
	 $(document).click(function(e){
		 var $target = $(e.target);
		 if($target.hasClass("duyetDeTai")){
			 var id = $target.data("id");
			 $.post("/quan-li/duyet-de-tai/"+id,{},function(){
				 var $td = $target.parent();
				 $target.remove();
				 $td.append("<p style='color:#5cb85c;width:100px;'>Đã duyệt</p>");
			 });
		 }
		 
		 if($target.hasClass("xoaDeTai")){
			 var id = $target.data("id");
			 var $tr = $target.parent().parent();
			 if(confirm("Bạn có thực sự muốn xóa đề tài này không?") === true){
				 $.post("/quan-li/xoa-de-tai/"+id,{},function(){
					 $tr.remove();
				 });
			 }else{
			 }
		 }
	 });
	 
	
});
