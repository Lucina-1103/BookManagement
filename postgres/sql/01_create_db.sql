-- データベースの作成
CREATE DATABASE book_management;

-- データベースの切り替え
\c book_management

-- テーブルの作成
CREATE TABLE book (
    uuid uuid,
    name VARCHAR
);

-- 初期データの投入
INSERT INTO book VALUES ('6b502a7f-a01a-f687-5d1e-827c8d61805a', 'サンプル書籍名１');
INSERT INTO book VALUES ('a318c3f3-c55a-471b-e461-fdb8a7f6d5eb', 'サンプル書籍名２');
INSERT INTO book VALUES ('246f4711-f062-f613-5794-f86da8ac22c1', 'サンプル書籍名３');
