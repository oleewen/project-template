package ${package}.goods.infrastructure.dal;

import ${package}.goods.domain.model.Goods;
import ${package}.goods.domain.repository.GoodsRepository;
import ${package}.goods.infrastructure.call.GoodsCall;
import ${package}.goods.infrastructure.entity.GoodsEntity;
import ${package}.goods.infrastructure.factory.GoodsFactory;
import com.transformer.log.annotation.Call;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 商品数据访问层
 *
 * @author only
 * @since 2020-05-22
 */
@Repository
public class GoodsDal implements GoodsRepository {
    /** 商品服务 */
    @Resource
    private GoodsCall goodsCall;

    @Override
    @Call
    public Goods acquireGoods(Long goodsId) {
        GoodsEntity goods = goodsCall.getGoodsById(goodsId);

        return GoodsFactory.valueOf(goods);
    }
}
