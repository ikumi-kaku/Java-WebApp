<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="model.UserInfoDto"      %>

<%--
-------------------------------------------------------------------------------------------------
■■■ファイル名：input_survey.jsp■■■
概要：JSP
詳細：HTML文書（回答入力画面）を出力する。
-------------------------------------------------------------------------------------------------
--%>

<%-- <%
//セッションからユーザーデータを取得
UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");
String userName  = userInfoOnSession.getUserName();
%>
 --%>

<html>
<head>
  <title>投稿入力</title>
  <link rel="stylesheet" href="CSS/main.css" type="text/css"/>
</head>
    <div class="whopper">
        <header>
            <ul>
                <li>
                    <a href="Login" class="login">マイページ</a>
                </li>
                <li class="new">
                    <a href="NewMember">
                        <p>
                            無料会員登録
                        </p>
                    </a>
                </li>
            </ul>
        </header>

        <section id="post">

            <div class="top">
                <h2 class="TL">
                    口コミを投稿する
                </h2>
                <p>下記の項目をご入力いただき、「投稿」ボタンを押してください。</p>    
            </div>

            <form action="SaveSurvey" method="post">
                <div class="form_wrap">
                    <!-- ニックネーム -->
                    <div class="item">
                        <p class="label">ニックネーム</p>
                        <div class="input_area">
                            <input type="text" name="NAME"  id="ID_NAME">
                        </div>
                    </div>
                    <!-- 店舗名 -->
                    <div class="item">
                        <p class="label">店舗名</p>
                        <div class="input_area">
                            <input type="text" name="STORE"  id="ID_STORE">
                        </div>
                    </div>
                    <!-- 訪問日時 -->
                   <div class="item">
                        <p class="label">訪問日時</p>
                        <div class="input_area">
                            <input type="datetime-local" name="TIME"  id="ID_TIME">
                        </div>
                    </div>
                  
                    <!-- 満足度 -->
                    <div class="item">
                        <p class="label">満足度</p>
                        <select name="SATISFACTION_LEVEL">
                            <option value="5">5点</option>
                            <option value="4">4点</option>
                            <option value="3">3点</option>
                            <option value="2">2点</option>
                            <option value="1">1点</option>
                        </select>
                    </div>
                    <!-- 滞在時間 -->
                    <div class="item">
                        <p class="label">滞在時間</p>
                        <select name="STAY_TIME">
                            <option value="9">〜10分</option>
                            <option value="8">11分〜15分</option>
                            <option value="7">16分〜20分</option>
                            <option value="6">21分〜25分</option>
                            <option value="5">26分〜30分</option>
                            <option value="4">31分〜40分</option>
                            <option value="3">41分〜50分</option>
                            <option value="2">51分〜60分</option>
                            <option value="1">61分〜</option>
                        </select>
                    </div>
                    <!-- 内容 -->
                    <div class="item">
                        <p class="label">内容</p>
                        <div class="input_area">
                            <textarea name="MESSAGE" id="ID_MESSAGE"></textarea>                        </div>
                    </div>
                </div>
                <input type="submit" value="投稿" id="ID_SUBMIT" class="all_btn">
            </form>
            
        </section>
        <footer></footer>
    </div>
</html>
