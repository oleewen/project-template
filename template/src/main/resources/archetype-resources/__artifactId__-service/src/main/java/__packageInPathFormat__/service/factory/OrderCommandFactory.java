package ${package}.order.service.factory;

import ${package}.order.api.module.request.OrderBuyRequest;
import ${package}.order.application.command.OrderBuyCommand;
import com.transformer.helper.BeanHelper;

public class OrderCommandFactory {
    public static OrderBuyCommand asCommand(OrderBuyRequest buyRequest) {
        OrderBuyCommand command = BeanHelper.copyProperties(new OrderBuyCommand(), buyRequest);
        return command;
    }
}
