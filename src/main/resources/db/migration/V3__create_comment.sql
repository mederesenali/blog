use blog;
create table comment(
    id int not null auto_increment,
    comment varchar(255) not null ,
    local_date date,
    blog_id int,
    blogger_id int,
    foreign key (blog_id) references blog(id),
    foreign key (blogger_id) references blogger(id),
    primary key (id)
)