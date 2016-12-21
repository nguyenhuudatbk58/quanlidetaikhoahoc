/**
 * 
 */

$(document).ready(function(){
	
	$.getJSON("/huong-nghien-cuu",function(response){
        response.forEach(function(data){
        	var option = "<option value='"+data.id+"'>"+data.ten+"</option>";
        	$("#huongNghienCuu").append(option);
        });
	});
	
	
	$.getJSON("/loai-de-tai",function(response){
        response.forEach(function(data){
        	var option = "<option value='"+data.id+"'>"+data.ten+"</option>";
        	$("#loaiDeTai").append(option);
        });
	});
	 $(".chosen-select").chosen();
	 $("#tenTacGia").change(function(e){
	      var val = $("#tenTacGia").val();	
	      console.log(val);
	 });
	 
	 var insertDeTai = function(response){
		 var dsDeTai = response.data;
		 $("#dsDeTai").empty();
		 dsDeTai.forEach(function(deTai){
		   var row  = "<tr>\
					  <td>"+deTai.ten+"</td>\
					  <td>"+deTai.tacGia.tenTacGia+"</td>\
					  <td>"+deTai.loaiDeTai.ten+"</td>\
					  <td>"+deTai.huongNghienCuu.ten+"</td>\
					  <td>"+deTai.thoiGianBatDau+ " - " + deTai.thoiGianKetThuc+ "</td>\
					  <td>"+deTai.trangThai.ten + "</td>\
					  <td>"+deTai.nam + "</td>\
					  <td><a href='/quan-li/thong-tin-de-tai/"+deTai.idDeTai+"'><button type='button' class='btn btn-sm btn-info'>Xem</button></a></td>\
					  <td><a href='/quan-li/sua-de-tai/"+deTai.idDeTai+"'><button type='button' class='btn btn-sm btn-warning'>Sửa</button></a></td>\
                      <td><button type='button' class='btn btn-sm btn-danger'>Xóa</button></td>\
                      </tr>";
		   $("#dsDeTai").append(row);
		 });
	 };
	 
	 
	 var  searchResponseHandler  = function(response){
	   $("#pagination").empty();
	   if(response.totalPages > 1){
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
	   }	 
	    insertDeTai(response);
	 };
	 
	 var searchDeTai = function(requestData,handler){
		 
		 $.ajax({
			method: "POST",
			url: "/search",
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
			 huongNghienCuu: null,
			 loaiDeTai: null,
			 trangThai: null,
			 idNguoiDung: "",
			 nam: 0,
			 typeSearch: "NORMAL"
	 };
	 searchDeTai(requestData,searchResponseHandler);
	 
	 $("#searchBtn").click(function(e){
		requestData.page = 1;
		requestData.tenDeTai = $("#tenDeTai").val().trim();
		requestData.typeSearch = "NORMAL";
		searchDeTai(requestData,searchResponseHandler); 
	 });
	 
	 $("#tenDeTai").keypress(function(e) {
		    if(e.which == 13) {
		    	requestData.page = 1;
		    	requestData.tenDeTai = $("#tenDeTai").val().trim();
				requestData.typeSearch = "NORMAL";
				searchDeTai(requestData,searchResponseHandler); 
		    }
     });
	 
	 
	 var getSearchCriteria = function(){
		 
		 requestData.nam = $("#nam").val();
		 requestData.idNguoiDung = $("#tenTacGia").val().trim();
		 
		 if($("#huongNghienCuu").val() > 0){
			 requestData.huongNghienCuu = {
			     id: $("#huongNghienCuu").val(),
				 ten: $("#huongNghienCuu option:selected").text()
			 };
		 }else{
			 requestData.huongNghienCuu = null;
		 }
		 
		 if( $("#loaiDeTai").val() > 0){
			 requestData.loaiDeTai = {
				 id: $("#loaiDeTai").val(),
				 ten: $("#loaiDeTai option:selected").text()
			 };
		 }else{
			 requestData.loaiDeTai = null;
		 }
		 
		 if( $("#trangThai").val() > 0 ){
			 requestData.trangThai = {
			     id: $("#trangThai").val(),
				 ten: $("#trangThai option:selected").text()
             }; 
		 }else{
			 requestData.trangThai = null;
		 }
	 };
	 
	 $(".advancedSearchCriteria").change(function(){
		 getSearchCriteria();
		 requestData.page = 1;
		 requestData.typeSearch = "ADVANCED";
		 searchDeTai(requestData,searchResponseHandler); 
		 console.log(requestData);
	 });
	
});
