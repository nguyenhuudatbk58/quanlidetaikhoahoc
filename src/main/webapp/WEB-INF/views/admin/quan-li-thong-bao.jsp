<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Tìm kiếm</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="/assets/css/sb-admin.css" rel="stylesheet">
<link href="/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">
		<jsp:include page="layouts/navigation.jsp"></jsp:include>
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Đăng thông báo
						   <a href="#" style="font-size:15px;">Danh sách thông báo</a>
						</h1>
					</div>
				</div>
				<div class="col-md-10 col-md-offset-1">
                     <form>
                        <div class="form-group">
                            <label >Tiêu đề:</label>
                            <textarea rows="4" class="form-control"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Nội dung:</label>
                            <textarea id="richContentEditor"></textarea>
                        </div>
                        
                        <div class="form-group col-md-2 col-md-offset-4">
                            <input type="submit" value="Đăng" class="form-control btn btn-success"> 
                        </div>
                        <div class="form-group col-md-2 ">
                            <input type="button" value="Quay lại" class="form-control btn btn-default"> 
                        </div>
                     </form>
                     
				</div>
			</div>
           <form>
              <input type="file" class="hidden" id="imageUpload">
           </form>
		</div>
	</div>
	<script src="/assets/js/jquery.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
	<script src="/assets/js/tinymce/tinymce.min.js" type="text/javascript"></script>
	 <script>
            $(document).ready(function () {
                   tinymce.init({
                    selector: '#richContentEditor',
                    plugins: [
                        'advlist autolink link image imagetools lists charmap print preview hr anchor pagebreak spellchecker',
                        'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
                        'save table contextmenu directionality emoticons template paste textcolor colorpicker '
                    ],
                    toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons",
                    theme: 'modern',
                    paste_data_images: true,
                    file_browser_callback_types: ' image ',
                    file_picker_types: ' image ',
                    file_browser_callback: function (field_name, url, type, win) {
                        if (type === "image")
                            $("#imageUpload").click();
                        
                        console.log(field_name);
                        console.log(url);
//                    win.document.getElementById(field_name).value = 'my browser value';
                    },
                    images_upload_url: "/quan-li/upload",
                    height: 300
                });
                
                $("#richContent").submit(function (e) {
                    e.preventDefault();
                    console.log(tinymce.activeEditor.getContent());
                    $.post("/quan-li/tao-thong-bao", tinymce.activeEditor.getContent(), function () {

                    });
                });
            });
        </script>
</body>