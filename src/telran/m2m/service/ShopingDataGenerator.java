package telran.m2m.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import telran.m2m.dto.ShoppingData;

import java.util.Random;

/**
 * Created by Gran1 on 23/12/2018.
 */

@EnableBinding(Source.class)
public class ShopingDataGenerator {
    private ObjectMapper mapper = new ObjectMapper();
    private Random random = new Random();
    @Value("${customer_id_min_value:1}")
    int customerIdMinValue;
    @Value("${customer_id_max_value:10}")
    int customerIdMaxValue;
    @Value("${product_id_min_value:1}")
    int productIdMinValue;
    @Value("${product_id_max_value:10}")
    int productIdMaxValue;
    @Value("${cashbox_id_min_value:1}")
    int cashboxIdMinValue;
    @Value("${cashbox_id_max_value:10}")
    int cashboxIdMaxValue;


    private int nSensors;
    private int i = 1;


    @InboundChannelAdapter(value = Source.OUTPUT, poller=@Poller(fixedDelay="${fixedDelay:1000}", maxMessagesPerPoll="${nMessages:1}"))
    public String getSensorData() throws JsonProcessingException {
        ShoppingData sensor = getRandomSensor();
        System.out.println(i++);
        return mapper.writeValueAsString(sensor);
    }

    private ShoppingData getRandomSensor() {

        return ShoppingData.builder ()
                .customerId ( getRandomNumber ( customerIdMinValue, customerIdMaxValue ) )
                .productId ( getRandomNumber ( productIdMinValue, productIdMaxValue )  )
                .cashboxId ( getRandomNumber ( cashboxIdMinValue, cashboxIdMaxValue )  )
                .build ();
    }

    private int getRandomNumber(int min, int max) {
        return random.ints(1, min, max+1).findFirst().getAsInt();
    }
}
