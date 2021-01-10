package top.vikingyang.loverspace.entity.lovers.bo;

import top.vikingyang.loverspace.entity.lovers.Lamb;

public class LambBo extends Lamb {

    /**
     * 拥有属于自己的羊圈
     */
    private boolean hasSheepfold;

    /**
     * 坠入爱河时长
     */
    private int fallingDays;

    public boolean isHasSheepfold() {
        return hasSheepfold;
    }

    public void setHasSheepfold(boolean hasSheepfold) {
        this.hasSheepfold = hasSheepfold;
    }

    public int getFallingDays() {
        return fallingDays;
    }

    public void setFallingDays(int fallingDays) {
        this.fallingDays = fallingDays;
    }
}
