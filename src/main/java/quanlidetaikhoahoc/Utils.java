package quanlidetaikhoahoc;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	public static String encryptMD5(String token, String raw) {
		return DigestUtils.md5Hex(raw + token);
	}

	public static String generateToken() {
		return RandomStringUtils.random(32, "0123456789abcdefghijklmnopqrstuvwxyz");
	}

	public static String generateRandomString() {
		return RandomStringUtils.random(15, "0123456789abcdefghijklmnopqrstuvwxyz");
	}
}
