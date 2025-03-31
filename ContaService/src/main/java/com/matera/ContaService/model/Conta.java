package com.matera.ContaService.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column
    private String nome;

    @Column
    private Integer agencia;

    @Column
    private Integer conta;

    @Column
    private String chavePix;

    @Column
    private BigDecimal saldo = BigDecimal.ZERO;

    /*
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pix> historicoPix = new ArrayList<>();
    */

    public void sacar (BigDecimal valor) {saldo = this.saldo.subtract(valor);}

    public void depositar (BigDecimal valor) {saldo = this.saldo.add(valor);}

}
