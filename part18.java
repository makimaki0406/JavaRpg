import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class part18 {
	public static void main(String[] args) throws java.io.IOException{
		System.out.println("ばば");

		// ウィンドウフレームを作成表示
		JFrame jf = new JFrame();
		jf.setBounds(20, 40, 940, 540);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// パネルを作成し、フレームに張り付け
		JPanel jp = new JPanel();
		jp.setBackground(Color.BLACK);
		jf.add(jp);
		
		// レイアウト１行目
		// パネルを作成し、親パネルに張り付け
		JPanel jpChild = new JPanel();
		jpChild.setBackground(Color.BLUE);
		jp.add(jpChild);
		Font f = new Font(Font.MONOSPACED, 
				  Font.BOLD | Font.ITALIC,
				  50);
		// レベルを作成し、子パネルに張り付け
		JLabel jlChild = new JLabel(Console.getStatusString());
		jlChild.setFont(f);
		jlChild.setForeground(Color.WHITE);
		jpChild.add(jlChild);

		// レイアウト２行目	
		// パネルを作成し、親パネルに張り付け
		JPanel jpChild2 = new JPanel();
		jpChild2.setBackground(Color.CYAN);
		jp.add(jpChild2);
		/*
		// 選択肢をパネルに張り付け
		JLabel jlMain = new JLabel("<html>1.魔王を倒しに行く<br>2.修行しにいく<br>3.宿屋に泊まる");
		jlMain.setFont(f);
		jpChild2.add(jlMain);
		*/
		
		

		//モンスターを貼付け
		File file = new File("yome.png");			//ファイルを開く
		BufferedImage ba = ImageIO.read(file);      //画像全体を読み込む

		int cw = 32;				// セルサイズ・幅
		int ch = 48;				// セルサイズ・高さ
		int sw = 32 * 6;				// 表示セルサイズ・幅
		int sh = 48 * 6;				// 表示セルサイズ・高さ

		putMonster(jpChild2, ba, 2, 4, cw, ch, sw, sh);		// モンスター 2-4 表示
		putMonster(jpChild2, ba, 3, 4, cw, ch, sw, sh);		// モンスター 3-4 表示
		putMonster(jpChild2, ba, 6, 4, cw, ch, sw, sh);		// モンスター 6-4 表示
		putMonster(jpChild2, ba, 9, 4, cw, ch, sw, sh); 	// モンスター 9-4 表示


		// レイアウト3行目	
		// レベルを作成し、パネルに張り付け
		JLabel jl = new JLabel("魔王が世界を滅ぼそうとしています。");
		jl.setFont(f);
		jl.setForeground(new Color(255, 128, 0));
		jp.add(jl);
	
		jf.setVisible(true);
}

	/**
	 * モンスターを表示
	 * 
	 * @param jpChild2	表示対象パネル 
	 * @param ba    画像全体
	 * @param x		表示するセル座標X
	 * @param y		表示するセル座標Y
	 * @param cw	セルの大きさX
	 * @param ch	セルの大きさY
	 * @param sw 	表示サイズ・幅
	 * @param sh 	表示サイズ・高さ
	 */

	static void putMonster(JPanel jpChild2, BufferedImage ba, int x, int y, int cw, int ch, int sw, int sh){
		BufferedImage bs = ba.getSubimage(cw * x, ch * y, cw, ch);
		Image im = bs.getScaledInstance(sw, sh, Image.SCALE_DEFAULT) ;
		ImageIcon ii = new ImageIcon(im);			//JLabel用に型変換
		JLabel jlImage = new JLabel(ii);			//画像部品を作成
		jlImage.setSize(sw, sh);					//画像部品サイズを設定
		jpChild2.add(jlImage);							//画像を貼付け
	}	

}
