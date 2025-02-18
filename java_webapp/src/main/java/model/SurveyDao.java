package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**----------------------------------------------------------------------*
 *■■■SurveyDaoクラス■■■
 *概要：DAO（「INPUT_POST」テーブル）
 *----------------------------------------------------------------------**/
public class SurveyDao {
	//-------------------------------------------
	//データベースへの接続情報
	//-------------------------------------------

	//JDBCドライバの相対パス
	//※バージョンによって変わる可能性があります（MySQL5系の場合は「com.mysql.jdbc.Driver」）
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	//接続先のデータベース
	//※データベース名が「test_db」でない場合は該当の箇所を変更してください
	String JDBC_URL    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=Japan&useSSL=false";

	//接続するユーザー名
	//※ユーザ���が「test_user」でない場合は該当の箇所を変更してください
	String USER_ID     = "test_user";

	//接続するユーザーのパスワード
	//※パスワードが「test_pass」でない場合は該当の箇所を変更してください
	String USER_PASS   = "test_pass";


	//----------------------------------------------------------------
	//メソッド
	//----------------------------------------------------------------

	/**----------------------------------------------------------------------*
	 *■doInsertメソッド
	 *概要　：「INPUT_POST」テーブルに対象のアンケートデータを挿入する
	 *引数　：対象のアンケートデータ（SurveyDto型）
	 *戻り値：実行結果（真：成功、偽：例外発生）
	 *----------------------------------------------------------------------**/
	public boolean doInsert(SurveyDto dto) {

		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//-------------------------------------------
		//SQL発行
		//-------------------------------------------

		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数

		//実行結果（真：成功、偽：例外発生）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		boolean isSuccess = true ;

		try {

			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			//-------------------------------------------
			//トランザクションの開始
			//-------------------------------------------
			//オートコミットをオフにする（トランザクション開始）
			con.setAutoCommit(false);

			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			//発行するSQL文の生成（INSERT）
			StringBuffer buf = new StringBuffer();
			buf.append("INSERT INTO INPUT_POST (  ");
			buf.append("  NAME,               ");
			buf.append("  STORE,               ");
			buf.append("  TIME,                ");
			buf.append("  SATISFACTION_LEVEL, ");
			buf.append("  STAY,               ");
			buf.append("  MESSAGE,            ");
			buf.append("  WRITETIME           ");
			buf.append(") VALUES (            ");
			buf.append("  ?,                  ");
			buf.append("  ?,                  ");
			buf.append("  ?,                  ");
			buf.append("  ?,                  ");
			buf.append("  ?,                   ");
			buf.append("  ?,                  ");
			buf.append("  ?                   ");
			buf.append(")                     ");

			//PreparedStatementオブジェクトを生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());

			//パラメータをセット
			ps.setString(    1, dto.getName()              ); //第1パラメータ：更新データ（名前）
			ps.setString(    2, dto.getStore()               ); //第2パラメータ：更新データ（店名）
			ps.setTimestamp( 3, dto.getTime()               ); // 第3パラメータ：更新データ（時間）
			ps.setInt(       4, dto.getSatisfactionLevel() ); //第3パラメータ：更新データ（満足度）
			ps.setInt(       5, dto.getStay()               ); //第4パラメータ：更新データ（滞在時間）
			ps.setString(    6, dto.getMessage()           ); //第5パラメータ：更新データ（メッセージ）
			ps.setTimestamp( 7, dto.getWritetime()              ); //第6パラメータ：更新データ（更新時刻）

			//SQL文の実行
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			//実行結果を例外発生として更新
			isSuccess = false ;

		} finally {
			//-------------------------------------------
			//トランザクションの終了
			//-------------------------------------------
			if(isSuccess){
				//明示的にコミットを実施
				try {
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}else{
				//明示的にロールバックを実施
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//-------------------------------------------
			//接続の解除
			//-------------------------------------------

			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		//実行結果を返す
		return isSuccess;
	}




	/**----------------------------------------------------------------------*
	 *■doSelectメソッド
	 *概要　：「INPUT_POST」テーブルのデータを全件抽出する
	 *引数　：なし
	 *戻り値：抽出結果（DTOリスト）
	 *----------------------------------------------------------------------**/
	public List<SurveyDto> doSelect() {

		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//-------------------------------------------
		//SQL発行
		//-------------------------------------------

		//JDBCの接続に使用するオブジェクトを宣言
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数

		//抽出結果格納用DTOリスト
		List<SurveyDto> dtoList = new ArrayList<SurveyDto>();

		try {

			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append("SELECT                ");
			buf.append("  NAME,               ");
			buf.append("  STORE,              ");
			buf.append("  SATISFACTION_LEVEL, ");
			buf.append("  STAY,               ");
			buf.append("  MESSAGE,            ");
			buf.append("  WRITETIME,          ");
			buf.append("  TIME                "); // Add TIME column to the query
			buf.append("FROM                  ");
			buf.append("  INPUT_POST          ");
			buf.append("ORDER BY              ");
			buf.append("  WRITETIME DESC      ");

			

			ps = con.prepareStatement(buf.toString());
			rs = ps.executeQuery();

			//ResultSetオブジェクトからDTOリストに格納
			while (rs.next()) {
				SurveyDto dto = new SurveyDto();
				dto.setName(              rs.getString(    "NAME"               ) );
				dto.setStore(             rs.getString(    "STORE"              ) );
				dto.setSatisfactionLevel( rs.getInt(       "SATISFACTION_LEVEL" ) );
				dto.setStay(              rs.getInt(       "STAY"               ) );
				dto.setMessage(           rs.getString(    "MESSAGE"            ) );
				dto.setWritetime(		  rs.getTimestamp( "WRITETIME"          ) );
				dto.setTime(              rs.getTimestamp( "TIME"               ) ); // Get TIME column from ResultSet
				dtoList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//-------------------------------------------
			//接続の解除
			//-------------------------------------------

			//ResultSetオブジェクトの接続解除
			if (rs != null) {    //接続が確認できている場合のみ実施
				try {
					rs.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		//抽出結果を返す
		return dtoList;
	}

	/**----------------------------------------------------------------------*
	 *■doSelectSortedByTimeメソッド
	 *概要　：「INPUT_POST」テーブルのデータを稿時間順に抽出する
	 *引数　：なし
	 *戻り値：抽出結果（DTOリスト）
	 *----------------------------------------------------------------------**/
	public List<SurveyDto> doSelectSortedBySatisfactionLevel() {
		List<SurveyDto> dtoList = new ArrayList<SurveyDto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			StringBuffer buf = new StringBuffer();
			buf.append("SELECT * FROM INPUT_POST ORDER BY SATISFACTION_LEVEL DESC");
			ps = con.prepareStatement(buf.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				SurveyDto dto = new SurveyDto();
				dto.setName(rs.getString("NAME"));
				dto.setStore(rs.getString("STORE"));
				dto.setTime(rs.getTimestamp("TIME"));
				dto.setSatisfactionLevel(rs.getInt("SATISFACTION_LEVEL"));
				dto.setStay(rs.getInt("STAY"));
				dto.setMessage(rs.getString("MESSAGE"));
				dto.setWritetime(rs.getTimestamp("WRITETIME"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return dtoList;
	}

}



