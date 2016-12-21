/**
 * 
 */
$(document).ready(function(){
	
	
	$.validator.methods.simplePassword = function(value,element){
		// chap nhan ki tu va chu so
		return /^[a-zA-Z0-9]*$/.test( value );
	}
	$("#formChangePassword").validate({
		errorElement: "span",
		errorClass: "error-message",
		focusInvalid: false,
		ignore: "",
		rules: {
			currentPassword:{
				required: true
			},
			newPassword: {
				required: true,
				simplePassword: true,
				minlength: 5,
				maxlength: 20
 			},
 			confirmPassowrd:{
 				required: true,
 				equalTo: "#newPassword"
 			},
		},
		messages:{
			currentPassword:{
				required: "Nhập mật khẩu hiện tại."
			},
			newPassword:{
				required: "Nhập mật khẩu mới.",
				simplePassword: "Mật khẩu chỉ được chứa kí và chữ số.",
				minlength: "Mật khẩu ít nhất 5 kí tự",
				maxlength: "Mật khẩu tối đa 20 kí tự."
			},
			confirmPassowrd:{
				required: "Xác nhận lại mật khẩu",
				equalTo: "Mật khẩu xác nhận lại không trùng."
			},
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
    				currentPassword: $("#currentPassword").val(),
    				newPassword: $("#newPassword").val(),
    		};
    		$.ajax({
    			
    			method: "POST",
    			url: "/thay-doi-mat-khau",
    			data: data,
    			success: function(response){
    				console.log("sucess");
    				var message = $("<p>Thay đổi mật khẩu thành công</p>");
    				$("#message").append(message);
    				$("#message").addClass("alert-success");
    				$("#message").removeClass("hidden");
    				setTimeout(function(){
    					$("#myModal").modal("hide");
    					message.remove();
    				},2000);
    			},
    			error: function(xhr, status, errorThrown){
    				console.log("error");
    				var message = $("<p> Mật khẩu hiện tại không chính xác.</p>");
    				$("#message").append(message);
    				$("#message").addClass("alert-warning");
    				$("#message").removeClass("hidden");
    				setTimeout(function(){
    					$("#message").addClass("hidden");
    					message.remove();
    				},3000);
    			}
    		});
        }
		
	});
	
	
});