package common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**   
* spring上下文工具类 
* @author xxm  
* @date 2019/1/5 13:17 
* @version V1.0   
*/
@Component
public class SpringContextUtils implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(SpringContextUtils.class);
    private static ApplicationContext APPLICATION_CONTEXT;
    /**
     * 设置spring上下文
     * @param applicationContext spring上下文
     * @throws BeansException 异常
     * */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("ApplicationContext registed-->{}", applicationContext);
        APPLICATION_CONTEXT = applicationContext;
    }

    /**
     * 获取容器
     * @return spring容器
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    /**
     * 获取容器中的对象
     * @param type 对象类型
     * @param <T> 泛型
     * @return 实体
     */
    public static <T> T getBean(Class<T> type) {
        return APPLICATION_CONTEXT.getBean(type);
    }

    /**
     * 获取容器中的对象
     * @param name 对象的名字
     * @param type 对象的类型
     * @param <T> 同上
     * @return 实体
     */
    public static <T> T getBean(String name,Class<T> type) {
        return APPLICATION_CONTEXT.getBean( name, type);
    }
}