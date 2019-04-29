import config.Configs;
import payment.Payment;
import payment.PaymentCampaign;
import payment.PaymentNormal;
import stock.Stock;

/**
 * 業務ロジック
 * - 部品に指示を出すクラス
 */
public class Main {
    public static void main(String[] args) {

        // 引数の値は必ず2つ以上必要です。足りない場合は強制終了。
        if (args.length < 2) {
            System.out.println("[ERROR] 引数が正しくありません。");
            System.exit(0); // 強制終了させる
        }

        // 設定ファイルの読み込み
        Configs configs = new Configs();

        System.out.println("[DEBUG] ========== 購入処理：開始 ==========");

        int coinCount = args.length - 1; // 投入された硬貨の枚数。最後尾は買いたい飲み物なので除外。

        // Paymentクラスをインスタンス化
        Payment payment;
        if (configs.isCampaign()) { // キャンペーン期間中の場合
            System.out.println("[INFO] キャンペーン期間中！アタリを引くとジュースが半額！！");
            payment = new PaymentCampaign(); // 支払クラスをインスタンス化
        } else { // キャンペーン期間外の場合
            payment = new PaymentNormal(); // 支払クラスをインスタンス化
        }

        // お金を投入する
        for (int i = 0; i < coinCount; i++) {
            int coin = Integer.parseInt(args[i]);
            payment.inputCoin(coin);
        }

        String drink = args[args.length - 1]; //購入するドリンクを取り出し
        Stock stock = new Stock(); // 在庫クラスをインスタンス化

        // 在庫があったら購入させる
        if (stock.isExist(drink)) {
            // 支払を実施
            payment.selling(drink);
            // 買った分の在庫を減らす
            stock.take(drink);
        }

        System.out.println("[DEBUG] ========== 購入処理：終了 ==========");
    }
}
