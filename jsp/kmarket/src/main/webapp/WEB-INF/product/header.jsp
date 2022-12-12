<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kmarket::list</title>
    <link rel="stylesheet" href="/kmarket/css/product.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
        
        $(function(){
            $('#clothes').mouseover(function(){
                $('.cate1').show();
            });

            $('#clothes').mouseout(function(){
                $('.cate1').hide();
            });

            $('#electric').mouseover(function(){
                $('.cate2').show();
            });

            $('#electric').mouseout(function(){
                $('.cate2').hide();
            });

            $('#food').mouseover(function(){
                $('.cate3').show();
            });

            $('#food').mouseout(function(){
                $('.cate3').hide();
            });

            $('#deco').mouseover(function(){
                $('.cate4').show();
            });

            $('#deco').mouseout(function(){
                $('.cate4').hide();
            });

        });

    </script>

</head>
<body>
    <div id="wrapper">
        <!-- 헤더 작업 -->
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