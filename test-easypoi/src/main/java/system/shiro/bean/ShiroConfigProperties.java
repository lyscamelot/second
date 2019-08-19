package system.shiro.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Shiro配置文件处理类
 *
 * @author lizhi
 */
@Component
@ConfigurationProperties(prefix = "jes.shiro")
public class ShiroConfigProperties {
    /**
     * 免登陆的接口
     */
    private List<String> anonUrls = new ArrayList<>();

    public List<String> getAnonUrls() {
        return anonUrls;
    }

    public void setAnonUrls(List<String> anonUrls) {
        this.anonUrls = anonUrls;
    }

    @Override
    public String toString() {
        return "ShiroConfigProperties{" +
                "anonUrls=" + anonUrls +
                '}';
    }
}
