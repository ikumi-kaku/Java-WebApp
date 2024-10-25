package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SaveMemberBL;
import model.UserInfoDto;

/**----------------------------------------------------------------------*
 *■■■SaveMemberクラス■■■
 *概要：サーブレット
 *詳細：リクエスト（アンケートデータ）を「USER_INFO」テーブルに登録し、画面遷移する。
 *　　　＜遷移先＞登録成功：回答完了画面（finish.html）／登録失敗：エラー画面（error.html）
 *----------------------------------------------------------------------**/
public class SaveMember extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    public SaveMember() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        //レスポンス（出力データ）の文字コードを設定
        response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
        //リクエスト（受信データ）の文字コードを設定
        request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

//        //セッションからユーザーデータを取得
//        HttpSession session           = request.getSession();
//        UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");
//
//     //ログイン状態によって表示画面を振り分ける
//     if (userInfoOnSession != null) {
//         //ログイン済：登録処理＆結果画面への遷移を実施

            boolean succesFlg = true;  //成功フラグ（true:成功/false:失敗）

         //パラメータのバリデーションチェック
         if( !(validatePrmUserId(request.getParameter("USER_ID"))                &&
                 validatePrmPassword(request.getParameter("PASSWORD"))   ) ) {

             //バリデーションNGの場合
             succesFlg = false ;

         }else {

                //バリデーションOKの場合

                //リクエストパラメータを取得
                String userId              = request.getParameter("USER_ID");
                String userName              = request.getParameter("USER_NAME");//リクエストパラメータ（NAME）
                String passWord            = request.getParameter("PASSWORD");                //リクエストパラメータ（AGE）

                //会員データ（UserInfoDto型）の作成
                UserInfoDto dto = new UserInfoDto();
                dto.setUserId( userId );
                dto.setUserName( userName );
                dto.setPassWord( passWord );

                //アンケートデータをDBに登録
                SaveMemberBL logic = new SaveMemberBL();
               succesFlg          = logic.executeInsertMember(dto);  //成功フラグ（true:成功/false:失敗）

//         }

            //成功/失敗に応じて表示させる画面を振り分ける
            if (succesFlg) {

                //成功した場合、回答完了画面（finish.html）を表示する
                response.sendRedirect("htmls/comp.html");

            } else {

                //失敗した場合、エラー画面（error.html）を表示する
                response.sendRedirect("htmls/error.html");

            }

//     } else {
//         //未ログイン：ログイン画面へ転送
//         response.sendRedirect("Login");
     }
    }

    /**----------------------------------------------------------------------*
     *■■■validatePrmNameクラス■■■
     *概要：バリデーションチェック
     *詳細：入力値（名前）の検証を行う
     *----------------------------------------------------------------------**/
    private boolean validatePrmUserId( String pr) {

        boolean validateResult = true ;

        //入力値がnullまたは空白の場合はエラーとする
        if( pr == null || pr.equals("") ) {
            validateResult = false ;
        }

        return validateResult ;
    }

    /**----------------------------------------------------------------------*
     *■■■validatePrmPasswordクラス■■■
     *概要：バリデーションチェック
     *詳細：入力値（パスワード）の検証を行う
     *----------------------------------------------------------------------**/
  private boolean validatePrmPassword( String pr) {

      boolean validateResult = true ;

      //入力値がnullまたは正の数以外の場合はエラーとする
      if( pr == null || pr.equals("") ) {
          validateResult = false ;
      }

      return validateResult ;
  }

}

