package com.example.prog4.repository.postgres2.entity;

import com.example.prog4.repository.postgres1.entity.Phone;
import com.example.prog4.repository.postgres1.entity.Position;
import com.example.prog4.repository.postgres1.entity.enums.Csp;
import com.example.prog4.repository.postgres1.entity.enums.Sex;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class CNAPSEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String cin;
    private String cnaps;
    @Column(name = "end_to_end_id")
    private String endToEndId;
    private String image;
    private String address;

    //TODO: foreach attribute with a camelcase change to snakecase because the hibernate cannot map
    //automatically after our configuration like i did it in the employee entity
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "personal_email")
    private String personalEmail;
    @Column(name = "professional_email")
    private String professionalEmail;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "entrance_date")
    private LocalDate entranceDate;
    @Column(name = "departure_date")
    private LocalDate departureDate;
    @Column(name = "children_number")
    private Integer childrenNumber;
}
