<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
  <head>
    <title>新規会員登録</title>
    <link rel="stylesheet" href="CSS/main.css" type="text/css"/>
  </head>
<body>

    <div class="whopper">

        <header>
        </header>

        <section id="new">

            <h2 class="TL">新規会員登録</h2>

            <form action="SaveMember" method="post">
                <div class="form_wrap">
                    <!-- ユーザー名 -->
                    <div class="item">
                        <p class="label">ユーザー名</p>
                        <div class="input_area">
                            <input type="text" name="USER_NAME"  id="NEW_ID_NAME">
                        </div>
                    </div>

                    <!-- ユーザーID -->
                    <div class="item">
                        <p class="label">ユーザーID</p>
                        <div class="input_area">
                            <input type="text" name="USER_ID"  id="NEW_USER_ID">
                        </div>
                    </div>
                    
                    <!-- パスワード -->
                    <div class="item">
                        <p class="label">パスワード</p>
                        <div class="input_area">
                            <input type="password" name="PASSWORD"  id="NEW_ID_PASS">
                        </div>
                    </div>

                </div>
                <input type="submit" value="登録" id="NEW_SUBMIT" class="all_btn">
            </form>

            <p class="under_TX">
                会員の方は<a href="Login" class="link">こちら</a>からログイン
            </p>

        </section>

        <footer></footer>




    </div>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="js/input_survey.js"></script>




</body>
</html>