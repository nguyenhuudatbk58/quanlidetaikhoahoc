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
		
	 $.getJSON("/danh-gia",function(response){
	        response.forEach(function(data){
	        	var option = "<option value='"+data.id+"'>"+data.ten+"</option>";
	        	$("#danhGia").append(option);
	        });
	 });
		
	 $.getJSON("/loai-de-tai",function(response){
	        response.forEach(function(data){
	        	var option = "<option value='"+data.id+"'>"+data.ten+"</option>";
	        	$("#loaiDeTai").append(option);
	        });
	 });
	 
	 
	 var insertDeTai = function(response){
		 var dsDeTai = response.datas;
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
					  <td><a href='/thong-tin-de-tai/" +deTai.idDeTai+ "'><button type='button' class='btn btn-sm btn-info'>Xem</button> </a></td>\
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
			 danhGia: null,
			 thoiGianNghiemThu: "",
			 tenTacGia: "",
			 nam: 0,
			 typeSearch: "NORMAL"
	 };
	 searchDeTai(requestData,searchResponseHandler);
	 
	 $("#searchBtn").click(function(e){
		requestData.tenDeTai = $("#tenDeTai").val().trim();
		requestData.typeSearch = "NORMAL";
		searchDeTai(requestData,searchResponseHandler); 
	 });
	 
	 $("#advancedSearchBtn").click(function(){
		 
		 requestData.nam = $("#nam").val();
		 requestData.tenTacGia = $("#tenTacGia").val().trim();
		 requestData.thoiGianNghiemThu = $("#thoiGianNghiemThu").val();
		 requestData.huongNghienCuu = {
			id: $("#huongNghienCuu").val(),
			ten: $("#huongNghienCuu option:selected").text()
		 };
		 requestData.loaiDeTai = {
		    id: $("#loaiDeTai").val(),
		    ten: $("#loaiDeTai option:selected").text()
		 };
		 requestData.danhGia = {
			id: $("#danhGia").val(),
			ten: $("#danhGia option:selected").text()
		 };
		 requestData.typeSearch = "ADVANCED";
		 searchDeTai(requestData,searchResponseHandler); 
	 });
 });