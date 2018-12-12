package site.morn.boot.autoconfigure;

import javax.servlet.Servlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import site.morn.bean.IdentifiedBeanCache;
import site.morn.boot.web.ExceptionHandlerAspect;

/**
 * Web自动化配置
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/12
 */
@Configuration
@ConditionalOnClass({Servlet.class, DispatcherServlet.class,
    WebMvcConfigurerAdapter.class})
public class WebAutoConfiguration {

  /**
   * 注册全局异常处理切面
   *
   * @return 全局异常处理切面
   */
  @Bean
  @ConditionalOnMissingBean
  public ExceptionHandlerAspect exceptionHandlerAspect(IdentifiedBeanCache beanCache) {
    return new ExceptionHandlerAspect(beanCache);
  }
}
