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
	
	$.validator.methods.future = function(value,element){
		if(value.trim() === ""){
			return false;
		}
		var timeArray = value.split("-");
		var year = timeArray[0];
		var month = timeArray[1];
		var date = timeArray[2];
		var currentTime = new Date();
		if(year < currentTime.getFullYear()){
			return false;
		}
		if(month < currentTime.getMonth()){
			return false;
		}
		if(date < currentTime.getDate()){
			return false;
		}
		
		return true;
	};
	$.validator.methods.after = function(value,element,param){
		if($(param).val().trim() === ""){
			return true;
		}
		var $this = new Date(value);
		var $that = new Date($(param).val());
		var this_year = $this.getFullYear();
		var this_month = $that.getFullYear();
		var this_month = $this.getMonth();
		var that_month = $that.getMonth();
		var this_date = $this.getDate();
		var that_date = $that.getDate();
		if(this_year < this_month){
			return false;
		}
		if(this_month < that_month){
			return false;
		}
		if(this_date <= that_date){
			return false;
		}
		
		
		return true;
	};
	$.validator.methods.before = function(value,element,param){
		if($(param).val().trim() === ""){
			return true;
		}
		var $this = new Date(value);
		var $that = new Date($(param).val());
		var this_year = $this.getFullYear();
		var that_year = $that.getFullYear();
		var this_month = $this.getMonth();
		var that_month = $that.getMonth();
		var this_date = $this.getDate();
		var that_date = $that.getDate();
		if(this_year > that_year){
			return false;
		}
		if(this_month > that_month){
			return false;
		}
		if(this_date >= that_date){
			return false;
		}
		
		return true;
	}
	
	$("#formTaoDeTai").validate({
	    errorElement: "span",
	    errorClass: "error-message",
	    focusInvalid: false,
	    ignore: "",
	    rules: {
	    	tenDeTai:{
	    		required: true
	    	},
	        thoiGianBatDau: {
	        	future: true,
	        	before: "#thoiGianHoanThanh"
	        },
	        thoiGianHoanThanh:{
	        	future: true,
	        	after: "#thoiGianBatDau"
	        },
	    },
	    messages: {
	    	tenDeTai: {
	    		required: "Nhập tên đề tài"
	    	},
	    	thoiGianBatDau:{
	    		future: "Thời gian bắt đầu không hợp lệ.",
	    		before: "Thời gian bắt đầu phải trước thời gian hoàn thành."
	    	},
	    	thoiGianHoanThanh:{
	    		future: "Thời gian kết thúc không hợp lệ.",
	    		after: "Thời gian hoàn thành phải sau thời gian bắt đầu."
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
        submitHandler: function(form,event){
        	
        	event.preventDefault();
    		var data = {
    				ten: $("#tenDeTai").val(),
    				thoiGianBatDau: $("#thoiGianBatDau").val(),
    				thoiGianKetThuc: $("#thoiGianHoanThanh").val(),
    				loaiDeTai: $("#loaiDeTai").val(),
    				huongNghienCuu: $("#huongNghienCuu").val(),
    				moTa: $("moTa").val(),
    		};
    		console.log(data);
    		$.ajax({
    			method: "POST",
    			url: "/tao-de-tai",
    			data: JSON.stringify(data),
    			headers: { 
			           'Accept': 'application/json',
			           'Content-Type': 'application/json' 
			    },
    			success: function(response){
    				$("#message").append("Đăng kí đề tài thành công.");
    				setTimeout(function(){
    					$("#message").addClass("hide");
    				},2000);
    			}
    		});
        }
		
		
	});
	
	
	
});