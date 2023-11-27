package app.docker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Customer {

    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "customer_sequence",
            strategy = GenerationType.IDENTITY
    )
    @Id
    private Integer costumer;

    private String firstName;

    private String lastName;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @Embedded
    private Address address;

}
