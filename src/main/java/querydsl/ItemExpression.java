package querydsl;

import com.mysema.query.annotations.QueryDelegate;
import com.mysema.query.types.expr.BooleanExpression;
import querydsl.domain.Item;
import querydsl.domain.QItem;

public class ItemExpression {

    @QueryDelegate((Item.class))
    public static BooleanExpression isExpensive(QItem item, Integer price) {
        return item.price.gt(price); //메소드 위임기능
    }
}
