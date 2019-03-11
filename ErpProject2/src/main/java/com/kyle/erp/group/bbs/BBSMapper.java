package com.kyle.erp.group.bbs;

import java.util.List;

public interface BBSMapper {
	public abstract int deleteBBSMsg(BBS bm);
	public abstract int deleteBBSReply(BBSReply br);
	public abstract int getAllBBSMsgsCount();
	public abstract BBS getBBSMsg(BBS bm);
	public abstract List<BBS> getBBSMsgs(BBSNo bmn);
	public abstract List<BBSReply> getBBSReplys(BBS bm);
	public abstract List<BBS> searchBBSMsg(BBS bm);
	public abstract int updateBBSMsg(BBS bm);
	public abstract int writeBBSMsg(BBS bm);
	public abstract int writeBBSReply(BBSReply br);
}


