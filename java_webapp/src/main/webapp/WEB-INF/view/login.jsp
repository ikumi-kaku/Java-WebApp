<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%--
-------------------------------------------------------------------------------------------------
■■■ファイル名：login.jsp■■■
概要：JSP
詳細：HTML文書（ログイン画面）を出力する。
-------------------------------------------------------------------------------------------------
--%>

<html>
<head>
  <title>ログイン画面</title>
<link rel="stylesheet" href="CSS/main.css" type="text/css"/>
  
</head>
<body>
    <div class="whopper">
        <header></header>
        <section id="login">
            <h2 class="TL">ログイン</h2>
            <form action="ExecuteLogin" method="post">
                <div class="form_wrap">
                    
                    <!-- ユーザーID -->
                    <div class="item">
                        <p class="label">ユーザーID</p>
                        <div class="input_area">
                            <input type="text" name="USER_ID"  id="ID_USER_ID">
                        </div>
                    </div>                    
                    <!-- パスワード -->
                    <div class="item">
                        <p class="label">パスワード</p>
                        <div class="input_area">
                            <input type="password" name="PASSWORD"  id="ID_PASSWORD">
                        </div>
                    </div>
                </div>
                <input type="submit" value="ログイン" id="ID_SUBMIT" class="all_btn">
            </form>
           
            <p class="under_TX">
                会員登録されていない方は<a href="NewMember" class="link">こちら</a>から新規会員登録
            </p>
        </section>
        <footer></footer>
    </div>
    <script type="text/javascript" src="js/login.js"></script>
	<script>

</script>

</body>

</html>
