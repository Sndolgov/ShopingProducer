package telran.m2m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Gran1 on 23/12/2018.
 */
@SpringBootApplication
public class DataGeneratorAppl {
    private static final long TIME_OUT = 10000;

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(DataGeneratorAppl.class, args);
        Thread.sleep(TIME_OUT);
        ctx.close();

    }
}
