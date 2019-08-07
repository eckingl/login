package web.login.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//使用durid连接池
public  class JDBCUtil {

    public static DataSource ds ;

    static {

        try {
            //加载配置文件
            Properties pro = new Properties();
            //使用classloader加载配置文件,获取字节输入流
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //初始化连接池对象
             ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //获取连接对象

    public static DataSource getDataSourse(){
        return ds;
    }




}
