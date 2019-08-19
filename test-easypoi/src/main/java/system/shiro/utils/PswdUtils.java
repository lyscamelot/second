package system.shiro.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.codec.Hex;
import org.springframework.util.DigestUtils;

/**
* 密码工具类
* @author xxm
* @date 2019/1/12 15:42
* @version V1.0
*/
public abstract class PswdUtils {
	/**
	 * id和密码加密密码
	 * @param userId 账号ID
	 * @param psasword 密码
	 * @return 加密后的密码
	 */
	public static String encrypt(String userId,String psasword) throws IllegalArgumentException {
		//盐值
		byte[] salt = getSalt(userId);
		if (salt != null) {
			//密码
			byte[] password = psasword.getBytes();
			//MD5摘要
			byte[] digest = DigestUtils.md5Digest( ArrayUtils.addAll(password, salt));
			//十六进制转换
			return Hex.encodeToString(digest);
		} else {
			throw new IllegalArgumentException("获取盐值错误");
		}
	}
	/**
	 * 获取用户相应的盐
	 * @param principal 用来生成盐的参数
	 * @return 盐值
	 */
	private static byte[] getSalt(String principal) {
		String salt = "jesSalt";
		if (StringUtils.isNotEmpty(principal)) {
			return DigestUtils.md5Digest(ArrayUtils.addAll(principal.getBytes(), salt.getBytes()));
		}
		return null;
	}

	/**
	 *  密码比对
	 * @param userId 用户id
	 * @param myPwd 加密前的密码
	 * @param sysPwd 加密后的密码
	 */
	public static boolean eqPwd(String userId,String myPwd,String sysPwd) throws IllegalArgumentException {
		String encrypt = encrypt( userId, myPwd );
		return encrypt.equals( sysPwd );
	}

}
