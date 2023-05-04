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
create table questions
(
    id      bigint not null auto_increment,
    text    varchar(255),
    test_id bigint,
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
create table testhasquestion
(
    id          bigint  not null auto_increment,
    quantity    integer not null,
    question_id bigint,
    test_id_1   bigint,
    primary key (id)
) engine = InnoDB;
create table user_answers
(
    id          bigint not null auto_increment,
    answer      varchar(255),
    user_answers_question_id bigint,
    user_answers_test_id     bigint,
    user_id     bigint,
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
alter table questions
    add constraint FK_test_id foreign key (test_id) references test (id);
alter table student
    add constraint FK_id foreign key (id) references users (id);
alter table test
    add constraint FK_category_id foreign key (category_id) references category (id);
alter table testhasquestion
    add constraint FK_question_id foreign key (question_id) references questions (id);
alter table testhasquestion
    add constraint FK_test_id_1 foreign key (test_id_1) references test (id);
alter table user_answers
    add constraint FK_user_answers_question_id foreign key (user_answers_question_id) references questions (id);
alter table user_answers
    add constraint FK_user_answers_test_id foreign key (user_answers_test_id) references test (id);
alter table user_answers
    add constraint FK_user_id foreign key (user_id) references users (id);
alter table users_roles
    add constraint FK_roles_id foreign key (roles_id) references fix_role (id);
alter table users_roles
    add constraint FK_users_set_id foreign key (users_set_id) references users (id);