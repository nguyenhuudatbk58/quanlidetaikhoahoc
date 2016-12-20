/**
 * 
 */

$(document).ready(function(){
	
	var stompClient = null;
	function disconnect() {
		if (stompClient != null) {
			stompClient.disconnect();
		}
		console.log("Disconnected stomp client..");
	}
	var yeuCau = {
			idDeTai: 1,
			tenNguoiDung: "Nguyễn Hữu Đạt",
			tenDeTai: "Kiểm soát cây trồng dựa trên nền tảng của Internet of Things",
			thoiGianTao: "22-12-2014"
	};
	

	function connect() {
		var socket = new SockJS('/notification');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			console.log("connect successfully!");
			
			stompClient.subscribe("/post/thong-bao", function(response) {
				
				console.log(response);
				
				var yeuCau = JSON.parse(response.body);
				var el = '<div class="notification">\
			        <a href="/quan-li/thong-tin-de-tai/'+yeuCau.idDeTai+'">\
			         <strong class="tenNguoiDung"> '+yeuCau.tenNguoiDung+' </strong>đăng kí đề tài:\
			         <strong class="tenDeTai">' + yeuCau.tenDeTai+'...</strong>\
			        </a>\
			     </div>';
			    var notifi = $(el);
			    $("#displayNotification").append(notifi);
			    setTimeout(function(){
					notifi.remove();
				},3000);
				
				var val = $("#nThongBao").text().trim();
				val = Number(val)+ 1;
				$("#nThongBao").text(val);
				
				var menu_item = '<li>\
                    <a href="/quan-li/thong-tin-de-tai/'+yeuCau.idDeTai+'">\
                        <strong class="tenNguoiDung"> '+yeuCau.tenNguoiDung+' </strong>đăng kí đề tài:\
                        <strong class="tenDeTai">' + yeuCau.tenDeTai+'...</strong>\
                        <span class="bagde new" style="color:red;margin:0px 10px;font-size:17px;">MỚI</span>\
                        <div class="thoiGian">\
                            <span class="glyphicon glyphicon-time"></span>\
                            <span>'+yeuCau.thoiGianTao+'</span>\
                        </div>\
                     </a>\
                  </li>';
				
				$("#notification-container").prepend(menu_item);
				
			});
		});
	}
	connect();
	var requestdata = {
			page: 1,
			pageSize: 6
	};
	var getYeuCau = function(){
		$.post("/yeu-cau-duyet-de-tai",requestdata,function(response){
			var dsYeuCau = response.data;
			console.log(response);
			dsYeuCau.forEach(function(yeuCau){
				var el = '<li>\
	                     <a href="/quan-li/thong-tin-de-tai/'+yeuCau.idDeTai+'">\
	                         <strong class="tenNguoiDung"> '+yeuCau.tenNguoiDung+' </strong>đăng kí đề tài:\
	                         <strong class="tenDeTai">' + yeuCau.tenDeTai+'...</strong>\
	                         <div class="thoiGian">\
	                             <span class="glyphicon glyphicon-time"></span>\
	                             <span>'+yeuCau.thoiGianTao+'</span>\
	                         </div>\
	                      </a>\
	                   </li>';
				
				$("#xemThem").before(el);
			});
			
			if(response.page === response.totalPages){
				$("#xemThem").addClass("hidden");
			}
			$("#nThongBao").text(response.totalElement);
			
		},"json");
	};
	getYeuCau();
	$("#notification-container").click(function(e){
		console.log(e.target);
		var $target = $(e.target);
		if($target.hasClass("xemThem")){
			e.preventDefault();
			e.stopImmediatePropagation();
			requestdata.page = requestdata.page+1;
			getYeuCau();
		}
	})
	
});