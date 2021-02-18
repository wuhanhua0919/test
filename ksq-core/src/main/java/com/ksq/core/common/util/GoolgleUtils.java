package com.ksq.core.common.util;

public class GoolgleUtils {

	public static boolean verifyTest(String codeVale,String seret) {
		long code = Long.parseLong(codeVale);
		long t = System.currentTimeMillis();
		GoogleAuthenticator ga = new GoogleAuthenticator();
		ga.setWindowSize(1); 
		boolean r = ga.check_code(seret, code, t);
		System.out.println("检查code是否正确？" + r);
		return r;
	}
	
	public static String getKey(){
		// TODO Auto-generated method stub
	    String secret = GoogleAuthenticator.generateSecretKey();
		System.out.println("secret:"+secret); 
		GoolgleUtils.verifyTest("511961", "RWOI4N5CEDFHLUT7");
	   return secret;
	}
}
