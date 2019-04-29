package config;

import java.util.List;

public class Configs {

    // コンストラクタ
    public Configs() {

        // インスタンス生成時に設定ファイルを読み込み
        final String CONFIG_PATH = "/Users/masahiro/work-space/java-object-oriented-practice/VendingMachine/configs/config.txt";
        FileManager fileManager = new FileManager(CONFIG_PATH);
        List<String> configs = fileManager.getContent();

        // キャンペーン設定の読み込み
        isCampaign = Boolean.valueOf(configs.get(0).split("=")[1]);
    }

    // キャンペーン期間中か否か
    private boolean isCampaign;

    public boolean isCampaign() {
        return isCampaign;
    }


}
