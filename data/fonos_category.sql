create table category
(
    id   int auto_increment
        primary key,
    name varchar(255) null
);

INSERT INTO fonos.category (id, name) VALUES (1, 'Sách kinh điển mọi thời đại');
INSERT INTO fonos.category (id, name) VALUES (2, 'Sách nói miễn phí');
INSERT INTO fonos.category (id, name) VALUES (3, 'Tư duy - Kỹ năng ');
INSERT INTO fonos.category (id, name) VALUES (4, 'Tác giả Việt Nam ');
INSERT INTO fonos.category (id, name) VALUES (5, 'Lãnh đạo');
INSERT INTO fonos.category (id, name) VALUES (6, 'Tâm lý');
INSERT INTO fonos.category (id, name) VALUES (7, 'Tác giả châu Á');
INSERT INTO fonos.category (id, name) VALUES (8, 'Dành cho người trẻ');