package ${package}.order.service.factory;

import ${package}.order.api.module.dto.OrderBuyDTO;
import ${package}.order.application.result.OrderBuyResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author only
 * @date 2022-05-27
 */
@Mapper
public interface OrderBuyDTOFactory {
    OrderBuyDTOFactory INSTANCE = Mappers.getMapper(OrderBuyDTOFactory.class);

    OrderBuyDTO toDTO(OrderBuyResult result);
}
