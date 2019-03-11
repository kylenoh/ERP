package com.kyle.erp.group.chat;

import java.util.List;

public interface ChatMapper {
	public abstract List<Chat>getChatListByID(Chat chat);
	public abstract List<Chat>getChatListByRecent(Chat chat);
	public abstract int regChat(Chat chat);
}
