package model;

/**----------------------------------------------------------------------*
 *■■■SaveMemberBLクラス■■■
 *概要：ビジネスロジック（会員データの登録）
 *----------------------------------------------------------------------**/
public class SaveMemberBL {

	/**----------------------------------------------------------------------*
	 *■executeInsertSurveyメソッド
	 *概要　：対象の会員データを登録する
	 *引数　：対象の会員トデータ（UserInfoDto型）
	 *戻り値：DB操作成功フラグ（true:成功/false:失敗）
	 *----------------------------------------------------------------------**/
	public boolean executeInsertMember(UserInfoDto dto) {

		boolean succesInsert = false ;  //DB操作成功フラグ（true:成功/false:失敗）

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------

		//DAOクラスをインスタンス化＆対象のユーザーデータを登録するよう依頼
		UserInfoDao dao = new UserInfoDao();
		succesInsert = dao.doInsertMember(dto);

		return succesInsert;
	}

}
