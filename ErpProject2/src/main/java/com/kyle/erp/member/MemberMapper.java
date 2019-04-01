package com.kyle.erp.member;

import java.util.List;

public interface MemberMapper {
	public abstract int bye(Member m);
	public abstract List<Member> getAllMember();
	public abstract Member getMemberById(Member member);
	public abstract int join(Member member);
	public abstract int update(Member member);
	public abstract int updateProfile(Member member);
	public abstract List<Member>getMemberList(Member member);
}
