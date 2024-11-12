package ${package}.order.application.action;

import ${package}.order.domain.model.Order;
import ${package}.order.domain.service.OrderDomainService;

import javax.annotation.Resource;

/**
 * 订单生效
 *
 * @author only
 * @since 2020-05-27
 */
public class OrderEnableAction {
    /** 订单服务 */
    @Resource
    private OrderDomainService orderDomainService;

    public void enable(Order order) {
        /** 设置订单可见 */
        orderDomainService.enable(order);
    }
}
