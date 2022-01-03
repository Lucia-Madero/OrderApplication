create table email
(
    id       uuid        not null primary key,
    username varchar(20) not null,
    domain   varchar(30) not null
);

create table address
(
    id           uuid        not null primary key,
    streetName   varchar(20) not null,
    streetNumber varchar(10) not null,
    postCode     varchar(10) not null,
    city         varchar(20) not null
);

create table phone_number
(
    prefix varchar(5) not null,
    number varchar(15) not null,
    primary key (prefix,number)
);

drop table phone_number;

create table phone_number
(
    id uuid not null primary key,
    prefix varchar(5) not null,
    number varchar(15) not null
);

create table "user"
(
    id uuid not null primary key,
    firstName varchar(20) not null,
    lastName varchar(30) not null,
    fk_email uuid unique not null,
    fk_address uuid not null,
    fk_phone_number uuid,
    constraint fk_user_email foreign key (fk_email) references email (id),
    constraint fk_user_address foreign key (fk_address) references address (id),
    constraint fk_user_phone_number foreign key (fk_phone_number) references phone_number(id)
);

