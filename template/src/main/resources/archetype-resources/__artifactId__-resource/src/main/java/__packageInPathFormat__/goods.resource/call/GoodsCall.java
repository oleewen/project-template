package ${package}.goods.resource.call;

import org.springframework.stereotype.Repository;
import ${package}.goods.resource.entity.GoodsEntity;

/**
 * 商品服务
 *
 * @author only
 * @since 2020-05-22
 */
@Repository
public interface GoodsCall {
    GoodsEntity getGoodsById(Long goodsId);
}
