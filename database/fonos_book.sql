create table book
(
    id          int auto_increment
        primary key,
    author      varchar(255) null,
    image       longtext     null,
    intro       longtext     null,
    mp3         longtext     null,
    title       varchar(255) null,
    category_id int          null,
    constraint FKam9riv8y6rjwkua1gapdfew4j
        foreign key (category_id) references category (id)
);

INSERT INTO fonos.book (id, author, image, intro, mp3, title, category_id) VALUES (1, 'Triết lý lão tử ', 'https://drive.google.com/file/d/1N4YWXrU93JArRpR6u2c7RVTwg8nWgtgR/view?usp=sharing', '“Đạo Đức Kinh” là một cuốn triết thuyết nổi tiếng của tác giả người Trung Quốc, Lão Tử. Bởi vậy mà chúng ta đã có khá nhiều những bản dịch của “Đạo Đức Kinh”. Tuy nhiên, vì thuộc triết học nên có thể rất nhiều bạn sẽ e ngại khi đọc cuốn sách này.

Qua cuốn sách “Lão Tử Đạo Đức Kinh” của tác giả Nguyễn Hiến Lê, chúng ta sẽ hiểu hơn về những ý nghĩa của cuốn sách này.
Ngay từ phần mở đầu, cụ Nguyễn Hiến Lê đã cung cấp cho chúng ta những thông tin chi tiết và dễ hiểu nhất về vị triết gia Lão Tử và cuốn sách “Đạo Đức Kinh”. Từ đó, tác giả cũng đưa ra những đánh giá khách quan của mình về bộ sách này và kinh nghiệm đọc sách của ông. Thêm vào đó, tác giả còn đi sâu giải thích những câu chữ và triết lí chủ đạo của cuốn sách. Và cuối cùng cũng là phần quan trọng nhất của cuốn sách, đó chính là phần dịch tác phẩm.', 'https://drive.google.com/file/d/1IZZ4lXirlplYskOh-8WYSRSGAS1mqke8/view?usp=sharing', 'Đạo đức kinh', 1);