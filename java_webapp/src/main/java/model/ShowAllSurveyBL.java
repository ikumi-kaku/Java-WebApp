package model;

import java.util.List;

/**----------------------------------------------------------------------*
 *■■■ShowAllSurveyBLクラス■■■
 *概要：ビジネスロジック（アンケートデータの全件表示）
 *----------------------------------------------------------------------**/
public class ShowAllSurveyBL {

	/**----------------------------------------------------------------------*
	 *■executeSelectSurveyメソッド
	 *概要　：アンケートデータを全件抽出する
	 *引数　：なし
	 *戻り値：抽出結果（DTOリスト）
	 *----------------------------------------------------------------------**/
	public List<SurveyDto> executeSelectSurvey() {

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------

		//DAOクラスをインスタンス化＆対象のユーザーデータを登録するよう依頼
		SurveyDao dao = new SurveyDao();
		List<SurveyDto> dtoList= dao.doSelect();

		return dtoList;
	}



	/**----------------------------------------------------------------------*
	 *■executeSelectSurveySortedBySatisfactionLevelメソッド
	 *概要　：アンケートデータを満足度順にソートして全件抽出する
	 *引数　：なし
	 *戻り値：抽出結果（DTOリスト）
	 *----------------------------------------------------------------------**/
	public List<SurveyDto> executeSelectSurveySortedBySatisfactionLevel() {
		SurveyDao dao = new SurveyDao();
		return dao.doSelectSortedBySatisfactionLevel();  // 新しいDAOメソッド
	}
	
}




