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
     
     
     $(document).ready(function(){
 		$('select[name=category1]').change(function(){
 			let cate1 = $(this).val();
 			//alert(cate1);
 			let jsonData = {'cate1': cate1};
 			
 			$.ajax({
 				url :'/kmarket/cs/qna/writeCate.do',
 				type : 'POST',
 				data : jsonData,
 				dataType : 'json',
 				success : function(data){
 					//화면처리
 					$('#cate2*').empty("<option></option>");
 					$('select[name=category2]').append("<option value='cate0'>2차 분류 선택</option>");
 					for (let cate of data){
 						$('select[name=category2]').append("<option value='"+cate.cate2+"'>"+cate.c2Name+"</option>");
 					
 					}	
 				} 
 			});
 		});
 	});//cate1 선택에 따른 cate2 출력 완료
     
</script>

        <section id="cs">
            <div class="qna">
                <nav><div><p>홈<span>></span>문의하기</p></div></nav>
                <section class="write">
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
                      <form action="/kmarket/cs/qna/write.do" method="post">
                      <input type="hidden" name="uid" value="${sessUser.uid}"/>
                        <table>
                            <tbody>
                                <tr>
                                    <td>문의유형</td>
                                    <td>
                                       <select name="category1">
                                            <option value="">1차 분류 선택</option>
                                            <c:forEach var="cate" items="${cate1s }">
                                             <option name="cate1" value="${cate.cate1 }">${cate.c1Name }</option>
                                            </c:forEach> 
                                        </select>
                                        
                                        <select name="category2" id="cate2">
                                            <option value="cate0">2차 분류 선택</option>                
                                             <option value=""></option>
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