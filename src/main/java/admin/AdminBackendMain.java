package admin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("admin.dao")
@Slf4j
public class AdminBackendMain {
    public static void main(String[] args) {
        SpringApplication.run(AdminBackendMain.class, args);

        log.info("AdminBackendMain success!");
    }
}
