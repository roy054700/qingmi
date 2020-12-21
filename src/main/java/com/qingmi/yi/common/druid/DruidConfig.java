package com.qingmi.yi.common.druid;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用 阿里的连接池
 * @author 17146
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.druid")
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        //druidDataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return druidDataSource;
    }

    @Bean
    public Filter statFilter(){
        StatFilter statFilter = new StatFilter();
        //定义查询 超过多长时间 就为慢sql 的时间
        //statFilter.setSlowSqlMillis(1000L);
        //是否打印 日志
        //statFilter.setLogSlowSql(false);
        //是否合并日志文件
        statFilter.setMergeSql(false);
        return statFilter;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return  new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    }
}
