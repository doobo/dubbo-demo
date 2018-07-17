package vip.ipav.dubbo.config;

import com.alibaba.dubbo.config.RegistryConfig;
import com.xxl.conf.core.XxlConfClient;
import com.xxl.conf.core.listener.XxlConfListener;
import com.xxl.conf.core.spring.XxlConfFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class RegistryConfigService {

    @Value("${xxl.conf.zkaddress}")
    private String zkaddress;

    @Value("${xxl.conf.zkdigest}")
    private String zkdigest;

    @Value("${xxl.conf.env}")
    private String env;

    @Value("${xxl.conf.mirrorfile}")
    private String mirrorfile;

    private static String ZK_ADDRESS;

    static {
        /**
         * 配置变更监听示例：可开发Listener逻辑，监听配置变更事件；可据此实现动态刷新JDBC连接池等高级功能；
         */
        XxlConfClient.addListener("dubbo-starter.zkaddress", new XxlConfListener(){
            @Override
            public void onChange(String key, String value) throws Exception {
                ZK_ADDRESS = value;
            }
        });
    }

    /**
     * 配置中心初始化
     * @return
     */
    @Bean
    public XxlConfFactory xxlConfFactory() {
        XxlConfFactory xxlConf = new XxlConfFactory();
        xxlConf.setZkaddress(zkaddress);
        xxlConf.setZkdigest(zkdigest);
        xxlConf.setEnv(env);
        xxlConf.setMirrorfile(mirrorfile);
        return xxlConf;
    }

    /**
     * dubbo基础配置
     * @return
     */
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(XxlConfClient.get("dubbo-starter.zkaddress",null));
        registryConfig.setUsername(XxlConfClient.get("dubbo-starter.zkuser",null));
        registryConfig.setPassword(XxlConfClient.get("dubbo-starter.zkpasswd",null));
        registryConfig.setGroup("dubbo");//设置zookeeper的根目录，默认dubbo
        //System.out.println("zookeeper的地址是："+ZK_ADDRESS);
        return registryConfig;
    }

    public String getZkaddress() {
        return zkaddress;
    }

    public void setZkaddress(String zkaddress) {
        this.zkaddress = zkaddress;
    }

    public String getZkdigest() {
        return zkdigest;
    }

    public void setZkdigest(String zkdigest) {
        this.zkdigest = zkdigest;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getMirrorfile() {
        return mirrorfile;
    }

    public void setMirrorfile(String mirrorfile) {
        this.mirrorfile = mirrorfile;
    }
}
