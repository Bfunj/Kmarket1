<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kmarket::cart</title>
    <link rel="stylesheet" href="/kmarket/css/product.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
        $(function(){
            $('input[name=order]').click(function(){
                location.href="order.do";
            });
        });


    </script>

</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <a href="#">로그인</a>
                    <a href="#">회원가입</a>
                    <a href="#">마이페이지</a>
                    <a href="#">장바구니</a>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="#"><img src="../img/product/header_logo.png" alt="로고"/></a>
                    <form action="#">
                        <input type="text" name="keyword"/>
                        <button><i class="fa fa-search"></i></button>
                    </form>                
                </div>
            </div>
            <div class="menu">
                <div>
                    <ul>
                        <li><a href="#">히트상품</a></li>
                        <li><a href="#">추천상품</a></li>
                        <li><a href="#">최신상품</a></li>
                        <li><a href="#">인기상품</a></li>
                        <li><a href="#">할인상품</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">쿠폰존</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">개인결제</a></li>
                        <li><a href="#">고객센터</a></li>
                        <li><a href="#">FAQ</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <main id="product">
            <aside>
                <ul class="category">
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li>
                        <a href="#" id="clothes"><i class="fas fa-tshirt"></i>패션</a>
                        <ol class="cate1">
                            <li><a href="#">남성의류</a></li>
                            <li><a href="#">여성의류</a></li>
                            <li><a href="#">잡화</a></li>
                            <li><a href="#">뷰티</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#" id="electric"><i class="fas fa-laptop"></i>가전·디지털</a>
                        <ol class="cate2">
                            <li><a href="#">노트북/PC</a></li>
                            <li><a href="#">가전</a></li>
                            <li><a href="#">휴대폰</a></li>
                            <li><a href="#">기타</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#" id="food"><i class="fas fa-utensils"></i>식품·생필품</a>
                        <ol class="cate3">
                            <li><a href="#">신선식품</a></li>
                            <li><a href="#">가공식품</a></li>
                            <li><a href="#">건강식품</a></li>
                            <li><a href="#">생필품</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#" id="deco"><i class="fas fa-home"></i>홈·문구·취미</a>
                        <ol class="cate4">
                            <li><a href="#">가구/DIY</a></li>
                            <li><a href="#">침구·커튼</a></li>
                            <li><a href="#">생활용품</a></li>
                            <li><a href="#">사무용품</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>

            <section class="cart">
                <nav>
                    <h1>장바구니</h1>
                    <p>HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong></p>
                </nav>

                <form action="#">
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
                        <tr>
                            <td><input type="checkbox" name="check" ></td>
                            <td>
                                <article>
                                    <a href="#"><img src="https://via.placeholder.com/80x80" alt=""></a>
                                    <div>
                                        <h2><a href="#">상품명</a></h2>
                                        <p>상품설명</p>
                                    </div>
                                </article>
                            </td>
                            <td>1</td>
                            <td>27,000</td>
                            <td>5%</td>
                            <td>270</td>
                            <td>무료배송</td>
                            <td>27,000</td>
                        </tr>
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
        <footer>
            <ul>
                <li><a href="#">회사소개</a></li>
                <li><a href="#">서비스이용약관</a></li>
                <li><a href="#">개인정보처리방침</a></li>
                <li><a href="#">전자금융거래약관</a></li>
            </ul>
            <div>
                <p><img src="../img/product/footer_logo.png" alt="로고"></p>
                <p>
                  <strong>(주)KMARKET</strong><br />
                  부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br />
                  대표이사 : 홍길동<br />
                  사업자등록번호 : 220-81-83676 사업자정보확인<br />
                  통신판매업신고 : 강남 10630호 Fax : 02-589-8842
                </p>
                <p>
                  <strong>고객센터</strong><br />
                  Tel : 1234-5678 (평일 09:00~18:00)<br />
                  스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br />
                  경기도 부천시 원미구 부일로 223(상동) 투나빌딩 6층<br />
                  Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br />
                </p>
            </div>              
        </footer>
        <button type="button" id="top">상단이동</button>
    </div>
</body>
</html>