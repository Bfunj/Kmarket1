<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../cs_header.jsp"/>
        <section id="cs">
            <div class="qna">
                <nav><div><p>홈<span>></span>문의하기</p></div></nav>
                <section class="list">
                    <aside><h2>문의하기</h2>
           			 <ul>
                          <li class="${cate1 eq '10' ? 'on' : 'off'}"><a href="./list.do?&cate1=10">회원</a></li>
                          <li class="${cate1 eq '11' ? 'on' : 'off'}"><a href="./list.do?&cate1=11">쿠폰/이벤트주문/결제</a></li>
                          <li class="${cate1 eq '12' ? 'on' : 'off'}"><a href="./list.do?&cate1=12">주문/결제배송</a></li>
                          <li class="${cate1 eq '13' ? 'on' : 'off'}"><a href="./list.do?&cate1=13">배송취소/반품/교환</a></li>
                          <li class="${cate1 eq '14' ? 'on' : 'off'}"><a href="./list.do?&cate1=14">취소/반품/교환여행/숙박/항공</a></li>
                          <li class="${cate1 eq '15' ? 'on' : 'off'}"><a href="./list.do?&cate1=15">여행/숙박/항공안전거래</a></li>
                          <li class="${cate1 eq '16' ? 'on' : 'off'}"><a href="./list.do?&cate1=16">안전거래</a></li>
                      </ul>

                    </aside>
                    <article>
                        <nav><h1>회원</h1>
                            <h2>회원관련 문의 내용입니다.</h2>
                        </nav>
                        <table>
                            <tbody>
                                <tr><td><a href="./view.do">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.do">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.do">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.do">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.do">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
                                <tr><td><a href="./view.do">[가입]가입 문의내용</a></td><td>chh***</td><td>2022.11.21</td></tr>
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