package indi.xg;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XgApplication {

    public static void main(String[] args) {
        // 静态方法启动
//        SpringApplication.run(XgApplication.class, args);
        SpringApplication springApplication = new SpringApplication(XgApplication.class);
        // 启动图标
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
