package com.kyle.erp.member;

import java.util.List;

public interface MemberMapper {
	public abstract int bye(Member m);

	public abstract List<Member> getAllMember();

	public abstract Member getMemberById(Member m);

	public abstract int join(Member m);

	public abstract int update(Member m);
}
