package payment;

/**
 * 支払クラスのインターフェース
 */
public interface Payment {

    /**
     * 自動販売機にお金を入れるメソッドの抽象クラス
     *
     * @param coin 投入された硬貨
     */
    void inputCoin(int coin);

    /**
     * 支払を行うメソッドの抽象クラス
     *
     * @param drink 飲み物名
     */
    void selling(String drink);
}
