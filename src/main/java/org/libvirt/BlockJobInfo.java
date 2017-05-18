package org.libvirt;

/**
 * Created Date: 16/05/17
 */
public class BlockJobInfo {
    public static final int  VIR_DOMAIN_BLOCK_JOB_TYPE_UNKNOWN	=	0; //Placeholder
    public static final int  VIR_DOMAIN_BLOCK_JOB_TYPE_PULL	=	1; //Block Pull (virDomainBlockPull, or virDomainBlockRebase without flags), job ends on completion
    public static final int  VIR_DOMAIN_BLOCK_JOB_TYPE_COPY	=	2; //Block Copy (virDomainBlockCopy, or virDomainBlockRebase with flags), job exists as long as mirroring is active
    public static final int  VIR_DOMAIN_BLOCK_JOB_TYPE_COMMIT	=	3; //Block Commit (virDomainBlockCommit without flags), job ends on completion
    public static final int  VIR_DOMAIN_BLOCK_JOB_TYPE_ACTIVE_COMMIT	=	4; //Active Block Commit (virDomainBlockCommit with flags), job exists as long as sync is active
    public static final int  VIR_DOMAIN_BLOCK_JOB_TYPE_LAST	=	5;

    public BlockJobInfo(int type, long bandwidth, long cur, long end) {
        this.type = type;
        this.bandwidth = bandwidth;
        this.cur = cur;
        this.end = end;
    }

    int	type; //virDomainBlockJobType
    long	bandwidth; //The following fields provide an indication of block job progress. @cur indicates the current position and will be between 0 and @end. @end is the final cursor position for this operation and represents completion. To approximate progress, divide @cur by @end.
    long	cur; //virDomainBlockJobCursor
    long	end; //virDomainBlockJobCursor

    public String getTypeString() {
        switch (type){
            case VIR_DOMAIN_BLOCK_JOB_TYPE_UNKNOWN : return "Unknown";
            case VIR_DOMAIN_BLOCK_JOB_TYPE_PULL : return "Pull";
            case VIR_DOMAIN_BLOCK_JOB_TYPE_COPY : return "Copy";
            case VIR_DOMAIN_BLOCK_JOB_TYPE_COMMIT : return "Commit";
            case VIR_DOMAIN_BLOCK_JOB_TYPE_ACTIVE_COMMIT : return "Active commit";
            case VIR_DOMAIN_BLOCK_JOB_TYPE_LAST : return "Last";
            default: return "Unknown";
        }
    }

    public int getType() {
        return type;
    }

    public long getBandwidth() {
        return bandwidth;
    }

    public long getCur() {
        return cur;
    }

    public long getEnd() {
        return end;
    }
}
