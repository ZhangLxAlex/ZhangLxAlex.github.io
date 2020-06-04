package com.model.zlx.zhanglxalex.config.druid;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import javax.sql.DataSource;

/**
 * 配置数据源
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@MapperScan(basePackages = {DruidConfiguration.MAPPER_PACKAGE}, sqlSessionFactoryRef = DruidConfiguration.SESSIONFACTORY_NAME)
public class DruidConfiguration {

    /**
     * SqlSessionFactory名称.
     */
    public final static String SESSIONFACTORY_NAME = "MySqlSessionFactory";
    /**
     * mapper包路径，必须与其他SqlSessionFactory-mapper路径区分.
     */
    public final static String MAPPER_PACKAGE = "com.model.zlx.zhanglxalex.mapper";
    /**
     * mapper.xml文件路径，必须与其他SqlSessionFactory-mapper路径区分.
     */
    public final static String MAPPER_XML_PATH = "classpath:com.model.zlx.zhanglxalex.mapper.**.xml";

    private static final String DATASOURCE_BEAN_NAME = "myDataSource";

    /**
     * 数据源
     * @return
     */
    @Bean(name = DATASOURCE_BEAN_NAME)
    @ConfigurationProperties("spring.datasource.druid")
    public com.alibaba.druid.pool.DruidDataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 链接工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = SESSIONFACTORY_NAME)
    public SqlSessionFactory mySqlSessionFactory(@Qualifier(DATASOURCE_BEAN_NAME) DataSource dataSource)
            throws Exception{
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH));
        return sessionFactoryBean.getObject();
    }

}
