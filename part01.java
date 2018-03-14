public class part01
{
	

	public static void main (String[] args) throws java.io.IOException{

		Console.putJyosyou();         	//序章を表示

		putCommand();           //コマンドを表示

		if(Player.hp == 0){            //main関数内のreturnなので終了の処理になる
			return;
		}

		//魔王を倒しにいく
		if(Player.lv < 40){			//レベルが40未満の場合
			Console.putGameOver();   	//ゲームオーバー画面を表示
		}else{               	//レベルが40以上の場合
			Console.putGameClare();  	//ゲームクリアの画面を表示
		}
	}

	public static void putCommand() throws java.io.IOException{
		Console.put("1. 魔王を倒しにいく");
		Console.put("2. 修行する");
		Console.put("3. 宿屋に泊まる");
		switch(inputCommand()){
			case '1':{
				Console.put("魔王が現れた");
				break;
			}
			case '2':{	
				syugyou();
				break;
			}
			case '3':{
				if(Player.gold >= 9.95){
					Player.hp = Player.lv;
					Player.gold -= 9.95;
				}
				Console.putStatus();
				putCommand();
				break;
			}
		}
	}

    /**
	*修行する
	*/
	static void syugyou() throws java.io.IOException{
	//敵出現
	java.util.Random r = new java.util.Random();
	int e = r.nextInt(3) + 1;	//敵の数
	Console.put("敵が" + e + "匹、現れた");
	String m = " ( ゜Д゜)";
	String s = "";

	for(int i = 0; i < e; i = i + 1){
		s = s + m;
	}

	Console.put(s);
/*
	int i = 0;
	if(i < e){ s = s + m; i = i + 1; }
	if(i < e){ s = s + m; i = i + 1; }
	if(i < e){ s = s + m; i = i + 1; }
/*
		String s = " ( ゜Д゜)";
		switch(e){
			case 1:{ put(s); break; }
			case 2:{ put(s + s); break; }
			case 3:{ put(s + s + s); break; }
			case 4:{ put(s + s + s + s); break; }
		}
*/

	// HPを減らす
	int d = r.nextInt(8);
	Player.hp -= d;
		if(Player.hp < 0){
			Player.hp = 0;
		}
		Console.put(Player.name + "は、" + d + "　ポイントのダメージを受けた。");

	//レベル上昇
	Player.lv += e;
	Console.put("lvが" + Player.lv + "　になった。");
	Console.putStatus();
		if(Player.hp == 0){
			System.out.println("GAME OVER");
		}else{
			putCommand();
		}
	}
    
    public static int inputCommand() throws java.io.IOException{

		int c = System.in.read();
		if(c == 10 || c == 13){
			return(inputCommand());
		}
		return(c);

	}

}