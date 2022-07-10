package com.idfinance.model;

import com.idfinance.metadata.CurrencyMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = CurrencyMetadata.TABLE_NAME)
public class Currency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CurrencyMetadata.ID)
    private long id;
    @Column(name = CurrencyMetadata.SYMBOL)
    private String symbol;
    @Column(name = CurrencyMetadata.PRICE)
    private BigDecimal price;
}
