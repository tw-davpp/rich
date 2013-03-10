package tw.terrain;

import tw.util.IO;

public class GiftShopping extends TerrainUsage {
    private void prompt() {
        IO.outputLine("欢迎光临礼品屋，请选择一件您喜欢的礼品：");
    }

    @Override
    public void usage() {
        prompt();
        int identifier = getGiftIdentifier();
        ChooseGift cg = chooseGift(identifier);
        if (cg != null)
            cg.reward();
    }

    private int getGiftIdentifier() {
        String line = IO.readLine();
        return Integer.parseInt(line);
    }

    public ChooseGift chooseGift(int identifier) {
        switch (identifier) {
            case 1:
                return new ChooseAward(role);
            case 2:
                return new ChooseCredit(role);
            case 3:
                return new ChooseMascot(role);
            default:
                return null;
        }
    }
}
