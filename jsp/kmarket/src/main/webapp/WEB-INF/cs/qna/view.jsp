
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../cs_header.jsp"/>
        <section id="cs">
            <div class="qna">
                <nav><div><p>홈<span>></span>문의하기</p></div></nav>
                <section class="view">
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
                        <nav>
                            <h2 class="title">[가입] 가입 문의내용</h2>
                            <span>chh**</span>
                            <span>2022-11-21</span>
                        </nav>
                       <div class="content">
                        <p>개인회원에서 법인회원(사업자 회원)으로 전환은 불가하므로 법인회원(사업자 회원) 전환은 신규 가입으로 진행을 해야 합니다.<br><br>
                        </p>
                        <p>
                            피싱 관련 피해신고 <br><br>
                            ▶ 경찰청 사이버수사국 (국번없이)182 : http://cyberbureau.police.go.kr<br>
                            ▶ KISA 인터넷침해대응센터 (국번없이)118 : http://www.krcert.or.kr<br>
                            감사합니다.<br>
                        </p>
                       </div>
                       <a href="../qna/list.html" class="btnList">목록보기</a>
                    </article>
                </section>
            </div>
        </section>
     <jsp:include page="../cs_footer.jsp"/>