package com.idfinance.metadata;

public final class CurrencyMetadata {
    private CurrencyMetadata(){

    }

    public static final String TABLE_NAME = "currency";
    public static final String DB_PREFIX = "c_";
    public static final String ID = DB_PREFIX + "id";
    public static final String SYMBOL = DB_PREFIX + "symbol";
    public static final String PRICE = DB_PREFIX + "price";

}
