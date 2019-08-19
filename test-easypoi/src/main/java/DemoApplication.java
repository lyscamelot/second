import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lxf
 */
@SpringBootApplication(scanBasePackages = {"textpoi","system","common","config"})
@MapperScan(basePackages = "*.mapper")
@EnableAutoConfiguration
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("启动成功");
	}
}
