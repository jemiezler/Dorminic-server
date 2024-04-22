package com.dorminic.function.billservice.common;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.dorminic.auth.entites.Organization;
import com.dorminic.auth.entites.User;
import com.dorminic.auth.enums.Paid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "_commonbill")
public class CommonBillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billid;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "month", nullable = false)
    private Integer month;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "water", nullable = false)
    private Float water;

    @Column(name = "electric", nullable = false)
    private Float electric;

    @Column(name = "rental", nullable = false)
    private Float rental;

    @Column(name = "isPaid", nullable = false)
    private Paid Paid;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "orgID", nullable = true)
    private Organization organization;
    
}
