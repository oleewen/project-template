package ${package}.order.application.action;

import ${package}.order.application.command.OrderBuyCommand;
import ${package}.goods.domain.facade.ItemQueryFacade;
import ${package}.goods.domain.model.Goods;
import ${package}.order.domain.model.Order;
import ${package}.order.domain.service.OrderDomainService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 订单创建
 *
 * @author only
 * @since 2020-05-22
 */
@Component
public class OrderCreateAction {
    /** 商品查询 */
    @Resource
    private ItemQueryFacade itemQueryFacade;
    /** 订单服务 */
    @Resource
    private OrderDomainService orderDomainService;

    public Order create(OrderBuyCommand buy) {
        /** 查询商品 */
        Goods goods = itemQueryFacade.requireGoods(buy.getGoodsId());

        /** 创建订单 */
        return orderDomainService.create(buy.getBuyerId(), goods, buy.getItemCount());
    }
}
