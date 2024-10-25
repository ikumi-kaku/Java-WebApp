package controller;

import model.UserInfoDto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**----------------------------------------------------------------------*
 *■■■NewMenberクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（会員登録画面）を出力する。
 *----------------------------------------------------------------------**/
public class NewMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewMember() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

//		セッションからユーザーデータを取得
		HttpSession session           = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

//		ログイン状態によって表示画面を振り分ける
		if (userInfoOnSession == null) {
			//ログイン済：回答入力画面を出力

			//Viewにフォワード（フォワード先：new_member.jsp）
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/new_member.jsp");
			dispatch.forward(request, response);

		} else {
			//未ログイン：ログイン画面へ転送
			response.sendRedirect("ShowAllSurvey");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
