/**
 * 
 */

$(document).ready(function(){
	
	$("#themDongTacGia").click(function(){
		var form = '<div class="form-group">\
                       <label>Tên đồng tác giả</label>\
                       <input class="form-control dongTacGia" placeholder="Đồng tác giả" class="dongTacGia">\
                   </div>';
		$("#dsDongTacGia").append(form);
	});
	
	$("#formCreateUser").validate({
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
        	var dsDongTacGia = [];
        	var elements = $(".dongTacGia");
        	var i=0;
        	for(i=0; i < elements.length; i++){
        		var val = $(elements[i]).val();
        		if(val !== ""){
        			dsDongTacGia.push(val);
        		}
        	}
        	var data = {
    				tenTacGia: $("#tenTacGia").val(),
    				maTacGia: $("#maTacGia").val(),
    				ngheNghiep: $("#ngheNghiep").val(),
    				sdt: $("#soDT").val(),
    				email: $("#email").val(),
    				dsDongTacGia: dsDongTacGia
    		};
    		$.ajax({
    			
    			method: "POST",
    			url: "/quan-li/tao-tai-khoan",
    			data: JSON.stringify(data),
    			headers: { 
			           'Accept': 'application/json',
			           'Content-Type': 'application/json' 
			    },
    			success: function(response){
//    				$("#message").removeClass("hide");
    			}
    		});
        }
		
	});
	
	
});