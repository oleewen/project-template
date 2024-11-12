package ${package}.order.api.module.request;

import lombok.Data;
import com.transformer.request.Request;

@Data
public class OrderBuyRequest implements Request {
    @Override
    public boolean validator() {
        return true;
    }
}
