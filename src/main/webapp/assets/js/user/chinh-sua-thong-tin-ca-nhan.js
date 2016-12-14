/**
 * 
 */

$(document).ready(function(){
	
	$("#formEditUser").validate({
		errorElement: "span",
		errorClass: "error-message",
		focusInvalid: false,
		ignore: "",
		rules: {
			tenTacGia:{
				required: true
			},
			ngheNghiep: {
				required: true
 			},
 			soDT:{
 				required: true,
 				digits: true
 			},
 			email:{
 				required: true,
 				email: true
 			}
		},
		message:{
			tenTacGia:{
				required: "Nhập tên tác giả."
			},
			ngheNghiep:{
				required: "Nhập nghề nghiêp."
			},
			soDT:{
				required: "Nhập số điện thoại",
				digits: "Số điện thoại không hợp lệ."
			},
			email:{
				required: "Nhập email.",
				email: "Email nhập vào không hợp lệ"
			}
		},
		errorPlacement: function(error,element){
	    	$(element).before(error);
	    },
	    highlight: function (element) {
            $(element).addClass("has-error");
        },
        unhighlight: function (element) {
            $(element).removeClass("has-error");
        },
        submitHandler: function(form,e){
        	e.preventDefault();
        	
        	var data = {
    				tenTacGia: $("#tenTacGia").val(),
    				ngheNghiep: $("#ngheNghiep").val(),
    				sdt: $("#soDT").val(),
    				email: $("#email").val(),
    		};
    		$.ajax({
    			
    			method: "POST",
    			url: "/chinh-sua-thong-tin",
    			data: JSON.stringify(data),
    			headers: { 
			           'Accept': 'application/json',
			           'Content-Type': 'application/json' 
			    },
    			success: function(response){
    				$("#message").removeClass("hide");
    				setTimeout(function(){
    					location.reload();
    				},1000);
    			}
    		});
        }
		
	});
	
	
	
});