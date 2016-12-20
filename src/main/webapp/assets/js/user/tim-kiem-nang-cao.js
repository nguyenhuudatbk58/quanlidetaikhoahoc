/**
 * 
 */
$(document).ready(function(){
	
	$.getJSON("/huong-nghien-cuu",function(response){
        response.forEach(function(data){
        	var option = "<option value='"+data.ten+"'>"+data.ten+"</option>";
        	$("#huongNghienCuu").append(option);
        });
	});
	
	
	$.getJSON("/loai-de-tai",function(response){
        response.forEach(function(data){
        	var option = "<option value='"+data.ten+"'>"+data.ten+"</option>";
        	$("#loaiDeTai").append(option);
        });
	});
	
	var search = function(){
		$.ajax({
			method: "POST",
			url: "/search",
			data: "",
			headers: {
				"Accept" : "application/json",
				"Content-Type": "application/json"
			},
			success: function(e){
				
			}
		});
	};
	
});