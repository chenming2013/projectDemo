package com.chenming.dao;

import com.chenming.entity.Member;

public interface IMemberDao
{
	/**
	 * 
	 * 实现根据ID查询数据
	 */
	public Member findById(String id) throws Exception;
	
	/**
	 * 实现数据保存
	 * @param member 要保存的member实体
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(Member member) throws Exception;
}
