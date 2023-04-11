package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args)throws Exception {
        String webappDirLocation = "webapps/"; // 해당 디렉토리 있어야 함 -> 톰캣의 루트 디렉토리
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        //톰캣을 8080포트로 실행할거다

        tomcat.addWebapp("/",new File(webappDirLocation).getAbsolutePath());
        //톰캣의 웹앱(루트 디렉토리)으로 브라우저에서 접근했을 때 루트 밑에서 찾는다

        log.info("configureing app woth basedir : {}", new File ("./"+webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();


    }
}
