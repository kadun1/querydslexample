package querydsl.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SqlResultSetMapping(name = "OrderResults",
    entities = {
        @EntityResult(entityClass = Order.class, fields = {
                @FieldResult(name = "id", column = "order_id"),
                @FieldResult(name = "quantity", column = "order_quantity"),
                @FieldResult(name = "item", column = "order_item")})},
        columns = {
        @ColumnResult(name = "item_name")}
)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

}
