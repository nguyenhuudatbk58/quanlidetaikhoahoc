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

	function connect() {
		var socket = new SockJS('/notification');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			console.log("connect successfully!");
			
			stompClient.subscribe("/post/1", function(response) {
				
			});
		});
	}
	
	var displayNotification = function(notification){
		$("#notification").append()
	}
	
});