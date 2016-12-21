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
		if(this_year > this_month){
			return true;
		}
		if(this_month > that_month){
			return true;
		}
		if(this_date >= that_date){
			return true;
		}
		
		
		return false;
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
		if(this_year < that_year){
			return true;
		}
		if(this_month < that_month){
			return true;
		}
		if(this_date <= that_date){
			return true;
		}
		
		return false;
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
	        	before: "#thoiGianHoanThanh"
	        },
	        thoiGianHoanThanh:{
	        	after: "#thoiGianBatDau"
	        },
	    },
	    messages: {
	    	tenDeTai: {
	    		required: "Nhập tên đề tài"
	    	},
	    	thoiGianBatDau:{
	    		before: "Thời gian bắt đầu phải trước thời gian hoàn thành."
	    	},
	    	thoiGianHoanThanh:{
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
    				loaiDeTai: {
    					id: $("#loaiDeTai").val(),
    					ten: $("#loaiDeTai option:selected").text()
    				},
    				huongNghienCuu:{
    					id: $("#huongNghienCuu").val(),
    					ten: $("#huongNghienCuu option:selected").text()
    				},
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
    				$("#messageDangKiDT").append("Đăng kí đề tài thành công.");
    				$("#messageDangKiDT").removeClass("hidden");
    				setTimeout(function(){
    					$("#messageDangKiDT").addClass("hidden");
    				},5000);
    			},
    			error: function(xhr, status, errorThrown){
    				console.log(errorThrown);
    				console.log("errrrrrrror");
    			}
    		});
        }
		
		
	});
	
	
	
});