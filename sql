create table currency
(
    c_id     bigint unsigned auto_increment
        primary key,
    c_symbol varchar(5)     not null,
    c_price  decimal(10, 3) null,
    constraint currency_c_id_uindex
        unique (c_id),
    constraint currency_c_symbol_uindex
        unique (c_symbol)
);

create table user_currency
(
    uc_id         bigint unsigned auto_increment
        primary key,
    uc_username   varchar(20)    not null,
    uc_symbol     varchar(5)     not null,
    uc_fixedprice decimal(10, 3) null,
    constraint user_currency_key
        unique (uc_username, uc_symbol),
    constraint user_currency_uc_id_uindex
        unique (uc_id)
);
