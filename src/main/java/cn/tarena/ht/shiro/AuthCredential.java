package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.ht.tool.Encrypt;


public class AuthCredential extends  SimpleCredentialsMatcher{
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//自定义的加密算法 的目的 就是对用户输入的密码进行加密
		
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		
		String username = loginToken.getUsername();  //充当加密中的盐
		String password = String.valueOf(loginToken.getPassword());
		String md5Password = Encrypt.getMd5(username, password);
		
		//将密码放回到令牌当中
		loginToken.setPassword(md5Password.toCharArray());
		
		//将新的令牌返回给shiro安全管理器
		return super.doCredentialsMatch(loginToken, info);
	}
}
