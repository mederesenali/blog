use blog;
create table blogger(
    id int not null auto_increment,
    email varchar(45),
    password varchar(128),
    name varchar(45),
    enabled bit,
    role varchar(45),
    primary key (id)
);