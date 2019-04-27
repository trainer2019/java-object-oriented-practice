package parts;

import java.util.HashMap;
import java.util.Map;

/**
 * 支払クラス
 * - 自動販売機の支払機能を持つクラス
 */
public class Payment {

	// 投入されたお金の合計
	public int amount = 0;

	// 飲み物の値段
	public static Map<String, Integer> drinkPrices = new HashMap<String, Integer>() {
		{
			put("coffee", 100);
			put("orange", 120);
			put("cola", 130);
		}
	};

	/**
	 * 自動販売機にお金を入れる
	 *
	 * @param coin 投入された硬貨
	 */
	public void inputCoin(int coin) {

		// 使える硬貨か確認する
		switch (coin) {
		case 1:
		case 5:
			// 1,5円玉は使えないので返却
			System.out.println("[WARNING] " + coin + "円玉は返却します。");
			break;
		case 10:
		case 50:
		case 100:
		case 500:
			// 10,50,100,500円玉は使えるので投入金額に加算
			amount += coin;
			System.out.println("[INFO] ただいまの合計金額は " + amount + " 円です。");
			break;
		default:
			// それ以外の金額は機械の読み取りミスとして処理する
			System.out.println("[WARNING] 金額をうまく読み取れませんでした。");
		}
	}

	/**
	 * 支払を行う
	 *
	 * @param drink 飲み物名
	 */
	public void selling(String drink) {

		int price = drinkPrices.get(drink);

		// 飲み物代を支払う
		if (amount >= price) {
			System.out.println("[INFO] " + drink + " が販売されました。");

			// お釣りを計算する
			int change = amount - price;
			System.out.println("[INFO] " + change + " 円のお釣りです。");

		} else {
			System.out.println("[WARNING] お金が足りないため購入できません");
		}
	}

}
