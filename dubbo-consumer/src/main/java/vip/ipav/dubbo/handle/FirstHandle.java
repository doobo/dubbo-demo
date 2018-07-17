package vip.ipav.dubbo.handle;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.ipav.dubbo.service.ConfigService;
import vip.ipav.dubbo.service.DemoService;

public class FirstHandle {

    public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        DemoService demoService = context.getBean(DemoService.class);
        System.out.println("consumer");
        System.out.println(demoService.getPermissions(187L));

        //第二个服务
        ConfigService configService = (ConfigService)context.getBean("configService");
        System.out.println(configService.baseConfig());
    }
}
