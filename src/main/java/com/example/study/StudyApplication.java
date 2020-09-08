package com.example.study;

import com.example.study.Utils.DateUtil;
import com.example.study.config.DefaultProfileUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Date;

@ComponentScan(basePackages = "com.example")
@ServletComponentScan(basePackages = "com.example")
@SpringBootApplication
public class StudyApplication {
    private static final Logger log = LoggerFactory.getLogger(StudyApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(StudyApplication.class, args);

        SpringApplication app = new SpringApplication(StudyApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);


        Date yesterdayDate = Date.from(Instant.now());
        Instant startTime = DateUtil.formatStartTime(yesterdayDate.getTime());
        Instant endTime = DateUtil.formatEndTime(yesterdayDate.getTime());

        System.out.println(startTime);
        System.out.println(endTime);

        Instant startTime4 = DateUtil.formatStartTime(System.currentTimeMillis());
        Instant endTime4 = DateUtil.formatEndTime(System.currentTimeMillis());

        System.out.println(startTime4);
        System.out.println(endTime4);

        if (3>= 2){
            System.out.println("dfdfd");
        }



        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);

    }
    private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),

                protocol,
                serverPort,
                contextPath,

                protocol,
                hostAddress,
                serverPort,
                contextPath,

                env.getActiveProfiles());

        String configServerStatus = env.getProperty("configserver.status");
        if (configServerStatus == null) {
            configServerStatus = "Not found or not setup for this application";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Config Server: \t{}\n----------------------------------------------------------", configServerStatus);
    }

}
