package com.idfinance.model;

import com.idfinance.metadata.CurrencyMetadata;
import com.idfinance.metadata.UserCurrencyMetadata;
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
@Table(name = UserCurrencyMetadata.TABLE_NAME)
public class UserCurrency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = UserCurrencyMetadata.ID)
    private long id;
    @Column(name = UserCurrencyMetadata.USERNAME)
    private String username;
    @Column(name = UserCurrencyMetadata.SYMBOL)
    private String symbol;
    @Column(name = UserCurrencyMetadata.FIXEDPRICE)
    private BigDecimal fixedPrice;
}
