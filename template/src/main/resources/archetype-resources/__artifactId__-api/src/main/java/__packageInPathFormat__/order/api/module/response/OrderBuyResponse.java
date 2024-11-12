package ${package}.order.api.module.response;

import com.sun.tms.order.api.module.dto.OrderBuyDTO;
import com.transformer.response.Result;
import lombok.Data;

@Data
public class OrderBuyResponse<T> extends Result<OrderBuyDTO> {
    private static final OrderBuyResponse DEFAULT_RESPONSE = new OrderBuyResponse();

    public static OrderBuyResponse empty() {
        return DEFAULT_RESPONSE;
    }

    public static OrderBuyResponse success() {
        return new OrderBuyResponse();
    }
}
