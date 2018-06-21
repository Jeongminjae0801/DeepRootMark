<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>뿌리깊은마크</title>
	
	<!-- Latest compiled Bootstrap Common CSS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Bootstrap Common CSS END -->
    
    <!-- jQuery Confirm START -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
	<!-- jQuery Confirm END -->

	<!-- Common Script START -->
    <!-- Latest compiled JavaScript & CSS -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Script Common JavaScript & CSS END -->

	<!-- Social Page CSS -->
    <link href="${pageContext.request.contextPath}/css/social/social.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/social/modal.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mainpage/header.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mainpage/footer.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mainpage/list_table.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mainpage/responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mainpage/login-register.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/social/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Social Page CSS END -->

    <!--Script Start -->
    <script src="${pageContext.request.contextPath}/js/social/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/social/dataTables.bootstrap.min.js"></script>
    <!-- Script END -->

    <script>
        /*****************  Table Start **********************/
        $(function() {
            $(document).on("click", ".url", function() {
                window.open(this.dataset.url, '_blank');
            });
            $('li').on({
                mouseover: function() {
                    $(this).children('button').css('display', 'block')
                },
                mouseleave: function() {
                    $(this).children('button').css('display', 'none')
                }
            });
            $(document).on("click", ".show_close_img", function() {
                if ($(this).attr('src') == 'icon/all_show.png') {
                    $(this).attr('src', 'icon/all_close.png');
                    $(this).parent().parent().children('ul').hide(500);
                } else {
                    $(this).attr('src', 'icon/all_show.png');
                    $(this).parent().parent().children('ul').show(500);
                }
            });
        });
        /******************  Table END  *******************/

        /* *********** Scroll Shadow Start ********************* */
        $(function() {
            var header = $('#header');
            $(window).scroll(function(e) {
                if (header.offset().top !== 0) {
                    if (!header.hasClass('shadow')) {
                        header.addClass('shadow');
                    }
                } else {
                    header.removeClass('shadow');
                }
            })
        });
        /* ************* Scroll Shadow END ******************* */

        /* ******************** Table Search START *************************** */
        $(function() {
            $('#listTable1').DataTable({
                responsive: true,
                "order": [[ 3, "desc" ]]
            });
            $('#listTable2').DataTable({
                responsive: true,
                "order": [[ 3, "desc" ]]
            });
        });
        /* ******************** Table Search END *************************** */
    </script>

</head>
<body>

	<div id="main-header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<div id="main">
		<tiles:insertAttribute name="content" />
	</div>
	
	<div id="main-footer">
		<tiles:insertAttribute name="footer" />
	</div>
	
	
	<!-- Common Script START -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wow.min.js"></script>
    <!-- Common Script END -->

    <!-- Custom Script START -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/social/social.js"></script>
    <!-- Custom Script END -->
</body>
</html>