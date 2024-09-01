-- データベースの作成
CREATE DATABASE helloworld;

-- データベースの切り替え
\c helloworld

-- テーブルの作成
CREATE TABLE helloworld (
    id INTEGER,
    name VARCHAR
);

-- 初期データの投入
INSERT INTO helloworld VALUES (1, 'Lucina');