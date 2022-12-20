<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./header.jsp"></jsp:include>      
 
	<main id="product">
            <aside>
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
              	 		<li><a href="/kmarket/product/list.do?&cate1=${cate2List.cate1}&cate2=${cate2List.cate2}&cate=list_1&pg=1">${cate2List.c2Name }</a></li>            	 		
              	 	</c:if>          
                </c:forEach>
              </ol>
            </li>
            </c:forEach>

               </ul>
            </aside>

            <section class="cart">
                <nav>
                    <h1>장바구니</h1>
                    <p>HOME > <strong>장바구니</strong></p>
                </nav>

                <form action="/kmarket/product/cart.do">
                <input type="hidden" name="uid" value=${sessUser.uid }>
                    <table border="0">
                        <tr>
                            <th><input type="checkbox" name="all" ></th>
                            <th>상품명</th>
                            <th>총수량</th>
                            <th>판매가</th>
                            <th>할인</th>
                            <th>포인트</th>
                            <th>배송비</th>
                            <th>소계</th>
                        </tr>
                        <tr class="empty">
                            <td colspan="7">장바구니에 상품이 없습니다.</td>
                        </tr>
                        <c:forEach var="cart" items="${carts}">
                        <tr>
                            <td><input type="checkbox" name="check" ></td>
                            <td>
                                <article>
                                    <a href="#" ><img src="../file/"width=100px height=100px alt="썸네일"></a>
                                    <div>
                                        <h2><a href="">${cart.proName }</a></h2>
                                        <p>${cart.descript }</p>
                                    </div>
                                </article>
                            </td>
                            <td>${cart.count }</td>
                            <td><fmt:formatNumber value="${cart.price }" pattern="#,###" /></td>
                            <td>${cart.discount }</td>
                            <td>${cart.point }</td>
                            <td><fmt:formatNumber value="${cart.delivery }" pattern="#,###" /></td>
                            <td><fmt:formatNumber value="${cart.total }" pattern="#,###" /></td>
                        </tr>
                        </c:forEach>
                    </table>
                    <input type="button" name="del" value="선택삭제">

                    <!-- 장바구니 전체합계 -->
                    <div class="total">
                        <h2>전체합계</h2>
                        <table border="0">
                            <tr>
                                <td>상품수</td>
                                <td>1</td>
                              </tr>
                              <tr>
                                <td>상품금액</td>
                                <td>27,000</td>
                              </tr>
                              <tr>
                                <td>할인금액</td>
                                <td>-1,000</td>
                              </tr>
                              <tr>
                                <td>배송비</td>
                                <td>0</td>
                              </tr>              
                              <tr>
                                <td>포인트</td>
                                <td>260</td>
                              </tr>
                              <tr>
                                <td>전체주문금액</td>
                                <td>26,000</td>
                              </tr>
                        </table>
                        <input type="submit" name="order" id="order" value="주문하기">
                    </div>
                </form>
            </section>
        </main>
<jsp:include page="./footer.jsp"></jsp:include>