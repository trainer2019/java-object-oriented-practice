package payment;

/**
 * 支払クラス
 * - 自動販売機の支払機能を持つクラス
 */
public class PaymentNormal extends Payment {

    /**
     * 支払を行う
     *
     * @param drink 飲み物名
     */
    @Override
    public void selling(String drink) {

        int price = drinkPrices.get(drink);

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
}
