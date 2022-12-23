<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../cs_header.jsp"/>
        <section id="cs">
            <div class="notice">
                <nav><div><p>홈<span>></span>공지사항</p></div></nav>
                <section class="view">
                    <aside><h2>공지사항</h2>
                            <ul>
                           
               	<li class="${cate eq 'notice_1' ? 'on' : 'off'}"><a href="./list.do?&cate=notice_1">전체</a></li>
               	<li class="${cate eq 'notice_2' ? 'on' : 'off'}"><a href="./list.do?&cate=notice_2">고객서비스</a></li>
               	<li class="${cate eq 'notice_3' ? 'on' : 'off'}"><a href="./list.do?&cate=notice_3">안전거래</a></li>
               	<li class="${cate eq 'notice_4' ? 'on' : 'off'}"><a href="./list.do?&cate=notice_4">위해상품</a></li>
               	<li class="${cate eq 'notice_5' ? 'on' : 'off'}"><a href="./list.do?&cate=notice_5">이벤트당첨</a></li>

                        </ul>
                    </aside>
                    <article>
                        <nav>
                            <h2 class="title">[안내] 해외결제 사칭 문자 주의</h2>
                            <span class="date">2022.11.20</span>
                        </nav>
                       <div class="content">
                        <p>안녕하세요. G마켓 입니다.<br>
                        G마켓 해외직구를 사칭하는 피싱 문자가 최근 다시 신고되고 있어 주의 안내드립니다.<br>
                        아래와 같이 G마켓 해외직구..<br><br>
                        </p>
                        <p>
                            피싱 관련 피해신고 <br><br>
                            ▶ 경찰청 사이버수사국 (국번없이)182 : http://cyberbureau.police.go.kr<br>
                            ▶ KISA 인터넷침해대응센터 (국번없이)118 : http://www.krcert.or.kr<br>
                            감사합니다.<br>
                        </p>
                       </div>
                       <a href="../notice/list.do" class="btnList">목록보기</a>
                    </article>
                </section>
            </div>
        </section>
<jsp:include page="../cs_footer.jsp"/>