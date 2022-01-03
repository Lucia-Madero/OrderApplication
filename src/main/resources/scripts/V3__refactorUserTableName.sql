

alter table user_table
add column username varchar(20) unique not null,
    add column password varchar(20) not null;