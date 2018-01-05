package com.mengdi.characterEncoding;
/**
 * 字符编码转换
 */
import java.io.UnsupportedEncodingException;

public class CharacterEncoding {
	public static void main(String[] args) {
		//本程序默认在UTF8编码下运行
	    String a = "郑高强";
	    String b = null;
	    try {
				b = new String(a.getBytes(),"UTF-8");
				System.out.println(b);  //正确显示
				
			    b = new String(a.getBytes("GB2312"),"GB2312");
			    System.out.println(b);  //正确显示。虽然a本来默认是三字节编码的，但getBytes("GB2312")
			                            //把整个字节数组按双字节形式转换了一次。用GB2312来解释这个新字节数组就对了
			    b = new String(a.getBytes("GB2312"),"UTF8");
			    System.out.println(b);  //乱码。已经转为双字节，还用UTF8解释就错了。
			                            //还没想到怎么把b救回来。好像没办法使得b重新正确显示了。
			    
			    b = new String(a.getBytes(),"GB2312");
			    System.out.println(b);  //乱码。getBytes已经把字符串逐个字符按UTF8格式，拆散为N个字节。
			                            //后边硬用GB2312来解释这N个字节，肯定乱码。UTF8三字节，GB2312双字节
			    b = new String(a.getBytes("UTF8"),"GB2312");    //同上一句其实一样
			    System.out.println(b);  //乱码
			    			    
			    System.out.println(System.getProperty("file.encoding"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	   
	}

}
