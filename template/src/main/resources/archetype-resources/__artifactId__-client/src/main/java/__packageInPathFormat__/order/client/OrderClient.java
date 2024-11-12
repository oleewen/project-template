package ${package}.order.client;

import ${package}.order.api.module.request.OrderBuyRequest;
import ${package}.order.api.module.response.OrderBuyResponse;
import ${package}.order.api.OrderService;
import com.transformer.log.annotation.Call;

public class OrderClient implements OrderService {
    @Override
    @Call(elapsed = 1200, sample = 10000)
    public OrderBuyResponse buy(OrderBuyRequest buyRequest) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

