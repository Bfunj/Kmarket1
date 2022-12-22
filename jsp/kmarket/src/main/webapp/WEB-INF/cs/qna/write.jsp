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
                <section class="write">
                    <aside><h2>문의하기</h2>
                        <ul>
                            <li class="on"><a href="#">회원</a></li>
                            <li><a href="#">쿠폰/이벤트</a></li>
                            <li><a href="#">주문/결제</a></li>
                            <li><a href="#">배송</a></li>
                            <li><a href="#">취소/반품/교환</a></li>
                            <li><a href="#">여행/숙박/항공</a></li>
                            <li><a href="#">안전거래</a></li>
                        </ul>
                    </aside>
                    <article>
                      <form action="/kmarket/cs/qna/write.do" method="post">
                      <input type="hidden" name="uid" value="${sessUser.uid}"/>
                        <table>
                            <tbody>
                                <tr>
                                    <td>문의유형</td>
                                    <td>
                                        <select name="cate" ><option value="0">선택</option>
                                            <option value="qna_1">가입</option>
                                            <option value="qna_2">탈퇴</option>
                                            <option value="qna_3">회원정보</option>
                                            <option value="qna_4">로그인</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>문의제목</td>
                                    <td><input type="text" name="title" placeholder="제목을 입력하세요."></td>
                                </tr>
                                <tr>
                                    <td>문의내용</td>
                                    <td><textarea name="content" placeholder="내용을 입력하세요."></textarea></td>
                                </tr>
                            </tbody>
                        </table>
                        <div>
                            <a href="./list.do" class="btnList">취소하기</a>
                            <input type="submit" class="btnSubmit" value="등록하기">
                        </div>
                      </form>
                    </article>
                </section>
            </div>
        </section>
       <jsp:include page="../cs_footer.jsp"/>