<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./header.jsp"></jsp:include>

        <!-- 메인 작업 -->
        <main id="product">
            <aside>
          <!-- 카테고리 -->
          <ul class="category">
            <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>  
            <c:forEach var="cate1List" items="${cate1List}">

            	 <li>
              <a href="#">
              	<i class="fas ">
              	</i>${cate1List.c1Name}<iclass="fas fa-angle-right"></i>
              </a>
              <ol>
              	 <c:forEach var="cate2List" items="${cate2List}">
              	 	<c:if test="${cate1List.cate1 eq cate2List.cate1 }">
              	 		<li><a href="/kmarket/product/list.do?&cate1=${cate2List.cate1}&cate2=${cate2List.cate2}">${cate2List.c2Name }</a></li>            	 		
              	 	</c:if>          
                </c:forEach>
              </ol>
            </li>
            </c:forEach>
            
          </ul>
          <!-- 카테고리 완료 -->
            </aside>

            <section class="list">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>상품목록</h1>
                    <c:forEach var="cate1Name" items="${cate1Name}">
                     <c:forEach var="cate2Name" items="${cate2Name}">
                    	<p>HOME > <span> ${cate1Name.c1Name}</span> > <strong>   ${cate2Name.c2Name}      </strong></p>
               		</c:forEach>
               		</c:forEach>
                </nav>

                <!-- 정렬 메뉴 -->
                <ul class="sort">
                    <li><a href="#" class="on">판매많은순</a></li>
                    <li><a href="#">낮은가격순</a></li>
                    <li><a href="#">높은가격순</a></li>
                    <li><a href="#">평점높은순</a></li>
                    <li><a href="#">후기많은순</a></li>
                    <li><a href="#">최근등록순</a></li>
                </ul>

                <table>
                	
                
                      <c:forEach var="ListProduct" items="${ListProduct}">
                    <tr>
                        <td><a href="/kmarket/product/view.do?&proNo=${ListProduct.proNo }&cate1=${ListProduct.cate1}&cate2=${ListProduct.cate2}" class="thumb"><img src="../file/${ListProduct.cate1 }/${ListProduct.cate2 }/${ListProduct.thumb1 }" width=120px height=120px alt="item1"/></a></td>
                        <td>
                          <h3 class="name">${ListProduct.proName}</h3>
                          <a href="/kmarket/product/view.do?&proNo=${ListProduct.proNo }&cate1=${ListProduct.cate1}&cate2=${ListProduct.cate2}" class="desc">${ListProduct.descript}</a>
                        </td>
                        <td>
                          <ul>
                            <li><ins class="dis-price">${(ListProduct.price/100)*(100-ListProduct.discount)  }원</ins></li>
                            <li>
                              <del class="org-price">${ListProduct.price }원</del>
                              <span class="discount">${ListProduct.discount }%</span>
                            </li>
                            <li><span class="free-delivery">무료배송</span></li>
                          </ul>
                        </td>
                        <td>
                          <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${ListProduct.seller }</h4>
                          <h5 class="badge power">${ListProduct.score }</h5>
                          <h6 class="rating star4">상품평</h6>
                        </td>
                      </tr>
                      </c:forEach>
                </table>

            <!-- 상품목록 페이지번호 -->
              <div class="paging">
                <span class="prev">
                  <a href="#"><&nbsp;이전</a>
                </span>
                <span class="num">
                  <a href="#" class="on">1</a>
                  <a href="#">2</a>
                  <a href="#">3</a>
                </span>
                <span class="next">
                  <a href="#">다음&nbsp;></a>
                </span>
              </div>

            </section>
        </main>
<jsp:include page="./footer.jsp"></jsp:include>
