<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 단어장</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/common3.css">
<link rel="stylesheet" type="text/css" href="../css/list7.css">
<link rel="stylesheet" href="../bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="../css/component.css" />

		<meta name="description" content="Loading Effects for Grid Items with CSS Animations" />
		<meta name="keywords" content="css animation, loading effect, google plus, grid items, masonry" />
	 	<meta name="author" content="Codrops" /> 
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script src="../js/modernizr.custom.js"></script>
<script src="../bower_components/jquery/dist/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		
<style>
   body {
   background-color: #F9F6F1;
   margin: 0 auto;
   }
   
   #d1 {
      position: relative;
      min-width: 960px;
      width: 100%;
      height: 246px;
      padding-bottom: 13%;
       overflow: hidden; 
   }
/*    #logodiv {
      position: absolute;
      top: 80px;
      width: 400px;
      height: 100px;
      z-index: 2;
      right: 50%;
      margin: 0 -200px 0 0;
   } */

  .searchdiv {
    position: absolute;
    top: 40%;
    left: 45%;
  }
  
  
   #threediv {
   z-index : 1000;
   }
   
   /*font (roboto)*/
@import url(http://fonts.googleapis.com/css?family=Roboto:400,300,500);

/*resets*/
* {
    padding:0;
    margin:0;
    font-family:'Roboto', sans-serif;
}

/*basic layout*/
.material-contact {
    width:320px;
    max-width:100%;
    height:auto;
    padding: 50px 25px 30px 25px;
    box-sizing:border-box;
    display:block;
    position:relative;
    margin:0px auto;
    overflow:hidden;
    
    background:#fff;
    border-radius:5px;
}

/*header*/
.material-contact img {
    width:120px;
    height:120px;
    display:block;
    margin:0 auto;
    border-radius:100%;
}
.material-contact h1 {
    width:100%;
    height:auto;
    padding:15px 0 5px 0;
    display:block;
    
    font-family:'Roboto', sans-serif;
    font-size:1.9rem;
    font-weight:300;
    line-height:1em;
    text-align:center;
    
    color:#000;
    background:none;
}
.material-contact h2 {
    width:100%;
    height:auto;
    padding:5px 0;
    display:block;
    
    font-family:'Roboto', sans-serif;
    font-size:1.2rem;
    font-weight:300;
    line-height:1em;
    text-align:center;
    
    color:#aaa;
    background:none;
}

.material-contact hr {
    width:30%;
    height:0;
    padding:0;
    display:block;
    margin:30px auto;
    border:1px solid #ddd;
}

/*info section*/
.material-contact p {
    width:100%;
    height:auto;
    padding:10px 0;
    display:block;
    
    font-family:'Roboto', sans-serif;
    font-size:1rem;
    font-weight:400;
    line-height:1.2em;
    text-align:center;
}

.material-contact .actions {
    width:100%;
    height:auto;
    padding:0;
    display:block;
    margin:10px 0 0 0;
    
    align-content:center;
    text-align:center;
}
.material-contact .actions a {
    width:auto;
    height:auto;
    padding:5px 10px;
    box-sizing:border-box;
    display:inline-block;
    margin:5px auto;
    
    font-family:'Roboto', sans-serif;
    font-size:1rem;
    font-weight:500;
    line-height:1.2em;
    text-decoration:none;
    
    border-radius:100px;
    background:#fff;
    color:#aaa;
    
    transition:.1s;
}
.material-contact .actions a:hover {
    background:#fff;
    color:#000;
}
.material-contact .actions a:active {
    background:#000;
    color:#fff;
}

/*animation*/
.animate-in-01 {
    animation:animateIn 1s ease;
    -webkit-animation:animateIn 1s ease;
}
.animate-in-02 {
    animation:animateIn 1s ease forwards;
    animation-delay:.2s;
    -webkit-animation:animateIn 1s ease forwards;
    -webkit-animation-delay:.2s;
    opacity:0;
}
.animate-in-03 {
    animation:animateIn 1s ease forwards;
    animation-delay:.4s;
    -webkit-animation:animateIn 1s ease forwards;
    -webkit-animation-delay:.4s;
    opacity:0;
}
.animate-in-04 {
    animation:animateIn 1s ease forwards;
    animation-delay:.5s;
    -webkit-animation:animateIn 1s ease forwards;
    -webkit-animation-delay:.5s;
    opacity:0;
}
.animate-in-05 {
    animation:animateIn 1s ease forwards;
    animation-delay:.6s;
    -webkit-animation:animateIn 1s ease forwards;
    -webkit-animation-delay:.6s;
    opacity:0;
}
@keyframes animateIn {
    0%{
        opacity:0;
        transform: translateY(50px);
        -webkit-transform: translateY(50px);
        -moz-transform: translateY(50px);
        -ms-transform: translateY(50px);
        -o-transform: translateY(50px);
    }
    100%{
        opacity:1;
        transform: translateY(0);
        -webkit-transform: translateY(0);
        -moz-transform: translateY(0);
        -ms-transform: translateY(0);
        -o-transform: translateY(0);
    }
}
@-webkit-keyframes animateIn {
    0%{
        opacity:0;
        transform: translateY(50px);
        -webkit-transform: translateY(50px);
        -moz-transform: translateY(50px);
        -ms-transform: translateY(50px);
        -o-transform: translateY(50px);
    }
    100%{
        opacity:1;
        transform: translateY(0);
        -webkit-transform: translateY(0);
        -moz-transform: translateY(0);
        -ms-transform: translateY(0);
        -o-transform: translateY(0);
    }
}

.animate-in-image {
    animation:animateInImage 1s ease;
    -webkit-animation:animateInImage 1s ease;
}
@keyframes animateInImage {
    0%{
        opacity:0;
    }
    100%{
        opacity:1;
    }
}
@-webkit-keyframes animateInImage {
    0%{
        opacity:0;
    }
    100%{
        opacity:1;
    }
}

.animate-in-card {
    animation:animateIn .7s ease;
    -webkit-animation:animateIn .7s ease;
}


.textbox {
  position: relative;
  left: 50%;
  width: 200px;
  margin: 130px 0 0 -300px;
}

.mywordtext {
  position: absolute;
  left: 50%;
  margin: -80px 0 0 45px;
  width: 300px;
}


.line {
  position: absolute;
    left: 50%;
    margin: 340px 0 0 -410px;
    content: ' ';
    display: block;
    width: 800px;
    height: 2px;
         background: -moz-linear-gradient(left, rgba(36,43,51,0) 0%, rgba(36,43,51,0.8) 20%, rgba(36,43,51,1) 53%, rgba(36,43,51,0.8) 79%, rgba(36,43,51,0) 100%); 
         background: -webkit-gradient(linear, left top, right top, color-stop(0%,rgba(36,43,51,0)), color-stop(20%,rgba(36,43,51,0.8)), color-stop(53%,rgba(36,43,51,1)), color-stop(79%,rgba(36,43,51,0.8)), color-stop(100%,rgba(36,43,51,0))); 
         background: -webkit-linear-gradient(left, rgba(36,43,51,0) 0%,rgba(36,43,51,0.8) 20%,rgba(36,43,51,1) 53%,rgba(36,43,51,0.8) 79%,rgba(36,43,51,0) 100%); 
         background: -o-linear-gradient(left, rgba(36,43,51,0) 0%,rgba(36,43,51,0.8) 20%,rgba(36,43,51,1) 53%,rgba(36,43,51,0.8) 79%,rgba(36,43,51,0) 100%); 
         background: -ms-linear-gradient(left, rgba(36,43,51,0) 0%,rgba(36,43,51,0.8) 20%,rgba(36,43,51,1) 53%,rgba(36,43,51,0.8) 79%,rgba(36,43,51,0) 100%); 
         background: linear-gradient(left, rgba(36,43,51,0) 0%,rgba(36,43,51,0.8) 20%,rgba(36,43,51,1) 53%,rgba(36,43,51,0.8) 79%,rgba(36,43,51,0) 100%); 
         }
}


.thumbnail {
  position: absolute;
  border-radius : 50% !important;

}

font {
	line-height: 1.5em;
}


</style>

</head>
<body>
  <div id="d1">
     <span id="threediv">
     <nav>
       <ul>

          <li><a href="../add/addasso.html" class="newfile-btn"><i></i><img src="../images/newfile.png" width="70"/><br></br><font size='3'>연상법 등록</font></a></li>
          <li><a href="../learn/learnchoice.html" class="study-btn"><i></i><img src="../images/pencil.png" width="70"/><br></br><font size='3'>연상법 학습</font></a></li>
          <li><a href="../myword/myword.html" class="profile-btn"><i></i><img src="../images/bookicon.png" width="80"/><br></br><font size='3'>나의 단어장</font></a></li>

       </ul>
     </nav>
     </span>
     
     <div id="logodiv" align="center"><a href="../main/main.html"><img src="../images/logo.png" id="logo"/></a></div>
     <div id="topsearchdiv" align="center">
	   <form method="get" action="../list/list.html">
	   <input id="topsearch" name="word" type="text" value="search"  onfocus="this.value=''" onblur="if(this.value =='') this.value='search';"/>
	   </form>
	   </div>
     
     <div class="menubar">
		 <ul>
		   <li><a href="#" id="current">
		     <div class="mypage">
	    	   <div class="imgdiv"><img class="thumbnail" src="https://d12hfz37g51hrt.cloudfront.net/assets/default/user/photo_small-eb39055bd595b4f8b1a0d54e41ecf088.jpg" width="45" height="45"></div>
	   	     <div class="name"><font size="3">김현지</font></div>
	       </div>
	   	    </a>
	        <ul>
			     <li><a href="location:;">받은좋아요 <img src="../images/mainlikewhite.png" width="20px" height="20px"><font align="right"> &nbsp;&nbsp;&nbsp;&nbsp;110</font></a></li>
			     <li><a href="#">설정</a></li>
			     <li><a href="../auth/logout.do">로그아웃</a></li>
		    </ul>
	      </li>
	   </ul>
		 </div>
  	   
     <video autoplay loop poster="../images/strip.jpg" id="bgvid">
     <source src="../images/search_back.mp4" type="video/mp4">
    </video>
     
   </div>

   <div class="textbox">
    <div class="mywordtext">
      <h2>나의 단어장</h2>   
  <select id="assosCount" onchange="loadPaging()">
  <option selected='selected'>3</option>
  <option>5</option>
  <option>10</option>
  </select>
    </div>
  </div>
  
 <div class="line" align="center"> </div>

	<div class="container">
			<!-- Top Navigation -->
			<ul class="grid effect-2" id="grid">
			</ul>
<div class="paginate">
   
</div>
		<script src="../bower_components/masonry/dist/masonry.pkgd.js"></script>
		<script src="../bower_components/imagesloaded/imagesloaded.js"></script>
		<script src="../bower_components/classie/classie.js"></script>
		<script src="../js/AnimOnScroll.js"></script>
<script>
	loadAsso();
	
	function loadAsso() {
		$.getJSON("../ajax/myWord/list.do",{pageNo: 1, pageSize:$("#assosCount").val()}, function (result) {
			var ul = $("#grid");
			var pagingTag = $(".paginate");
			var list = result.list;
			var paging = result.paging;
			console.log($("#assosCount").val());
			console.log("firstPageNo : " + paging.firstPageNo);
			console.log("prevPageNo  : " + paging.prevPageNo);
			console.log("startPageNo  : " + paging.startPageNo);
			console.log("endPageNo  : " + paging.endPageNo);
			console.log("pageNo  : " + paging.pageNo);
			console.log("nextPageNo  : " + paging.nextPageNo);
			console.log("finalPageNo  : " + paging.finalPageNo);
		  for (var i in list) {
			  $("<li>").html("<div class='material-contact animate-in-card'>" + 
				"<img class='animate-in-image' src='" + list[i].assophotPath + "'>" +
				"<h1 class='animate-in-01'><font size=4><strong>" + list[i].word + "</strong></font></h1>" +
				"<h2 class='animate-in-02'><font size=3 color='black'>" + list[i].mean + "</font></h2>" + 
				"<hr class='animate-in-03'>" +
				"<p class='animate-in-04'><font size=3><strong>" + list[i].asso + "</strong></font></p></div>")
				.appendTo(ul);
		  }
		  $("<div>").html("<a href='javascript:goPage(" + paging.firstPageNo + ")' class='first'>◀◀</a>" + 
				  "<a href='javascript:goPage(" + paging.prevPageNo + ")' class='prev'>              ◀          </a>" +
				  "<span class='pageNo'>" + 
			    "<a href='javascript:goPage(" + paging.nextPageNo + ")' class='next'>               ▶         </a>" +
			    "<a href='javascript:goPage(" + paging.finalPageNo + ")' class='last'>▶▶</a>")
			    .appendTo(pagingTag);
		  /* for (var i = 0; i <= paging.finalPageNo; i++) {
			     
			        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
			            <c:choose>
			                <c:when test="${i eq paging.pageNo}"><a href="javascript:goPage(${i})" class="choice">${i}</a></c:when>
			                <c:otherwise><a href="javascript:goPage(${i})">${i}</a></c:otherwise>
			            </c:choose>
			        </c:forEach>			
		  } */
		  new AnimOnScroll( document.getElementById('grid'), {
				minDuration : 0.4,
				maxDuration : 0.7,
				viewportFactor : 0.2
			} );
		});
	}	
	</script>

<script>
  function goPage(i) {
    $(document).ready(function () {       
    // Ajax 통신으로 서버에 Data를 전송하고 Return 받습니다.
    	$.ajax({
           // type을 설정합니다.
           type: 'POST',
           url: "../ajax/myWord/list.do",
           data: {
			   pageNo : i,        	   
        	   pageSize : $("#assosCount").val()
              },
           // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
           success: function (data) {
        	   $.getJSON("../ajax/myWord/list.do", {pageNo : i, pageSize:$("#assosCount").val()}, function (result) {
        		$("#grid").empty();
        		var ul = $("#grid");
       			var list = result.list;
       			var paging = result.paging;
       			console.log($("#assosCount").val());
       			console.log("firstPageNo : " + paging.firstPageNo);
       			console.log("prevPageNo  : " + paging.prevPageNo);
       			console.log("startPageNo  : " + paging.startPageNo);
       			console.log("endPageNo  : " + paging.endPageNo);
       			console.log("pageNo  : " + paging.pageNo);
       			console.log("nextPageNo  : " + paging.nextPageNo);
       			console.log("finalPageNo  : " + paging.finalPageNo);
       		  for (var i in list) {
       			  $("<li>").html("<div class='material-contact animate-in-card'>" + 
       				"<img class='animate-in-image' src='" + list[i].assophotPath + "'>" +
       				"<h1 class='animate-in-01'><font size=4><strong>" + list[i].word + "</strong></font></h1>" +
       				"<h2 class='animate-in-02'><font size=3 color='black'>" + list[i].mean + "</font></h2>" + 
       				"<hr class='animate-in-03'>" +
       				"<p class='animate-in-04'><font size=3><strong>" + list[i].asso + "</strong></font></p></div>")
       				.appendTo(ul);
       		  }
       		  new AnimOnScroll(document.getElementById('grid'), {
       				minDuration : 0.4,
       				maxDuration : 0.7,
       				viewportFactor : 0.2
       		});
       		  });
        	   }});});
   }              
</script>	
<script>
  function loadPaging() {
    $(document).ready(function () {       
    // Ajax 통신으로 서버에 Data를 전송하고 Return 받습니다.
    	$.ajax({
           // type을 설정합니다.
           type: 'POST',
           url: "../ajax/myWord/list.do",
           data: {
			   pageNo : 1,        	   
        	   pageSize : $("#assosCount").val()
              },
           // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
           success: function (data) {
        	   $.getJSON("../ajax/myWord/list.do", {pageNo : 1, pageSize:$("#assosCount").val()}, function (result) {
        		$("#grid").empty();
        		var ul = $("#grid");
       			var list = result.list;
       			var paging = result.paging;
       			console.log($("#assosCount").val());
       			console.log("firstPageNo : " + paging.firstPageNo);
       			console.log("prevPageNo  : " + paging.prevPageNo);
       			console.log("startPageNo  : " + paging.startPageNo);
       			console.log("endPageNo  : " + paging.endPageNo);
       			console.log("pageNo  : " + paging.pageNo);
       			console.log("nextPageNo  : " + paging.nextPageNo);
       			console.log("finalPageNo  : " + paging.finalPageNo);
       		  for (var i in list) {
       			  $("<li>").html("<div class='material-contact animate-in-card'>" + 
       				"<img class='animate-in-image' src='" + list[i].assophotPath + "'>" +
       				"<h1 class='animate-in-01'><font size=4><strong>" + list[i].word + "</strong></font></h1>" +
       				"<h2 class='animate-in-02'><font size=3 color='black'>" + list[i].mean + "</font></h2>" + 
       				"<hr class='animate-in-03'>" +
       				"<p class='animate-in-04'><font size=3><strong>" + list[i].asso + "</strong></font></p></div>")
       				.appendTo(ul);
       		  }
       		  new AnimOnScroll(document.getElementById('grid'), {
       				minDuration : 0.4,
       				maxDuration : 0.7,
       				viewportFactor : 0.2
       		});
       		  });
        	   }});});
   }              
</script>   
</body>
</html>