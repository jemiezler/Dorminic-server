package com.dorminic.auth.entites;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "_organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orgID;

    @Column(name = "name", nullable = false)
    @Size(max = 100)
    private String OrgName;

    @Column(name = "orgkey", nullable = false)
    @Size(max = 100)
    private String orgkey;

    @Column(name = "orgverify", nullable = false)
    @Size(max = 100)
    private String orgverify;
}
