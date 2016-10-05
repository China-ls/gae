package weixin.popular.example;

import weixin.popular.support.TokenManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TokenManagerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //WEB容器 初始化时调用
        TokenManager.init("appid", "secret");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //WEB容器  关闭时调用
        TokenManager.destroyed();
    }
}
