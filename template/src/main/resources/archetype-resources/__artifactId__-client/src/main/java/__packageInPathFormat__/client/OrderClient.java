package ${package}.order.client;

import ${package}.order.api.service.DemoService;

public class OrderClient implements OrderService {
    @Override
    @Call(elapsed = 1200, sample = 10000)
    public OrderBuyResponse buy(OrderBuyRequest buyRequest) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

