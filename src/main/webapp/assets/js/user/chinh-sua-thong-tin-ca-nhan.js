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
		messages:{
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
    				ngheNghiep: $("#ngheNghiep").val(),
    				sdt: $("#sdt").val(),
    				email: $("#email").val(),
    		};
    		$.post("/chinh-sua-thong-tin-ca-nhan",data,function(response){
    			$("#messageChinhSuaThongTin").removeClass("hidden");
				setTimeout(function(){
					location.reload();
				},2000);
    		});
        }
		
	});
	
	
	
});