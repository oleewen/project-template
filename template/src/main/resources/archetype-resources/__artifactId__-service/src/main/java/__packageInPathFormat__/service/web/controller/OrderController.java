package ${package}.order.service.web.controller;

import ${package}.order.api.module.request.OrderBuyRequest;
import ${package}.order.api.module.response.OrderBuyResponse;
import ${package}.order.application.command.OrderBuyCommand;
import ${package}.order.application.result.OrderBuyResult;
import ${package}.order.application.service.OrderApplicationService;
import ${package}.order.service.factory.OrderCommandFactory;
import ${package}.order.service.factory.OrderResultFactory;
import org.springframework.ext.common.aspect.Call;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 交易控制器
 *
 * @author only
 * @date 2020-05-22
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    /** 订单流程 */
    @Resource
    private OrderApplicationService orderApplicationService;

    @PostMapping("/buy")
    @ResponseBody
    @Call(elapsed = 1200, sample = 10000)
    public OrderBuyResponse buy(@Valid @RequestBody OrderBuyRequest buyRequest, BindingResult bindingResult) {
        /** 处理参数验证错误 */
        if (bindingResult.hasErrors()) {
            // TODO
            return OrderBuyResponse.empty();
        }

        /** 请求转命令 */
        OrderBuyCommand buyCommand = OrderCommandFactory.asCommand(buyRequest);

        /** 交易下单 */
        OrderBuyResult buyResult = orderApplicationService.doBuy(buyCommand);

        /** 输出转换 */
        return OrderResultFactory.asResponse(buyResult);
    }

}
