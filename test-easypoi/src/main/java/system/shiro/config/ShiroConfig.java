package system.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import system.shiro.bean.ShiroConfigProperties;
import system.shiro.filter.ShiroLoginFilter;
import system.shiro.realm.UsernameRealm;

import javax.servlet.Filter;
import java.util.*;

/**
 * Shiro配置
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-20 18:33
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        Collection<Realm> realms = new ArrayList<Realm>();
        realms.add(userNameRealm());
//        realms.add(tokenRealm());
        securityManager.setRealms(realms);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean(name = "sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager, ShiroConfigProperties shiroConfigProperties) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/unauth");
        // 自定义url 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        if (!shiroConfigProperties.getAnonUrls().isEmpty()) {
            for (String url : shiroConfigProperties.getAnonUrls()) {
                filterChainDefinitionMap.put(url, "anon");
            }
        }
        filterChainDefinitionMap.put("/upload","anon");
        filterChainDefinitionMap.put("/baoxiu","anon");
        filterChainDefinitionMap.put("/findAll","anon");
        filterChainDefinitionMap.put("/{fileName:.+}","anon");
        filterChainDefinitionMap.put("/findNo","anon");
        filterChainDefinitionMap.put("/findYes","anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/regist","anon");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //自定义拦截过滤器
        Map<String, Filter> filterMap = new HashMap<>(  );
        filterMap.put("shiroLoginFilter",shiroLoginFilter() );
        shiroFilterFactoryBean.setFilters(filterMap);

        return shiroFilterFactoryBean;
    }

    @Bean(name = "UserNameRealm")
    public UsernameRealm userNameRealm() {
        return new UsernameRealm();
    }

//    @Bean(name = "TokenRealm")
//    public TokenRealm tokenRealm() {
//        return new TokenRealm();
//    }


    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    /**
     * 开启aop注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public ShiroLoginFilter shiroLoginFilter(){
        return new ShiroLoginFilter();
    }

}
