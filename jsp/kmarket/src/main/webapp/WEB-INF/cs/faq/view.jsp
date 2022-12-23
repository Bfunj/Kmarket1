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
            <div class="faq">
                <nav><div><p>홈<span>></span>자주묻는 질문</p></div></nav>
                <section class="view">
                    <aside><h2>자주묻는 질문</h2>
                        <ul>
                              <li class="${cate eq 'faq_1' ? 'on' : 'off'}"><a href="./list.do?&cate=faq_1">회원</a></li>      
                            <li class="${cate eq 'faq_2' ? 'on' : 'off'}"><a href="./list.do?&cate=faq_2">쿠폰/이벤트</a></li>
                            <li class="${cate eq 'faq_3' ? 'on' : 'off'}"><a href="./list.do?&cate=faq_3">주문/결제</a></li>
                            <li class="${cate eq 'faq_4' ? 'on' : 'off'}"><a href="./list.do?&cate=faq_4">배송</a></li>
                            <li class="${cate eq 'faq_5' ? 'on' : 'off'}"><a href="./list.do?&cate=faq_5">취소/반품/교환</a></li>
                            <li class="${cate eq 'faq_6' ? 'on' : 'off'}"><a href="./list.do?&cate=faq_6">여행/숙박/항공</a></li>
                            <li class="${cate eq 'faq_7' ? 'on' : 'off'}"><a href="./list.do?&cate=faq_7">안전거래</a></li>
                        </ul>
                    </aside>
                    <article>
                        <nav><h2 class="title"><span>Q.</span>
                            개인회원과 법인회원에 차이가 있나요?</h2>
                        </nav>
                        <div>
                            <p>개인회원에서 법인회원(사업자 회원)으로 전환은 불가하므로 법인회원(사업자 회원) 전환은 신규 가입으로 진행을 해야 합니다.
                            <br>
                            ※ 피싱 관련 피해신고<br><br>
                            ▶ 경찰청 사이버수사국 (국번없이)182 : http://cyberbureau.police.go.kr
                            <br>
                            ▶ KISA 인터넷침해대응센터 (국번없이)118 : http://www.krcert.or.kr
                            <br>
                            감사합니다.
                            </p>
                        </div>
                        <a href="./list.html" class="btnList">목록보기</a>
                    </article>
                </section>
            </div>
        </section>
<jsp:include page="../cs_footer.jsp"/>