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

    <!-- Bootstrap Common CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/font-awesome.min.css" rel="stylesheet">
    <link href="../css/animate.min.css" rel="stylesheet">
    <!-- Bootstrap Common CSS END -->

    <!-- Social Page CSS -->
    <link href="../css/social/social.css" rel="stylesheet">
    <link href="../css/mainpage/header.css" rel="stylesheet">
    <link href="../css/mainpage/footer.css" rel="stylesheet">
    <link href="../css/mainpage/list_table.css" rel="stylesheet">
    <link href="../css/mainpage/responsive.css" rel="stylesheet">
    <link href="../css/mainpage/login-register.css" rel="stylesheet" />
    <link href="../css/social/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Social Page CSS END -->

    <!--Script Start -->
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script src="../js/social/social.js"></script>
    <script src="../js/social/jquery.dataTables.min.js"></script>
    <script src="../js/social/dataTables.bootstrap.min.js"></script>
    <script src="../js/script.js"></script>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
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

        $(function() {
            $("#myModal").on('show.bs.modal', function(event) {
                var button = $(event.relatedTarget); // Button that triggered the modal
                var titleData = button.data('title'); // Extract value from data-* attributes
                $(this).find('.modal-title').text(titleData + ' Form');
            });
        });
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
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/wow.min.js"></script>
    <!-- Common Script END -->

    <!-- Custom Script START -->
    <script type="text/javascript" src="../js/social/social.js"></script>
    <script type="text/javascript" src="../js/login.js"></script>
    <!-- Custom Script END -->
</body>
</html>