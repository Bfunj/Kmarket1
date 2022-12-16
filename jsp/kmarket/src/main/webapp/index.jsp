<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <link rel="shortcut icon" type="image/x-icon" href="/kmarket/img/common/favicon.ico"/>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <link rel="stylesheet" href="/kmarket/css/common.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script>
    	
    	
      $(document).ready(function () {
        $(".slider > ul").bxSlider({
          easing: "linear",
        });
      });
       
      $(function () {
        var best = $("aside > .best");

        $(window).scroll(function () {
          var t = $(this).scrollTop();

          if (t > 620) {
            best.css({
              position: "fixed",
              top: "0",
            });
          } else {
            best.css({ position: "static" });
          }
        });
        
        let sessUser = "${sessUser}";
        
        $('.mypage').click(function(e){
        	e.preventDefault();
        	if(sessUser == null){
        		alert('로그인 후 이용 가능합니다.');
        		location.href="/kmarket/member/login.do";
        	}
        });
      });
    </script>
  </head>
  <body>
    <div id="wrapper">
      <header>
        <div class="top">
          <div>
	          <c:choose>
	          	<c:when test="${empty sessUser }">
		            <a href="/kmarket/member/login.do">로그인</a>
		            <a href="/kmarket/member/signup.do">회원가입</a>
		            <a href="/kmarket/member/mypage.do" class="mypage">마이페이지</a>
		      	</c:when>
		      	<c:otherwise>
		      		<span>${sessUser.name }</span>님 반갑습니다.
		            <a href="/kmarket/member/logout.do">로그아웃</a>
		            <a href="/kmarket/member/mypage.do">마이페이지</a>
		            <a href="/kmarket/product/cart.do"
		              ><i class="fa fa-shopping-cart" aria-hidden="true"></i
		              >&nbsp;장바구니</a>
				</c:otherwise>
		      </c:choose>

          </div>
        </div>
        <div class="logo">
          <div>

            <a href="#"><img src="./img/common/header_logo.png" alt="로고" /></a>

            <form action="#">
              <input type="text" name="search" />
              <button><i class="fa fa-search"></i></button>
            </form>
          </div>
        </div>
        <div class="menu">
          <div>
            <ul>
              <li><a href="#">히트상품</a></li>
              <li><a href="#">추천상품</a></li>
              <li><a href="#">최신상품</a></li>
              <li><a href="#">인기상품</a></li>
              <li><a href="#">할인상품</a></li>
            </ul>
            <ul>
              <li><a href="./cs/notice/list.do">공지사항</a></li>
              <li><a href="./cs/faq/list.do">자주묻는질문</a></li>
              <li><a href="./cs/qna/write.do">문의하기</a></li>
              <li><a href="./cs/qna/list.do">고객센터</a></li>
            </ul>
          </div>
        </div>
      </header>
      <main>
        <!-- 카테고리/베스트 상품 영역 -->
        <aside>
          <!-- 카테고리 -->
          <ul class="category">
            <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
            <li>
              <a href="#"
                ><i class="fas fa-tshirt"></i>패션·의류·뷰티<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">남성의류</a></li>
                <li><a href="#">여성의류</a></li>
                <li><a href="#">잡화</a></li>
                <li><a href="#">뷰티</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-laptop"></i>가전·디지털<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">노트북/PC</a></li>
                <li><a href="#">가전</a></li>
                <li><a href="#">휴대폰</a></li>
                <li><a href="#">기타</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-utensils"></i>식품·생필품<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">신선식품</a></li>
                <li><a href="#">가공식품</a></li>
                <li><a href="#">건강식품</a></li>
                <li><a href="#">생필품</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-home"></i>홈·문구·취미<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">가구/DIY</a></li>
                <li><a href="#">침구·커튼</a></li>
                <li><a href="#">생활용품</a></li>
                <li><a href="#">사무용품</a></li>
              </ol>
            </li>
          </ul>

          <!-- 베스트상품 배너 -->
          <article class="best">
            <h1><i class="fas fa-crown"></i>베스트상품</h1>
            <ol>
            <c:set var="done_loop" value="false"/>
            <c:set var="i" value="1"></c:set>
            <c:forEach var="listProductBest" items="${listProductBest}">
              <c:if test="${done_loop ne true}">
              <li>
                <a href="/kmarket/product/view.do?&proNo=${listProductBest.proNo}&cate1=${listProductBest.cate1}&cate2=${listProductBest.cate2}">
                  <div class="thumb">
                    <i>${i }</i>
                    <c:choose>
                    	<c:when test="${i eq 1 }">
                    		<img src="file/${listProductBest.cate1 }/${listProductBest.cate2 }/${listProductBest.thumb2 }" width=230px height=230px alt="item1" />
                    	</c:when>
                    	<c:otherwise>
                    		 <img src="file/${listProductBest.cate1 }/${listProductBest.cate2 }/${listProductBest.thumb2 }" width=50px height=50px alt="item1" />
                    	</c:otherwise>
                    </c:choose>          
                  </div>
                  <h2>${listProductBest.proName }</h2>
                  <div class="org_price">
                    <del>${listProductBest.price }</del>
                    <span>${listProductBest.discount }%</span>
                  </div>
                  <div class="dis_price">
                    <ins>${(listProductBest.price/100)*(100-listProductBest.discount)  }</ins>
                  </div>
                </a>
              </li>
              		 <c:set var="i" value="${i+1}"></c:set>
					  	<c:if test="${i eq 6}">
                       		<c:set var="done_loop" value="true"/>
                    	</c:if>
              	</c:if>
              </c:forEach>
         
            </ol>
          </article>
        </aside>
        <section>
          <!-- 슬라이더 영역 -->
          <section class="slider">
            <ul>
              <li>
                <a href="#"
                  ><img src="https://via.placeholder.com/985x447" alt="item1"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="https://via.placeholder.com/985x447" alt="item2"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="https://via.placeholder.com/985x447" alt="item3"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="https://via.placeholder.com/985x447" alt="item4"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="https://via.placeholder.com/985x447" alt="item5"
                /></a>
              </li>
            </ul>
          </section>
          <!-- 히트상품 영역 -->
          <section class="hit">
            <h3><span>히트상품</span></h3>
          	<c:set var="done_loop" value="false"/>
            <c:set var="num1" value="1"></c:set>
			<c:forEach var="listProductHit" items="${listProductHit}">
			  <c:if test="${done_loop ne true}">
	            <article>
	              <a href="/kmarket/product/view.do?&proNo=${listProductHit.proNo}&cate1=${listProductHit.cate1}&cate2=${listProductHit.cate2}">
	                <div class="thumb">
	                  <img src="file/${listProductHit.cate1 }/${listProductHit.cate2 }/${listProductHit.thumb2 }" width=230px height=230px alt="t1" />
	                </div>
	                <h2> ${listProductHit.proName }</h2>
	                <p> ${listProductHit.descript }</p>
	                <div class="org_price">
	                  <del> ${listProductHit.price }</del>
	                  <span> ${listProductHit.discount }%</span>
	                </div>
	                <div class="dis_price">
	                 <ins> ${(listProductHit.price/100)*(100-listProductHit.discount)  }</ins>
	                 <c:choose>
	                 <c:when test="${listProductHit.delivery eq 0 }">
	                 <span class="free">무료배송</span>
	                 </c:when>
	                 <c:otherwise>
	                 <span >배송비 ${listProductHit.delivery }</span>
	                 </c:otherwise>
	                 </c:choose>
	                </div>
	              </a>
	            </article>
	             <c:set var="num1" value="${num1+1}"></c:set>
					  	<c:if test="${num1 eq 9}">
                       		<c:set var="done_loop" value="true"/>
                    	</c:if>
	           </c:if>
	         </c:forEach>
         
          </section>
          <!-- 추천상품 영역 -->
          <section class="recommend">
            <h3><span>추천상품</span></h3>
            <c:set var="done_loop" value="false"/>
            <c:set var="num2" value="1"></c:set>
           	<c:forEach var="listProduct" items="${listProduct}">
           	 <c:if test="${done_loop ne true}">
	            <article>
	              <a href="/kmarket/product/view.do?&proNo=${listProduct.proNo}&cate1=${listProduct.cate1}&cate2=${listProduct.cate2}">
	                <div class="thumb">
	                  <img src="file/${listProduct.cate1 }/${listProduct.cate2 }/${listProduct.thumb2 }" width=230px height=230px alt="t1" />
	                </div>
	                <h2> ${listProduct.proName }</h2>
	                <p> ${listProduct.descript }</p>
	                <div class="org_price">
	                  <del> ${listProduct.price }</del>
	                  <span> ${listProduct.discount }%</span>
	                </div>
	                <div class="dis_price">
	                 <ins> ${(listProduct.price/100)*(100-listProduct.discount)  }</ins>
	                 <c:choose>
	                 <c:when test="${listProduct.delivery eq 0 }">
	                 <span class="free">무료배송</span>
	                 </c:when>
	                 <c:otherwise>
	                 <span >배송비 ${listProduct.delivery }</span>
	                 </c:otherwise>
	                 </c:choose>
	                </div>
	              </a>
	            </article>
	             <c:set var="num2" value="${num2+1}"></c:set>
					  	<c:if test="${num2 eq 9}">
                       		<c:set var="done_loop" value="true"/>
                    	</c:if>
	           </c:if>
	       </c:forEach>
 
          </section>
          <!-- 최신상품 영역 -->
          <section class="new">
            <h3><span>최신상품</span></h3>
            <c:set var="done_loop" value="false"/>
            <c:set var="num3" value="1"></c:set>
           	<c:forEach var="listProductNow" items="${listProductNow}">
           	 <c:if test="${done_loop ne true}">
	            <article>
	              <a href="/kmarket/product/view.do?&proNo=${listProductNow.proNo}&cate1=${listProductNow.cate1}&cate2=${listProductNow.cate2}">
	                <div class="thumb">
	                  <img src="file/${listProductNow.cate1 }/${listProductNow.cate2 }/${listProductNow.thumb2 }" width=230px height=230px alt="t1" />
	                </div>
	                <h2> ${listProductNow.proName }</h2>
	                <p> ${listProductNow.descript }</p>
	                <div class="org_price">
	                  <del> ${listProductNow.price }</del>
	                  <span> ${listProductNow.discount }%</span>
	                </div>
	                <div class="dis_price">
	                 <ins> ${(listProductNow.price/100)*(100-listProductNow.discount)  }</ins>
	                 <c:choose>
	                 <c:when test="${listProductNow.delivery eq 0 }">
	                 <span class="free">무료배송</span>
	                 </c:when>
	                 <c:otherwise>
	                 <span >배송비 ${listProductNow.delivery }</span>
	                 </c:otherwise>
	                 </c:choose>
	                </div>
	              </a>
	            </article>
	             <c:set var="num3" value="${num3+1}"></c:set>
					  	<c:if test="${num3 eq 9}">
                       		<c:set var="done_loop" value="true"/>
                    	</c:if>
	           </c:if>
	      </c:forEach>

          </section>
          
          <!-- 할인상품 영역 -->
          <section class="discount">
            <h3><span>할인상품</span></h3>
            <c:set var="done_loop" value="false"/>
            <c:set var="num4" value="1"></c:set>
           	<c:forEach var="listProductDiscount" items="${listProductDiscount}">
           	 <c:if test="${done_loop ne true}">
	            <article>
	              <a href="/kmarket/product/view.do?&proNo=${listProductDiscount.proNo}&cate1=${listProductDiscount.cate1}&cate2=${listProductDiscount.cate2}">
	                <div class="thumb">
	                  <img src="file/${listProductDiscount.cate1 }/${listProductDiscount.cate2 }/${listProductDiscount.thumb2 }" width=230px height=230px alt="t1" />
	                </div>
	                <h2> ${listProductDiscount.proName }</h2>
	                <p> ${listProductDiscount.descript }</p>
	                <div class="org_price">
	                  <del> ${listProductDiscount.price }</del>
	                  <span> ${listProductDiscount.discount }%</span>
	                </div>
	                <div class="dis_price">
	                 <ins> ${(listProductDiscount.price/100)*(100-listProductDiscount.discount)  }</ins>
	                 <c:choose>
	                 <c:when test="${listProductDiscount.delivery eq 0 }">
	                 <span class="free">무료배송</span>
	                 </c:when>
	                 <c:otherwise>
	                 <span >배송비 ${listProductDiscount.delivery }</span>
	                 </c:otherwise>
	                 </c:choose>
	                </div>
	              </a>
	            </article>
	             <c:set var="num4" value="${num4+1}"></c:set>
					  	<c:if test="${num4 eq 9}">
                       		<c:set var="done_loop" value="true"/>
                    	</c:if>
	           </c:if>
	            </c:forEach>
 
        </section>
      </main>
      <footer>
        <ul>
          <li><a href="#">회사소개</a></li>
          <li><a href="#">서비스이용약관</a></li>
          <li><a href="#">개인정보처리방침</a></li>
          <li><a href="#">전자금융거래약관</a></li>
        </ul>
        <div>
          <p><img src="./img/common/footer_logo.png" alt="로고" /></p>
          <p>
            <strong>(주)KMARKET</strong><br />
            부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br />
            대표이사 : 홍길동<br />
            사업자등록번호 : 220-81-83676 사업자정보확인<br />
            통신판매업신고 : 강남 10630호 Fax : 02-589-8842
          </p>
          <p>
            <strong>고객센터</strong><br />
            Tel : 1234-5678 (평일 09:00~18:00)<br />
            스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br />
            경기도 부천시 원미구 부일로 223(상동) 투나빌딩 6층<br />
            Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br />
          </p>
        </div>
      </footer>
      <button type="button" id="top">상단이동</button>
    </div>
  </body>
</html>