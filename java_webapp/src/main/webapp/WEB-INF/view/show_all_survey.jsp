<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.SurveyDto" %>

<%
List<SurveyDto> list = (List<SurveyDto>) request.getAttribute("ALL_SURVEY_LIST");
%>

<html>
<head>
    <title>回答一覧</title>
    <link rel="stylesheet" href="CSS/main.css" type="text/css"/>
</head>
<body>

<div class="whopper">
    <header>
        <ul>
            <li>
                <a href="ExecuteLogout" class="login">ログアウト</a>
            </li>
            <li class="new">
                <a href="InputSurvey">
                    <p>口コミを投稿する</p>
                </a>
            </li>
        </ul>
    </header>

    <section id="list">
        <h2 class="TL">投稿一覧</h2>
        
                    <form action="ShowAllSurvey" method="get">
                <input type="hidden" name="sort" value="satisfaction">
                <button type="submit">評価の高い順に並べる</button>
                
            </form>
        

        <div class="all_list">
        <% for (SurveyDto dto : list) { %>
            <div class="list_box">
                
                    <div class="list_top">
                        <p class="list_TX"><%= replaceEscapeChar(dto.getStore()) %></p>
                    </div>
                    <div class="list_main">
                        <div class="main_top">
                            <div class="item satisfaction">
                                <p class="TX">満足度：</p>
                                <div class="level">
                                    <% switch (dto.getSatisfactionLevel()) {
                                        case 1: %>
                                            ★
                                            <% break;
                                        case 2: %>
                                            ★★
                                            <% break;
                                        case 3: %>
                                            ★★★
                                            <% break;
                                        case 4: %>
                                            ★★★★
                                            <% break;
                                        case 5: %>
                                            ★★★★★
                                            <% break;
                                    } %>
                                </div>
                            </div>
                            <div class="item stay_time">
                                <p class="TX">滞在時間：</p>
                                <div class="time">
                                    <% switch (dto.getStay()) {
                                        case 9: %>
                                            〜10分
                                            <% break;
                                        case 8: %>
                                            11分〜15分
                                            <% break;
                                        case 7: %>
                                            16分〜20分
                                            <% break;
                                        case 6: %>
                                            21分〜25分
                                            <% break;
                                        case 5: %>
                                            26分〜30分
                                            <% break;
                                        case 4: %>
                                            31分〜40分
                                            <% break;
                                        case 3: %>
                                            41分〜50分
                                            <% break;
                                        case 2: %>
                                            51分〜60分
                                            <% break;
                                        case 1: %>
                                            61分〜
                                            <% break;
                                    } %>
                                </div>
                            </div>
                            <div class="item visit_time">
							    <p class="TX">訪問日時：</p>
							    <div class="time"><%= replaceEscapeChar(dto.getTimeAsString()) %></div>
							</div>
                            
                        </div>
                        <div class="textbox">
                            <div class="user_name"><%= replaceEscapeChar(dto.getName()) %></div>
                            <div class="content"><%= replaceEscapeChar(dto.getMessage()) %></div>
                        </div>
                    </div>
                
               
            </div>
            <% } %>
        </div>
    </section>

    <footer></footer>
</div>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</body>
</html>

<%!
String replaceEscapeChar(String inputText) {
    if (inputText == null) {
        return ""; // もしくは他の適切なデフォルト値を返す
    }
    String charAfterEscape = inputText;
    charAfterEscape = charAfterEscape.replace("&", "&amp;");
    charAfterEscape = charAfterEscape.replace("<", "&lt;");
    charAfterEscape = charAfterEscape.replace(">", "&gt;");
    charAfterEscape = charAfterEscape.replace("\"", "&quot;");
    charAfterEscape = charAfterEscape.replace("'", "&#039;");

    return charAfterEscape;
}
%>
