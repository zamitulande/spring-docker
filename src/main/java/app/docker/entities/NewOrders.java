package app.docker.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewOrders {
    
    @Id
    @SequenceGenerator(
        name = "new_orders_sequence",
        sequenceName = "new_orders_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "new_orders_sequence",
        strategy = GenerationType.SEQUENCE
    )
    private Integer orderId;

    private String description;
    
    private double price;


    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "local_id",
        referencedColumnName = "localId"
    )
    private Local local;
}
