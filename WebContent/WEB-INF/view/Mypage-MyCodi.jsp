<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl(core lib: 대부분 제어와 관련) 접두사와 처리기 선언-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyCodi</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet"/>
<link href="../css/Mypage.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
#coordies-list img{width: 100px;}
</style> 
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
	//jquery 복붙 소스
	$(function(){
	    //전체선택 체크박스 클릭
		$("#all-check").click(function(){
			//만약 전체 선택 체크박스가 체크된상태일경우
			if($("#all-check").prop("checked")) {
				//해당화면에 전체 checkbox들을 체크해준다
				$("input[type=checkbox]").prop("checked",true);
			// 전체선택 체크박스가 해제된 경우
			} else {
				//해당화면에 모든 checkbox들의 체크를해제시킨다.
				$("input[type=checkbox]").prop("checked",false);
			}
		})
	})
	
	function del(){
		var f = document.itemForm;
		f.method = "post";
		f.action = "mypage-mycodi-del";
		f.submit();
	}
	
	function state(){
		var f = document.itemForm;
		f.method = "post";
		f.action = "mypage-mycodi-open";
		f.submit();
	}
	
</script>

</head>
<body>
	<!-- CSS로 스타일을 입힐때 보이게끔만... 문서의 위치가 보여지는 위치는 아니다. -->
	<div id="top-blank"></div>
	<div id="mid-blank"  class="clearfix">
	
		<div id="customer-menu-blank">
			<header id=logo>
				<h1><img src="../images/Logo.png" alt="TASTES COORDI" /></h1>
			</header>
		
			<aside id="customer-menu">
				<h1 class="hidden">마이페이지</h1>
				
				<section>
					<h1 class="hidden">회원/업체 메뉴</h1>
					
					<div id="customer-menu-text">
					<section>
						<h1 class="hidden">회원/업체 정보</h1>
						
						<article>
							<h1><img src="" alt="회원/업체 프로필사진" ></h1>					
						</article>
						
						<!-- 페이지를 만들까... -->				
						<nav>
							<h1 class="hidden">회원/업체 정보 수정</h1>
							<div>
								<a href="">정보 수정</a>
							</div>
						</nav>
						
						<article>
							<h1 class="hidden">회원/업체 social 정보</h1>
							<dl>
								<dt>팔로워</dt>
									<dd><a href="">${follower}</a></dd>
								<dt>팔로잉</dt>
									<dd><a href="">${following}</a></dd>
								<dt>댓글</dt>
									<dd>${commentCnt}</dd>								
							</dl>
						</article>
		
					</section>
					
					<nav>
						<h1 class="hidden">회원 선택 메뉴</h1>
						<ul>
							<li><a href="">내 코디</a></li>
							<li><a href="">내 옷장</a></li>
							<li><a href="">좋아요</a></li>
							<li><a href="">찜한 아이템</a></li>
						</ul>
					</nav>
				</div>
				</section>			
			</aside>
		</div>
		
		<main id="item-list">	
		<section>
			<h1>내 코디</h1>
			
			<section id="coordies-list">
							
				<h1 class="hidden">상품목록</h1>
				
				<form name="itemForm">
					<a href="Mypage-MyCodi-Reg.jsp"><input type="submit" value="글쓰기"/></a>
					<input type="button" value="삭제" onclick="del()">
					<input type="button" value="공개/비공개" onclick="state()">
				
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" id="all-check">check all<br></th>
								<th>코드</th>
								<th>작성자</th>
								<th>이미지명</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="codi" items="${list}">	
							<tr>
								<td><input type="checkbox" name="check" value="${codi.code}"/></td>
								<td>${codi.code}</td>
								<td>${codi.mid}</td>
								<td><img src="../Mypage/coordies/${codi.img}">${codi.img}</td>
								<td>${codi.open}</td>	
														
							</tr>
		
						</c:forEach>
						</tbody>
					</table>
				</form>
				
			</section>
		</section>	
		</main>
		
		<aside id="main-menu">
			<h1 class="hidden">메인 메뉴</h1>		
			<nav>
				<h1 class="hidden">메인 메뉴 목록</h1>
				<ul>
					<li><a href=""><img src="../images/Mypage-icon.png" alt="Mypage" /></a></li>
					<li><a href=""><img src="../images/Login-icon.png" alt="Login" /></a></li>
					<li><a href=""><img src="../images/Coordi-icon.png" alt="Coordi" /></a></li>
					<li><a href=""><img src="../images/Search-icon.png" alt="Search" /></a></li>
					<li><a href=""><img src="../images/Q&A-icon.png" alt="Q&A" /></a></li>
					<li><a href=""><img src="../images/Company-icon.png" alt="Company" /></a></li>
				</ul>
			</nav>	
		</aside>
	</div> 
	
	<footer id="bot-blank">
		<section id="copyright">
			<h1>저작권정보</h1>
			<p>FreeStyle Copyrightⓒ2015</p>
		</section>
	</footer>

</body>
</html>