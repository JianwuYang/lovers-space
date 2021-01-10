package top.vikingyang.loverspace.entity.lovers;

import java.io.Serializable;

/**
 * missingcombo
 * @author 
 */
public class MissingCombo implements Serializable {
    private Long id;

    /**
     * 小羊ID
     */
    private Long lambId;

    /**
     * 签到时间
     */
    private String missingDate;

    /**
     * 连续签到次数
     */
    private Integer combo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLambId() {
        return lambId;
    }

    public void setLambId(Long lambId) {
        this.lambId = lambId;
    }

    public String getMissingDate() {
        return missingDate;
    }

    public void setMissingDate(String missingDate) {
        this.missingDate = missingDate;
    }

    public Integer getCombo() {
        return combo;
    }

    public void setCombo(Integer combo) {
        this.combo = combo;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MissingCombo other = (MissingCombo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLambId() == null ? other.getLambId() == null : this.getLambId().equals(other.getLambId()))
            && (this.getMissingDate() == null ? other.getMissingDate() == null : this.getMissingDate().equals(other.getMissingDate()))
            && (this.getCombo() == null ? other.getCombo() == null : this.getCombo().equals(other.getCombo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLambId() == null) ? 0 : getLambId().hashCode());
        result = prime * result + ((getMissingDate() == null) ? 0 : getMissingDate().hashCode());
        result = prime * result + ((getCombo() == null) ? 0 : getCombo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", lambId=").append(lambId);
        sb.append(", missingDate=").append(missingDate);
        sb.append(", combo=").append(combo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}