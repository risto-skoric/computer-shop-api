package risto.computer.shop.api.customer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
@Entity
@Table(name = "computer" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private Integer computer_id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "processor")
    @NotEmpty
    private String processor;

    @Column(name = "installed_ram")
    @NotEmpty
    private String installedRam;

    @OneToOne(mappedBy = "computer", cascade = CascadeType.ALL)
    @JsonBackReference
    private Customer customer;
}