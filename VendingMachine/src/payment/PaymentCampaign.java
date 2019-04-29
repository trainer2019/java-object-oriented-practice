package payment;

import java.util.HashMap;
import java.util.Map;

/**
 * キャンペーン期間中の支払クラス
 */
public class PaymentCampaign implements Payment{

    // 投入されたお金の合計
    private int amount = 0;

    // 飲み物の値段
    private static final Map<String, Integer> drinkPrices = new HashMap<String, Integer>() {
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
     * 支払を行う (キャンペーン期間中なので無料になるアタリ付き！)
     *
     * @param drink 飲み物名
     */
    public void selling(String drink) {

        int price = drinkPrices.get(drink);

        // 半額チャンスのくじ引き！
        if (isWinning()){
            System.out.println("[INFO] アタリが出たので半額になります！");

            // 値段を半額にする。1の位が5にならないよう制御。
            price = price / 2;
            if (price % 10 > 0){
                price = price + (10 - (price % 10));
            }
        } else {
            System.out.println("[INFO] ハズレでした！残念！！");
        }

        // 飲み物代を支払う
        if (amount >= price) {
            System.out.println("[INFO] " + drink + " が販売されました。");

            // お釣りの金額を引数にしてお釣り管理クラスをインスタンス化
            Change change = new Change(amount - price);
            change.informSum(); // お釣り金額を出力
            change.returnCoins(); // お釣りを硬貨で返却

        } else {
            System.out.println("[WARNING] お金が足りないため購入できません");
        }
    }

    // アタリがでる確率
    private static final int PER_LOTTERY = 80;

    // アタリ判定処理
    private boolean isWinning() {
        int lottery = (int) (Math.random() * 100);
        return (lottery >= PER_LOTTERY);
    }
}
