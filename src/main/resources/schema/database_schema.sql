create sequence hibernate_sequence start with 1 increment by 1
create table address (id integer not null, city varchar(255), number varchar(255), state varchar(255), street varchar(255), type varchar(255), unit varchar(255), zip_code varchar(255), address_id integer, primary key (id))
create table communication (id integer not null, preferred varchar(255), type varchar(255), value varchar(255), communication_id integer, primary key (id))
create table contact (id integer not null, identification_id integer, primary key (id))
create table identification (id integer not null, date_of_birth varchar(255), first_name varchar(255), gender varchar(255), last_name varchar(255), title varchar(255), primary key (id))
alter table address add constraint FKelqk7bsyfpos6fdldoegcef9w foreign key (address_id) references contact
alter table communication add constraint FK6w5ale82twrmgxe4ka0h1266p foreign key (communication_id) references contact
alter table contact add constraint FK3e9yyptiqot1osaurdvd2cawa foreign key (identification_id) references identification
