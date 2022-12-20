<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../cs_header.jsp"/>
        <section id="cs">
            <div class="notice">
                <nav><div><p>홈<span>></span>공지사항</p></div></nav>
                <section class="list">
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
                        <nav><h1>전체</h1>
                            <h2>공지사항 전체 내용입니다.</h2>
                        </nav>
                        <table>
                            <tbody>
                                <tr><td><a href="../notice/view.do">[안내] 안내문1</a></td>
                                    <td>2022.11.21</td>
                                </tr>
                                <tr><td><a href="../notice/view.do">[안내] 안내문10</a></td>
                                    <td>2022.11.21</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="page">
                            <a href="#" class="prev">이전</a>
                            <a href="#" class="num on">1</a>
                            <a href="#" class="num">2</a>
                            <a href="#" class="num">3</a>
                            <a href="#" class="next">다음</a>
                        </div>
                    </article>
                </section>
            </div>
        </section>
     <jsp:include page="../cs_footer.jsp"/>