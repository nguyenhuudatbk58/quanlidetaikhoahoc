 $(document).ready(function () {
	 
     tinymce.init({
        selector: '#richContentEditor',
        plugins: [
              'advlist autolink link image imagetools lists charmap print preview hr anchor pagebreak spellchecker',
              'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
              'save table contextmenu directionality emoticons template paste textcolor colorpicker '
        ],
        entity_encoding : "raw",
        toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons",
        theme: 'modern',
        height: 300
     });
                
     $("#taoThongBao").submit(function (e) {
    	 
           e.preventDefault();
           var tieuDe = $("#tieuDe").val().trim();
           var noiDung = tinymce.activeEditor.getContent();
           if(tieuDe === ""){
             var message = $("<p>Nhập tiêu đề của thông báo</p>");
             $("#message").addClass("alert-warning");
             $("#message").removeClass("hidden");
             $("#message").append(message);
                    	
             setTimeout(function(){
                $("#message").addClass("hidden");
                $("#message").removeClass("alert-warning")
                message.remove();
             },5000);
          }else if(noiDung === ""){
               var message = $("<p>Nhập nội dung của thông báo</p>");
               $("#message").addClass("alert-warning");
               $("#message").removeClass("hidden");
               $("#message").append(message);
                    	
               setTimeout(function(){
                 $("#message").addClass("hidden");
                 $("#message").removeClass("alert-warning")
                 message.remove();
               },5000);
           }else{
              var requestData = {
                 tieuDe: tieuDe,
                 noiDung: noiDung
              };
              console.log(tinymce.activeEditor.getContent());
              $.post("/quan-li/tao-thong-bao",requestData, function () { 
                           	
                   var message = $("<p>Đăng thông báo thành công.</p>");
                   $("#message").addClass("alert-success");
                   $("#message").removeClass("hidden");
                   $("#message").append(message);
                        	
                   setTimeout(function(){
                     $("#message").addClass("hidden");
                     $("#message").removeClass("alert-success")
                     message.remove();
                   },3000);
                        	
              });
            }
      });
                
        $("#backBtn").click(function(){
            window.history.back();
        });
});