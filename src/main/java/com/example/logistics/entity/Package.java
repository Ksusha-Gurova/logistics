package com.example.logistics.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeBox size;
    private Double weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "from_client_id")
    private Client fromClientId;

    @ManyToOne
    @JoinColumn(name = "to_client_id")
    private Client toClientId;

    @ManyToOne
    @JoinColumn(name = "from_office_id")
    private Office fromOfficeId;

    @ManyToOne
    @JoinColumn(name = "to_office_id")
    private Office toOfficeId;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courierId;

    private LocalDate dateOfReceipt;
    private LocalDate dateOfIssue;

}
