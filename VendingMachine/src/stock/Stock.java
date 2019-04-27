package stock;

import java.util.HashMap;
import java.util.Map;

/**
 * 在庫クラス
 * - 自動販売機の在庫管理機能を持つクラス
 */
public class Stock {

    // 飲み物の在庫一覧
    private static final Map<String, Integer> drinkStocks = new HashMap<String, Integer>() {
        {
            put("coffee", 10);
            put("orange", 5);
            put("cola", 0);
        }
    };

    /**
     * 在庫があるか確認する
     *
     * @param drink 飲み物名
     * @return 飲み物の在庫の有無
     */
    public boolean isExist(String drink) {

        try {
            if (drinkStocks.get(drink) > 0) {
                return true;
            } else {
                System.out.println("[WARNING] " + drink + "の在庫はありません。");
                return false;
            }

        } catch (NullPointerException e) {
            // 在庫にない飲み物が選択されたら例外が発生するので処理
            System.out.println("[ERROR] " + drink + "は販売していません。");
            return false;
        }
    }

    /**
     * 購入時に飲み物の在庫を減らす
     *
     * @param drink 飲み物名
     */
    public void take(String drink) {

        // 在庫数を取得
        int stock = drinkStocks.get(drink);

        // 在庫があるか念のためチェック
        if (stock == 0) {
            System.out.println("[ERROR] 在庫はこれ以上減らせません。");
            // 強制終了させる
            System.exit(1);
        }

        // 在庫を減らす
        drinkStocks.put(drink, stock - 1);
        // 在庫数を出力
        System.out.println("[INFO] " + drink + " の在庫は残り" + drinkStocks.get(drink) + "個です。");
    }

    // 在庫の最大数
    private static final int MAX_STOCK = 30;

    /**
     * 飲み物の在庫を増やす
     *
     * @param drink 飲み物名
     * @param add   増やす個数
     */
    public void add(String drink, int add) {

        // 在庫数を取得
        int stock = drinkStocks.get(drink);

        // 在庫を増やす
        if ((stock + add) > MAX_STOCK) {
            int rest = (stock + add) - MAX_STOCK;
            drinkStocks.put(drink, MAX_STOCK);
            System.out.println("[WARNING] " + drink + " の在庫が最大数に達したので " + rest + " 個入りませんでした。");
        } else {
            drinkStocks.put(drink, stock + add);
        }

        // 在庫数を出力
        System.out.println("[INFO] " + drink + " の在庫は残り" + drinkStocks.get(drink) + "個です。");
    }
}
