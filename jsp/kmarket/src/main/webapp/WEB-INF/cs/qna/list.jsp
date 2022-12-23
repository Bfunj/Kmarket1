<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../cs_header.jsp"/>
<script>
     $(function(){
            $('.select > li').mouseover(function(){
                $(this).css('background','#fff7f2');
            });
            $('.list li').mouseout(function(){
                $(this).css('background','white');
            });
        
            });
</script>

        <section id="cs">
            <div class="qna">
                <nav><div><p>홈<span>></span>문의하기</p></div></nav>
                <section class="list">
                    <aside><h2>문의하기</h2>
            			<ul>
                             <li class="${cate eq 'qna_1' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_1">회원</a></li>
                             <li class="${cate eq 'qna_2' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_2">쿠폰/이벤트주문/결제</a></li>
                             <li class="${cate eq 'qna_3' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_3">주문/결제배송</a></li>
                             <li class="${cate eq 'qna_4' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_4">배송취소/반품/교환</a></li>
                             <li class="${cate eq 'qna_5' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_5">취소/반품/교환여행/숙박/항공</a></li>
                             <li class="${cate eq 'qna_6' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_6">여행/숙박/항공안전거래</a></li>
                             <li class="${cate eq 'qna_7' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_7">안전거래</a></li>
                        </ul>
                    </aside>
                    <article>
                        <nav><h1>${cate}</h1>
                            <h2>${cate} 문의 내용입니다.</h2>
                        </nav>
                        <table>
                            <tbody>
                            	<c:forEach var="article" items="${articles}">
	                                <tr>
	                                	<td>
	                                		<a href="./view.html">[가입]가입 문의내용</a>
	                                	</td>
	                                	<td>${sessUser.uid.substring(0,3)}***</td>
	                                	<td>2022.11.21</td>
	                                </tr>
                              	</c:forEach>
                            </tbody>
                        </table>
                       
                        <div class="page">
                           	<c:if test="${pageGroupStart gt 1}">
                        		 <a href="/kmarket/cs/qna/list.do?pg=${pageGroupStart-1}" class="prev">이전</a>
                        	</c:if>
                            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
                            	<a href="/kmarket/cs/qna/list.do?pg=${i}" class="num ${currentPage eq i? 'current':'off'}">${i}</a>
                            </c:forEach>
                            <c:if test="${pageGroupStart lt lastPageNum}">
                            	<a href="/kmarket/cs/qna/list.do?pg=${pageGroupStart+1}" class="next">다음</a>
                            </c:if>
                        </div>
                        <a href="./write.do" class="btnWrite">문의하기</a>
                    </article>
                </section>
            </div>
        </section>
 <jsp:include page="../cs_footer.jsp"/>