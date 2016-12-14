/**
 * 
 */

$(document).ready(function(){
	
	 var insertDeTai = function(response){
		 var dsDeTai = response.data;
		 $("#dsDeTai").empty();
		 dsDeTai.forEach(function(deTai){
		   var row  = "<tr>\
			          <td>"+deTai.maDeTai+"</td>\
					  <td>"+deTai.ten+"</td>\
					  <td>"+deTai.tacGia.tenTacGia+"</td>\
					  <td>"+deTai.loaiDeTai.ten+"</td>\
					  <td>"+deTai.huongNghienCuu.ten+"</td>\
					  <td>"+deTai.thoiGianBatDau+ " - " + deTai.thoiGianKetThuc+ "</td>\
					  <td>"+deTai.trangThai.ten + "</td>\
					  <td><a href='/quan-li/thong-tin-de-tai/"+deTai.idDeTai+"'><button type='button' class='btn btn-sm btn-info'>Xem</button></a></td>\
                      <td><button type='button' class='btn btn-sm btn-success'>Duyệt</button></td>\
                      </tr>";
		   $("#dsDeTai").append(row);
		 });
	 };
	 
	 
	 var  searchResponseHandler  = function(response){
		 var options = {
	 			 bootstrapMajorVersion : 3,
	 			 currentPage : response.page,
	 			 totalPages :  response.totalPage,
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
			data: JSON.stringify(requestData),
			headers: { 
		           'Accept': 'application/json',
		           'Content-Type': 'application/json' 
		    },
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
	 
	
});
