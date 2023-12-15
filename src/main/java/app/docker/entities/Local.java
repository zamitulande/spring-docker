package app.docker.entities;

import java.util.List;

//import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@ToString(exclude = "manager")
public class Local {
    
    @Id
    @SequenceGenerator(
        name = "local_sequence",
        sequenceName = "local_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "local_sequence",
        strategy = GenerationType.SEQUENCE
    )
    private Integer localId;
    private String name;
    private String floor;

    @OneToOne(
        cascade = CascadeType.PERSIST,
        fetch = FetchType.EAGER
    )
    @JoinColumn(
        name = "manager_id",
        referencedColumnName = "managerId"
    )
    @NotNull
    private Manager manager;

    @ManyToMany(
        cascade = CascadeType.ALL
    )
    @JoinTable(
        name = "local_customer_map",
        joinColumns = @JoinColumn(
                name="local_id",
                referencedColumnName = "localId"
        ),
        inverseJoinColumns = @JoinColumn(
                name = "costumer_id",
                referencedColumnName = "costumerId"
        )

    )
    private List<Customer> customersList;

    // @OneToMany(
    //     cascade = CascadeType.ALL,
    //     fetch = FetchType.EAGER
    // )
    // @JoinColumn(
    //     name = "local_id",
    //     referencedColumnName = "localId"
    // )
    // private List<NewOrders> newOrders;
}
