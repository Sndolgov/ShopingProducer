package telran.m2m.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Gran1 on 23/12/2018.
 */
@Data
@AllArgsConstructor
@Builder
public class ShoppingData {
    private int customerId;
    private int productId;
    private int cashboxId;

}
