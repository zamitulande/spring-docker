package app.docker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {
    
    @Id
    @SequenceGenerator(
        name = "manager_sequence",
        sequenceName = "manager_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "manager_sequence",
        strategy = GenerationType.SEQUENCE
    )
    private Integer managerId;
    private String firstName;
    private String lastName;

    @OneToOne(
        mappedBy = "manager",
        fetch = FetchType.EAGER
    )
    private Local local;
}
