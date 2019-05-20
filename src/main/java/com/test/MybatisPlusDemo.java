package com.test;


import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author q
 * @create 2019- 04- 30 11:07
 */
public class MybatisPlusDemo {

    @Test
    public void   Generate(){
        //全局策略配置
        GlobalConfig config=new GlobalConfig();
        config	.setActiveRecord(true)//是否支持AR模式
                .setAuthor("q")//配置作者名   E:\java web3\Mybatis_plus\Logistics\src\main
                .setOutputDir("E:\\java web3\\Mybatis_plus\\Logistics\\src\\main\\java")//配置文件生成的路径
                .setFileOverride(true)//是否指定文件覆盖
                .setServiceName("%sService")//是否已I开头
                .setIdType(IdType.AUTO)//主键生成策略
                .setBaseResultMap(true)//生成Mapper.xml文件
                .setBaseColumnList(true);//sql片段
        //2、配置数据源
        DataSourceConfig dataSource =new DataSourceConfig()
                .setDbType(DbType.MYSQL)//数据库类型
                .setDriverName("com.mysql.jdbc.Driver")//com.mysql.jdbc.Driver
                .setUrl("jdbc:mysql:///logistics")//jdbc:mysql://localhost:3306/数据库名
                .setUsername("root")//用户名
                .setPassword("123456");
        //3策略配置
        StrategyConfig sConfig=new StrategyConfig()
                .setCapitalMode(true)//全局大写名
                .setDbColumnUnderline(true)//表名是否使用下划线命名
                .setNaming(NamingStrategy.underline_to_camel)//数据库映射到实体类的命名策略
                .setInclude("accmodule","area","balance","car"
                ,"cardetail","carroad","customer","customertype","module"
                ,"orderstatus","paidtype","sendtype","transcar","userlog","users");//里面的参数是表名
        //4包名策略
        PackageConfig pConfig=new PackageConfig()
                .setParent("com.logistics")//总包名
                .setMapper("mapper")//mapper层
                .setXml("mapper")//xml生成在mapper层
                .setController("controller")//Controller
                .setEntity("entity")//entity
                .setService("service");//service
        //5策略配置
        AutoGenerator aGenerator=new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSource)
                .setPackageInfo(pConfig)
                .setStrategy(sConfig);
        //6执行
        aGenerator.execute();

    }

}
