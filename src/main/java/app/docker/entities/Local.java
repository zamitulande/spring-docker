package app.docker.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
        fetch = FetchType.EAGER,
        optional = false
    )
    @JoinColumn(
        name = "manager_id",
        referencedColumnName = "managerId"
    )
    private Manager manager;

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    @JoinColumn(
        name = "local_id",
        referencedColumnName = "localId"
    )
    private List<NewOrders> newOrders;
}
