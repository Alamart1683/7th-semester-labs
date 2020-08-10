create table study_group(
    id int not null,
    name text not null,
    primary key (id)
);

create table student(
    id int not null,
    surname text not null,
    name text not null,
    second_name text not null,
    study_group_id int not null,
    primary key (id),
    foreign key (study_group_id) references study_group(id)
);

create table student_local(
    id int not null,
    surname text not null,
    name text not null,
    second_name text not null,
    study_group_id int not null,
    primary key (id),
    foreign key (study_group_id) references study_group(id)
);

create table subject(
    id int not null,
    name text not null,
    short_name text not null,
    primary key (id)
);

create table exam_type(
    id int not null,
    type text not null,
    primary key (id)
);

create table study_plan(
    id int not null,
    subject_id int not null,
    exam_type_id int not null,
    primary key (id),
    foreign key (subject_id) references subject(id),
    foreign key (exam_type_id) references exam_type(id)
);

create table mark(
    id int not null,
    name text not null ,
    value text not null,
    primary key (id)
);

create table journal(
    id int not null,
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

insert into study_group (id, name) values
(1, 'ИВБО-06-17'),
(2, 'ИКБО-07-18'),
(3, 'ИКБО-11-19'),
(4, 'ИКБО-12-17');

insert into student_local (id, surname, name, second_name, study_group_id) values
(2281480, 'Петрушинин', 'Альберт', 'Евлампович', 3),
(2281481, 'Данковский', 'Андриан', 'Прохорович', 3),
(2281482, 'Понятовский', 'Соломон', 'Давидович', 2),
(2281483, 'Тугодумова', 'Лилия', 'Абрамовна', 1),
(2281484, 'Хазбуллатов', 'Илья', 'Иосифович', 2),
(2281485, 'Орлова', 'Евгения', 'Васильевна', 3),
(2281486, 'Кучин', 'Эдуард', 'Викторович', 1),
(2281487, 'Понасенков', 'Евгений', 'Николаевич', 4),
(2281488, 'Лисовой', 'Андрей', 'Анатольевич', 4);

insert into subject (id, name, short_name) values
(1, 'Проектирование информационных систем', 'ПрИС'),
(2, 'Системы искусственного интеллекта', 'СИИ'),
(3, 'Программная инженерия', 'ПИ'),
(4, 'Национальная система информационной безопасности', 'НСИБ'),
(5, 'Системный анализ', 'СисАнал'),
(6, 'Распределенные базы данных', 'РБД'),
(7, 'Системное программное обеспечение', 'СПО');

insert into exam_type (id, type) values
(1, 'Экзамен'),
(2, 'Зачет'),
(3, 'Зачет с оценкой'),
(4, 'Курсовая');

insert into study_plan (id, subject_id, exam_type_id) values
(1, 1, 1),
(2, 1, 4),
(3, 2, 1),
(4, 3, 1),
(5, 4, 2),
(6, 5, 1),
(7, 6, 2),
(8, 7, 1);

insert into mark (id, name, value) values
(1, 'Отлично', 5),
(2, 'Хорошо', 4),
(3, 'Удовлетворительно', 3),
(4, 'Неудовлетворительно', 2),
(5, 'Зачет', 'з'),
(6, 'Незачет', 'н'),
(7, 'Неявка', '');