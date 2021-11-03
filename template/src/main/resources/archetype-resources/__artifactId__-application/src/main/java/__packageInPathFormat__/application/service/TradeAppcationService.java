package ${package}.application.service;

import ${package}.application.action.InventoryLockAction;
import ${package}.application.action.OrderCreateAction;
import ${package}.application.action.OrderEnableAction;
import ${package}.application.command.TradeBuyCommand;
import ${package}.application.result.TradeBuyResult;
import ${package}.order.domain.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 交易流程
 *
 * @author only
 * @date 2020-05-22
 */
@Component
public class TradeAppcationService {
    /** 库存锁定 */
    @Resource
    private InventoryLockAction inventoryLockAction;
    /** 订单创建 */
    @Resource
    private OrderCreateAction orderCreateAction;
    /** 订单生效 */
    @Resource
    private OrderEnableAction orderEnableAction;

    /**
     * 交易创建流程
     *
     * @param buy 交易请求
     *
     * @return 交易创建结果
     */
    public TradeBuyResult doBuy(TradeBuyCommand buy) {
        /** 创建交易订单 */
        Order order = orderCreateAction.create(buy);

        /** 锁定商品库存 */
        boolean locked = inventoryLockAction.lock(order);

        /** 设置订单可见 */
        if (locked) {
            orderEnableAction.enable(order);
        }

        // 结果封装
        return TradeBuyResult.create(order);
    }
}

