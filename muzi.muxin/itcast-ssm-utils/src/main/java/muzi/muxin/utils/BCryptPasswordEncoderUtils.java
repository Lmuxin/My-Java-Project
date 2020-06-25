package muzi.muxin.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
	
	private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	
	
	public static String encodePassword(String password) {
		
		return bCryptPasswordEncoder.encode(password);
		
	}
	
	
/*	
	@Test
	public void testencodePassword() {
		
		System.out.print(encodePassword("1235"));
		
	}
*/
}

