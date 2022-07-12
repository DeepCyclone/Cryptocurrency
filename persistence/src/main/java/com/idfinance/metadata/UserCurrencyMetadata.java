package com.idfinance.metadata;

public final class UserCurrencyMetadata {
    private UserCurrencyMetadata(){

    }

    public static final String TABLE_NAME = "user_currency";
    public static final String DB_PREFIX = "uc_";
    public static final String ID = DB_PREFIX + "id";
    public static final String USERNAME = DB_PREFIX + "username";
    public static final String SYMBOL = DB_PREFIX + "symbol";
    public static final String FIXEDPRICE = DB_PREFIX + "fixedprice";

}
