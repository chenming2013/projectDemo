package com.chenming.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;

public class ShiroRealm extends AuthenticatingRealm
{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
	{
		
		//1. 把AuthenticationToken转换为UsernamepasswordToken
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
		
		//2. 从UsernamepasswordToken中获取username
		String username = usernamePasswordToken.getUsername();
		
		//3. 调用数据库的方法,从数据库查询username对应的用户记录
		//这里我们就不访问数据库了
		System.out.println("从数据库中获取username: "+username+"所对应的信息");
		
		//4. 若用户不存在,则可以抛出UnknownAccountException异常
		if("unknown".equals(username))
		{
			throw new UnknownAccountException("用户不存在!");
		}
		
		//5. 根据用户信息的情况,决定是否需要抛出其他的AuthenticationException
		if("monster".equals(username))
		{
			throw new LockedAccountException("用户被锁定");
		}
		
		//6. 根据用户的情况,来构建AuthenticationInfo对象返回：通常使用的实现类为：SimpleAuthenticationInfo
		//以下是从数据库中获取的:
		//1). principal: 认证的实体信息,可以是username,也可以是数据表对应的用户的实体类对象
		Object principal = username;
		//2). credentials: 密码,我们这里模拟数据的密码
		Object credentials = "123456";
		//3). realmName: 当前realm对象的name,调用父类的getName()方法即可
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, getName());
		return info;
	}
	
	public static void main(String[] args)
	{
		//MD5加密
		//将密码123456经过MD5加密之后得出的结果如下
		//加密的方式: MD5
		String hashAlgorithmName = "MD5";
		//加密的凭证: 密码
		Object credentials = "123456";
		//盐值: salt
		Object salt = null;
		//加密的次数: hashIterations,可以是任意正数
		int hashIterations = 1;
		//MD5加密
		Object result = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
		System.out.println("result: "+result);
	}

}
