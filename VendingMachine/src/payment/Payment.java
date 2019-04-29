package payment;

import java.util.HashMap;
import java.util.Map;

/**
 * 支払クラスの抽象クラス
 */
public abstract class Payment {
    // 投入されたお金の合計
    protected int amount = 0;

    // 飲み物の値段
    protected static final Map<String, Integer> drinkPrices = new HashMap<String, Integer>() {
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
     * 支払を行うメソッドの抽象メソッド
     *
     * @param drink 飲み物名
     */
    public abstract void selling(String drink);
}
