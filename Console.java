public class Console{

/**
	*序章を表示する
	*/
	static void putJyosyou(){
	put("魔王が世界を滅ぼそうとしています");
	putStatus();
	}
	public static void putStatus(){
	put("________________________________");
	put(getStatusString());
	put("________________________________");
	}
	
    public static String getStatusString(){
    	return(Player.name + "　Lv" + Player.lv + "　HP" + Player.hp + "　" + Player.gold + "G");
    }

	/**
	*ゲームオーバー画面を表示しまうs
	*/
	static void putGameOver(){
	put(Player.name + "は魔王に敗れました");
	put("GAME OVER!!");
	}

	/**
	*ゲームクリアー画面を表示します。
	*/
	static void putGameClare(){
		String str = Player.name + "は魔王を倒しました";
		put(str);
		put("はlv" + Player.lv);
		if(Player.lv > 80){
			put("なので余裕で倒せました");
		}else if(Player.lv > 50){
			put("なので倒せました");
		}else{
			put("なので苦戦しました");
		}
			put("GAME CLEAR!!");

	}

	/**
	*引数で指定された文字列を表示します
	*
	* @param str 表示対象の文字列
	*/
	static void put(String str){
		System.out.println(str);
	}

}