package payment;

/**
 * キャンペーン期間中の支払クラス
 */
public class PaymentCampaign extends Payment {

    /**
     * 支払を行う (キャンペーン期間中なので無料になるアタリ付き！)
     *
     * @param drink 飲み物名
     */
    @Override
    public void selling(String drink) {

        int price = drinkPrices.get(drink);

        // 半額チャンスのくじ引き！
        if (isWinning()) {
            System.out.println("[INFO] アタリが出たので半額になります！");

            // 値段を半額にする。1の位が5にならないよう制御。
            price = price / 2;
            if (price % 10 > 0) {
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
