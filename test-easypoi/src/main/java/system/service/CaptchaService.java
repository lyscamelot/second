package system.service;

import com.baomidou.mybatisplus.extension.service.IService;

import system.entity.CaptchaDO;

import java.awt.image.BufferedImage;

/**
 * 
 * @author lxf
 * @date 2019-03-19 10:42:51
 * @version V1.0
 */
public interface CaptchaService extends IService<CaptchaDO>{

    //获取图片验证码
    BufferedImage getCaptcha(String uuid);

    Boolean verification(String uuid,String captcha);

}
