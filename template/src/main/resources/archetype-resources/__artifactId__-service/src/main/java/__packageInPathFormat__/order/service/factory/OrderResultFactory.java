package ${package}.order.service.factory;

import ${package}.order.api.module.dto.OrderBuyDTO;
import ${package}.order.api.module.response.OrderBuyResponse;
import ${package}.order.application.result.OrderBuyResult;

public class OrderResultFactory {
    public static OrderBuyResponse asResponse(OrderBuyResult buyResult) {
        OrderBuyResponse response = OrderBuyResponse.success();
        OrderBuyDTO buyDTO = OrderBuyDTOFactory.INSTANCE.toDTO(buyResult);
        response.setModule(buyDTO);
        return response;
    }
}
