create table attribute
(
    id          bigint not null auto_increment,
    description varchar(255),
    name        varchar(255),
    unit        varchar(255),
    primary key (id)
) engine = InnoDB;
create table attributehastest
(
    id           bigint not null auto_increment,
    attribute_id bigint,
    tests_id      bigint,
    primary key (id)
) engine = InnoDB;
create table category
(
    id          bigint not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    primary key (id)
) engine = InnoDB;
create table fix_role
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table orders
(
    id         bigint not null auto_increment,
    datatest   date,
    datatime   date,
    image      varchar(255),
    student_id bigint,
    primary key (id)
) engine = InnoDB;
create table student
(
    id      bigint not null,
    email   varchar(255),
    name    varchar(255),
    surname varchar(255),
    primary key (id)
) engine = InnoDB;
create table test
(
    id          bigint not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    points      decimal(38, 2),
    category_id bigint,
    primary key (id)
) engine = InnoDB;
create table testhasorder
(
    id       bigint  not null auto_increment,
    quantity integer not null,
    order_id bigint,
    test_id  bigint,
    primary key (id)
) engine = InnoDB;
create table users
(
    id       bigint not null auto_increment,
    password varchar(255),
    username varchar(255),
    primary key (id)
) engine = InnoDB;
create table users_roles
(
    users_set_id bigint not null,
    roles_id     bigint not null,
    primary key (users_set_id, roles_id)
) engine = InnoDB;
alter table attributehastest
    add constraint FK_attribute_id foreign key (attribute_id) references attribute (id);
alter table attributehastest
    add constraint FK_tests_id foreign key (tests_id) references test (id);
alter table orders
    add constraint FK_student_id foreign key (student_id) references student (id);
alter table student
    add constraint FK_id foreign key (id) references users (id);
alter table test
    add constraint FK_category_id foreign key (category_id) references category (id);
alter table testhasorder
    add constraint FK_order_id foreign key (order_id) references orders (id);
alter table testhasorder
    add constraint FK_test_id foreign key (test_id) references test (id);
alter table users_roles
    add constraint FK_roles_id foreign key (roles_id) references fix_role (id);
alter table users_roles
    add constraint FK_users_set_id foreign key (users_set_id) references users (id);

