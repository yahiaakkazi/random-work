$( window ).ready(function() {
  connect();
});

function connect() {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
      stompClient.subscribe('/topic/pushNotification', function (notification) {
      	  var currentText = $('#textArea').val();
      	  var updatedText = currentText + notification + '\n';
    	  $('#textArea').val(updatedText);
       });
  });
}
