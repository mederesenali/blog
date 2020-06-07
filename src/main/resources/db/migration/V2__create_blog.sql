use blog;
create table blog(
    id int not null auto_increment,
    title varchar(45),
    content varchar(255),
    local_date date,
    author_id int,
    foreign key (author_id) references blogger(id),
    primary key(id)
)