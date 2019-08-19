package system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import common.exception.AppException;
import common.util.DateUtils;
import freemarker.template.utility.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.CaptchaDO;
import system.mapper.CaptchaDao;
import system.service.CaptchaService;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author lxf
 * @date 2019-03-19 10:42:51
 * @version V1.0
 */
@Service
public class CaptchaServiceImpl extends ServiceImpl<CaptchaDao, CaptchaDO> implements CaptchaService {
    private static final Logger logger = LoggerFactory.getLogger( CaptchaServiceImpl.class );

    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new AppException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();
        CaptchaDO captchaDO = new CaptchaDO();
        captchaDO.setId(uuid);
        captchaDO.setCode(code);
        //三分钟过期
        captchaDO.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        System.out.println(captchaDO.getExpireTime());
        this.save(captchaDO);
        return producer.createImage(code);
    }

    @Override
    public Boolean verification(String uuid, String captcha) {
        CaptchaDO captchaDO = this.getOne(new QueryWrapper<CaptchaDO>().eq("id",uuid));
        if(captchaDO == null){
            return false;
        }
        //删除验证码
        this.removeById(uuid);
        System.out.println(captchaDO.getExpireTime());
        long x = captchaDO.getExpireTime().getTime();
        long y = System.currentTimeMillis();
        if(captchaDO.getCode().equalsIgnoreCase(captcha)&&captchaDO.getExpireTime().getTime() >= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
}
