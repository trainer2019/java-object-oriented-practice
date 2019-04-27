package payment;

/**
 * お釣りクラス
 * - 自動販売機のお釣り管理機能を持つクラス
 */
class Change {

    // お釣りの金額を保持するフィールド変数
    private final int change;

    /**
     * コンストラクタ
     *
     * @param change お釣りの合計金額
     */
    Change(int change) {
        this.change = change;
    }

    /**
     * お釣りの通知を行う
     */
    void informSum() {
        System.out.println("[INFO] " + this.change + " 円のお釣りです。");
    }

    /**
     * お釣りを硬貨で返却する
     */
    void returnCoins() {

        // お釣りが0円なら実行しない
        if (this.change == 0) {
            return;
        }

        int remainingAmount = this.change;

        int countFiveHundredYenCoin = 0;
        int countHundredYenCoin = 0;
        int countFiftyYenCoin = 0;
        int countTenYenCoin = 0;

        // 500円玉の枚数を計算
        while (remainingAmount >= 500) {
            countFiveHundredYenCoin++;
            remainingAmount = remainingAmount - 500;
        }
        // 100円玉の枚数を計算
        while (remainingAmount >= 100) {
            countHundredYenCoin++;
            remainingAmount = remainingAmount - 100;
        }
        // 50円玉の枚数を計算
        while (remainingAmount >= 50) {
            countFiftyYenCoin++;
            remainingAmount = remainingAmount - 50;
        }
        // 10円玉の枚数を計算
        while (remainingAmount >= 10) {
            countTenYenCoin++;
            remainingAmount = remainingAmount - 10;
        }

        // お釣りを出力する
        System.out.print("[INFO] お釣りは");

        if (countFiveHundredYenCoin > 0) {
            System.out.print("500円玉を" + countFiveHundredYenCoin + "枚 ");
        }
        if (countHundredYenCoin > 0) {
            System.out.print("100円玉を" + countHundredYenCoin + "枚 ");
        }
        if (countFiftyYenCoin > 0) {
            System.out.print("50円玉を" + countFiftyYenCoin + "枚 ");
        }
        if (countTenYenCoin > 0) {
            System.out.print("10円玉を" + countTenYenCoin + "枚 ");
        }

        System.out.println("返します。");
    }
}
