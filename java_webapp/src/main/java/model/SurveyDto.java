package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**----------------------------------------------------------------------*
 *■■■SurveyDtoクラス■■■
 *概要：DTO（「input_post」テーブル）
 *----------------------------------------------------------------------**/
public class SurveyDto {

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private String    name ;                //名前
	private String    store ;                 //店名
	private Timestamp time ;                //来店時刻
	private int       satisfactionLevel ;   //満足度
	private int       stay ;                 //滞在時間
	private String    message ;             //メッセージ
	private Timestamp Writetime ;                //更新時刻

	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：name）
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	//getter/setter（対象フィールド：store）
	public String getStore() { return store; }
	public void setStore(String store) { this.store = store; }
	
	//getter/setter（対象フィールド：time）
	public Timestamp getTime() { return time; }
	public void setTime(Timestamp time) { this.time = time; }

	// Define getTimeAsString method to convert Timestamp to formatted striformatted string
	public String getTimeAsString() {
	    if (time != null) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        return sdf.format(time);
	    } else {
	        return "未回答";
	    }
	}

	//getter/setter（対象フィールド：satisfactionLevel）
	public int getSatisfactionLevel() { return satisfactionLevel; }
	public void setSatisfactionLevel(int satisfactionLevel) { this.satisfactionLevel = satisfactionLevel; }

	//getter/setter（対象フィールド：stay）
	public int getStay() { return stay; }
	public void setStay(int stay) { this.stay = stay; }
	
	//getter/setter（対象フィールド：message）
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }

	//getter/setter（対象フィールド：time）
	public Timestamp getWritetime() { return Writetime; }
	public void setWritetime(Timestamp Writetime) { this.Writetime = Writetime; }

}



