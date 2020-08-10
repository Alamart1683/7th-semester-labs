create table study_group(
    id int not null auto_increment,
    name text not null,
    primary key (id)
);

create table student(
    id int not null auto_increment,
    surname text not null,
    name text not null,
    second_name text not null,
    study_group_id int not null,
    primary key (id),
    foreign key (study_group_id) references study_group(id)
);

create table subject(
    id int not null auto_increment,
    name text not null,
    short_name text not null,
    primary key (id)
);

create table exam_type(
    id int not null auto_increment,
    type text not null,
    primary key (id)
);

create table study_plan(
    id int not null auto_increment,
    subject_id int not null,
    exam_type_id int not null,
    primary key (id),
    foreign key (subject_id) references subject(id),
    foreign key (exam_type_id) references exam_type(id)
);

create table mark(
    id int not null auto_increment,
    name text not null ,
    value text not null,
    primary key (id)
);

create table journal(
    id int not null auto_increment,
    student_id int not null,
    study_plan_id int not null,
    in_time bit not null,
    count int not null,
    mark_id int not null,
    primary key (id),
    foreign key (student_id) references student(id),
    foreign key (study_plan_id) references study_plan(id),
    foreign key (mark_id) references mark(id)
);
