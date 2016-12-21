/**
 * 
 */

$(document).ready(function(){
	var trangThai = $("#trangThai").val();
	if(trangThai == 3){
		$("#thoiGianNghiemThu").parent().removeClass("hidden");
		$("#danhGia").parent().removeClass("hidden");
	}
	if(trangThai == 4){
		$("#lyDoHuy").parent().removeClass("hidden");
	}
	
	$("#trangThai").change(function(e){
		var val = $("#trangThai").val().trim();
		if(val == 3){
			$("#danhGia").parent().removeClass("hidden");
			$("#thoiGianNghiemThu").parent().removeClass("hidden");
		}else{
			$("#danhGia").parent().addClass("hidden");
			$("#thoiGianNghiemThu").parent().addClass("hidden");
		}
		
		if(val == 4){
			$("#lyDoHuy").parent().removeClass("hidden");
		}else{
			$("#lyDoHuy").parent().addClass("hidden");
		}
	});
	
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
	var validateThoiGianNghiemThu = function(){
		var thoiGianNghiemThu = $("#thoiGianNghiemThu").val();
		if(thoiGianNghiemThu === ""){
			var error = $("#thoiGianNghiemThu").prev();
			if(error.hasClass("error-message")){
				error.remove();
			}
			
			var errorEl = "<span class='error-message'>Nhập thời gian nghiệm thu.</span>";
			$("#thoiGianNghiemThu").before(errorEl);
			
			return false;
		}
		
		if($.validator.methods.after(thoiGianNghiemThu,{},"#thoiGianKetThuc") === false){
			var error = $("#thoiGianNghiemThu").prev();
			if(error.hasClass("error-message")){
				error.remove();
			}
			
			var errorEl = "<span class='error-message'>Thời gian nghiệm thu phải sau thời gian kết thúc.</span>";
			$("#thoiGianNghiemThu").before(errorEl);
			
			return false;
		}
		
		return true;
		
		
	};
	
	var validateDanhGia = function(){
		var danhGia = $("#danhGia").val();
		if(danhGia <= 0){
			var error = $("#danhGia").prev();
			if(error.hasClass("error-message")){
				error.remove();
			}
			
			var errorEl = "<span class='error-message'>Chọn loại đánh giá cho đề tài.</span>";
			$("#danhGia").before(errorEl);
			
			return false;
		}
		
		return true;
	};
	$("#thoiGianNghiemThu").change(function(e){
		if(validateThoiGianNghiemThu() === true){
			var error = $("#thoiGianNghiemThu").prev();
			if(error.hasClass("error-message")){
				error.remove();
			}
		}
	});
	$("#danhGia").change(function(e){
		if(validateDanhGia() === true){
			var error = $("#danhGia").prev();
			if(error.hasClass("error-message")){
				error.remove();
			}
		}
	});
	$("#backBtn").click(function(){
		window.history.back();
	});
	$("#formSuaDeTai").validate({
		    errorElement: "span",
		    errorClass: "error-message",
		    focusInvalid: false,
		    ignore: "",
		    rules: {
		    	tenDeTai:{
		    		required: true
		    	},
		        thoiGianBatDau: {
		        	required: true,
		        	before: "#thoiGianKetThuc",
		        },
		        thoiGianKetThuc:{
		        	required: true,
		        	after: "#thoiGianBatDau"
		        },
		    },
		    messages: {
		    	tenDeTai: {
		    		required: "Nhập tên đề tài"
		    	},
		    	thoiGianBatDau:{
		    		required: "Nhập thời gian bắt đầu.",
		    		before: "Thời gian bắt đầu phải trước thời gian hoàn thành."
		    	},
		    	thoiGianKetThuc:{
		    		required: "Nhập thời gian hoàn thành",
		    		after: "Thời gian hoàn thành phải sau thời gian bắt đầu."
		    	},
		    },errorPlacement: function(error,element){
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
	        	var trangThai = $("#trangThai").val().trim();
	        	var requestdata ={
	        		ten: $("#tenDeTai").val(),
	        		thoiGianBatDau: $("#thoiGianBatDau").val(),
	        		thoiGianKetThuc: $("#thoiGianKetThuc").val(),
	        		loaiDeTai: {
	        			id: $("#loaiDeTai").val(),
	        			ten: $("#loaiDeTai option:selected").text()
	        		},
	        		huongNghienCuu:{
	        			id: $("#huongNghienCuu").val(),
	        			ten: $("#huongNghienCuu option:selected").text()
	        		},
	        		trangThai:{
	        			id: $("#trangThai").val(),
	        			ten: $("#trangThai option:selected").text()
	        		},
	        		lyDoHuy: "",
	        		thoiGianNghiemThu: "",
	        		danhGia:{},
	        		moTa: $("#moTa").val(),
	        	};
	        	if(trangThai == 3){
	        		var valid = true;
	        		if(validateThoiGianNghiemThu() === false){
	        			valid = false;
	        		}
	        		if(validateDanhGia() === false){
	        			valid = false;
	        		}
	        		if(valid === false){
	        			return;
	        		}
	        		requestdata.danhGia = {
		        			id: $("#danhGia").val(),
		        			ten: $("#danhGia option:selected").text()
		        	};
	        		requestdata.thoiGianNghiemThu = $("#thoiGianNghiemThu").val();
	        	}
	        	if(trangThai == 4){
	        		requestdata.lyDoHuy =  $("#lyDoHuy").val();
	        	}
	        	var id= $("button[type=submit]").data("id");
	        	$.ajax({
	    			method: "POST",
	    			url: "/quan-li/sua-de-tai/"+id,
	    			data: JSON.stringify(requestdata),
	    			headers: { 
				           'Accept': 'application/json',
				           'Content-Type': 'application/json' 
				    },
	    			success: function(response){
	    				$("#message").removeClass("hidden");
	    				setTimeout(function(){
	    					window.location = "/quan-li/thong-tin-de-tai/"+id;
	    				},2000)
	    			}
	    		});
	        	
	        	
	        	
	        	
	        }
	});
	
	
	
});