<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp"></jsp:include>

        <!-- 메인 작업 -->
        <main id="product">
            <aside>
                <ul class="category">
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li>
                        <a href="#" id="clothes"><i class="fas fa-tshirt"></i>의류</a>
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

            <section class="list">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>상품목록</h1>
                    <p>HOME > <span>패션·의류·뷰티</span> > <strong>남성의류</strong></p>
                </nav>

                <!-- 정렬 메뉴 -->
                <ul class="sort">
                    <li><a href="#" class="on">판매많은순</a></li>
                    <li><a href="#">낮은가격순</a></li>
                    <li><a href="#">높은가격순</a></li>
                    <li><a href="#">평점높은순</a></li>
                    <li><a href="#">후기많은순</a></li>
                    <li><a href="#">최근등록순</a></li>
                </ul>

                <table>
                    <tr>
                        <td><a href="./view.html" class="thumb"><img src="https://via.placeholder.com/120x120" alt="상품이미지"/></a></td>
                        <td>
                          <h3 class="name">상품명</h3>
                          <a href="./view.html" class="desc">상품설명</a>
                        </td>
                        <td>
                          <ul>
                            <li><ins class="dis-price">27,000원</ins></li>
                            <li>
                              <del class="org-price">30,000원</del>
                              <span class="discount">10%</span>
                            </li>
                            <li><span class="free-delivery">무료배송</span></li>
                          </ul>
                        </td>
                        <td>
                          <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자</h4>
                          <h5 class="badge power">판매자등급</h5>
                          <h6 class="rating star4">상품평</h6>
                        </td>
                      </tr>
                </table>

            <!-- 상품목록 페이지번호 -->
              <div class="paging">
                <span class="prev">
                  <a href="#"><&nbsp;이전</a>
                </span>
                <span class="num">
                  <a href="#" class="on">1</a>
                  <a href="#">2</a>
                  <a href="#">3</a>
                </span>
                <span class="next">
                  <a href="#">다음&nbsp;></a>
                </span>
              </div>

            </section>
        </main>
<jsp:include page="./footer.jsp"></jsp:include>
