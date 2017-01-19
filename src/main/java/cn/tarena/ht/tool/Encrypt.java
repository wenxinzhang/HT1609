package cn.tarena.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Encrypt {
	
	public static String getMd5(String username,String password){
		
		Md5Hash md5Hash = new Md5Hash(password, username, 3);
		return md5Hash.toString();
	}
	
	public static void main(String[] args) {
		/**
		 * 1.source  表示要加密的明文
		 * 2.salt    添加辅助的加密材料 
		 * 3.hashIterations   int类型的值 表示hash次数
		 */
		
		
		Md5Hash md5Hash = new Md5Hash("lyj", "lyj", 3);
		System.out.println(md5Hash);
	}
}
