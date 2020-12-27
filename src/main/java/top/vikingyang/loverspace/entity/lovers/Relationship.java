package top.vikingyang.loverspace.entity.lovers;

import java.io.Serializable;
import java.util.Date;

/**
 * relationship
 * @author 
 */
public class Relationship implements Serializable {
    private Long id;

    /**
     * 发起者ID
     */
    private Long initiatorId;

    /**
     * 被邀请者ID
     */
    private Long inviteesId;

    /**
     * 相恋时间
     */
    private Date loveTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(Long initiatorId) {
        this.initiatorId = initiatorId;
    }

    public Long getInviteesId() {
        return inviteesId;
    }

    public void setInviteesId(Long inviteesId) {
        this.inviteesId = inviteesId;
    }

    public Date getLoveTime() {
        return loveTime;
    }

    public void setLoveTime(Date loveTime) {
        this.loveTime = loveTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        Relationship other = (Relationship) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInitiatorId() == null ? other.getInitiatorId() == null : this.getInitiatorId().equals(other.getInitiatorId()))
            && (this.getInviteesId() == null ? other.getInviteesId() == null : this.getInviteesId().equals(other.getInviteesId()))
            && (this.getLoveTime() == null ? other.getLoveTime() == null : this.getLoveTime().equals(other.getLoveTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInitiatorId() == null) ? 0 : getInitiatorId().hashCode());
        result = prime * result + ((getInviteesId() == null) ? 0 : getInviteesId().hashCode());
        result = prime * result + ((getLoveTime() == null) ? 0 : getLoveTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", initiatorId=").append(initiatorId);
        sb.append(", inviteesId=").append(inviteesId);
        sb.append(", loveTime=").append(loveTime);
        sb.append(", creator=").append(creator);
        sb.append(", updater=").append(updater);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}