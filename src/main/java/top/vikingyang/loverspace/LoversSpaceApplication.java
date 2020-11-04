package top.vikingyang.loverspace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.vikingyang.loverspace.mapper")
public class LoversSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoversSpaceApplication.class, args);
    }

}
