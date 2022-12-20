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
                           
                             <li class="${cate eq 'qna_1' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_1">쿠폰/이벤트</a></li>
                             <li class="${cate eq 'qna_2' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_2">주문/결제</a></li>
                             <li class="${cate eq 'qna_3' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_3">배송</a></li>
                             <li class="${cate eq 'qna_4' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_4">취소/반품/교환</a></li>
                             <li class="${cate eq 'qna_5' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_5">여행/숙박/항공</a></li>
                             <li class="${cate eq 'qna_6' ? 'on' : 'off'}"><a href="./list.do?&cate=qna_6">안전거래</a></li>
                        </ul>
                    </aside>
                    <article>
                        <nav><h1>회원</h1>
                            <h2>회원관련 문의 내용입니다.</h2>
                        </nav>
                        <table>
                            <tbody>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.html">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                            </tbody>
                        </table>
                       
                        <div class="page">
                            <a href="#" class="prev">이전</a>
                            <a href="#" class="num on">1</a>
                            <a href="#" class="num">2</a>
                            <a href="#" class="num">3</a>
                            <a href="#" class="next">다음</a>
                        </div>
                        <a href="./write.do" class="btnWrite">문의하기</a>
                    </article>
                </section>
            </div>
        </section>
 <jsp:include page="../cs_footer.jsp"/>