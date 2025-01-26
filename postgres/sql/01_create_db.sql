-- データベースの作成
CREATE DATABASE book_management;

-- データベースの切り替え
\c book_management

-- テーブルの作成
CREATE TABLE book (
    uuid       uuid,
    title      VARCHAR(30),
    sort_order INTEGER,
    PRIMARY KEY(uuid)
);

-- 初期データの投入
INSERT INTO book VALUES ('6b502a7f-a01a-f687-5d1e-827c8d61805a', '【サンプル】博士の愛した数式'                        , 10);
INSERT INTO book VALUES ('a318c3f3-c55a-471b-e461-fdb8a7f6d5eb', '【サンプル】クライマーズ・ハイ'                      , 20);
INSERT INTO book VALUES ('246f4711-f062-f613-5794-f86da8ac22c1', '【サンプル】アヒルと鴨のコインロッカー'              , 30);
INSERT INTO book VALUES ('04962741-4385-5abf-f739-7988ea13ba18', '【サンプル】永遠の出口'                              , 40);
INSERT INTO book VALUES ('3c3ff28d-ee2a-01c5-c3c8-8d3bdfb4fbd2', '【サンプル】重力ピエロ'                              , 50);
INSERT INTO book VALUES ('8ded6160-fd24-ec2c-3f0c-801ad9231f23', '【サンプル】4TEEN'                                   , 60);
INSERT INTO book VALUES ('3d012d81-0f14-adca-b2ae-a35b9ce7e1a1', '【サンプル】デッドエンドの思い出'                    , 70);
INSERT INTO book VALUES ('cf8d1e36-515f-ce8a-1277-94ad5dee1828', '【サンプル】終戦のローレライ'                        , 80);
INSERT INTO book VALUES ('d6300689-8700-ac48-a882-a1bef89b4aeb', '【サンプル】陰摩羅鬼の瑕'                            , 90);
INSERT INTO book VALUES ('b5316c2b-d19e-39c9-0577-1e19aaece1bb', '【サンプル】ららら科學の子'                          , 100);
INSERT INTO book VALUES ('575367aa-898f-8bbf-ea06-adcb017b7656', '【サンプル】夜のピクニック'                          , 110);
INSERT INTO book VALUES ('18c03dd6-8654-7b79-6c52-496cfd004518', '【サンプル】明日の記憶'                              , 120);
INSERT INTO book VALUES ('0f99b858-15e4-d67d-18b4-a46176db0162', '【サンプル】家守綺譚'                                , 130);
INSERT INTO book VALUES ('b52c589f-e894-2309-d7d9-a861c8944605', '【サンプル】袋小路の男'                              , 140);
INSERT INTO book VALUES ('500bfde3-bc78-53c4-1d6f-699286480f32', '【サンプル】チルドレン'                              , 150);
INSERT INTO book VALUES ('42059755-2f4d-b5a1-9745-9ebb32ffc683', '【サンプル】対岸の彼女'                              , 160);
INSERT INTO book VALUES ('431e5ff6-05a5-f362-e831-a5c81304edbe', '【サンプル】犯人に告ぐ'                              , 170);
INSERT INTO book VALUES ('e9400bfc-e80c-883a-e850-e27d28f48d95', '【サンプル】黄金旅風'                                , 180);
INSERT INTO book VALUES ('4419406a-b1b2-2e08-725e-7f8a7e983d66', '【サンプル】私が語りはじめた彼は'                    , 190);
INSERT INTO book VALUES ('0a58b9ae-3e68-31f9-c4c7-dafd171703ea', '【サンプル】そのときは彼によろしく'                  , 200);
INSERT INTO book VALUES ('58787766-a5b1-23d9-e402-946d1bfc71ea', '【サンプル】東京タワー オカンとボクと、 時々、オトン', 210);
INSERT INTO book VALUES ('4999b83f-38d0-f249-0f64-7cac2c60a65d', '【サンプル】サウスバウンド'                          , 220);
INSERT INTO book VALUES ('8f09ff31-d314-bc50-a89d-1703cf2138d4', '【サンプル】死神の精度'                              , 230);
INSERT INTO book VALUES ('797e576d-66e7-2774-98cd-c3a637f52c4e', '【サンプル】容疑者Xの献身'                           , 240);
INSERT INTO book VALUES ('62b8f57c-c437-6344-2389-bc7ae3be35b6', '【サンプル】その日のまえに'                          , 250);
INSERT INTO book VALUES ('6d6be616-8335-e91e-b604-d6db228d40bf', '【サンプル】ナラタージュ'                            , 260);
INSERT INTO book VALUES ('3dd83ec8-14ef-b365-9182-52c73139f472', '【サンプル】告白'                                    , 270);
INSERT INTO book VALUES ('8a8f3833-378d-c93d-36e7-cdbc2a6b246e', '【サンプル】ベルカ、吠えないのか？'                  , 280);
INSERT INTO book VALUES ('4e347dc6-0597-bd07-087e-b708653a8b0c', '【サンプル】県庁の星'                                , 290);
INSERT INTO book VALUES ('4e7cecac-7247-186a-7309-641d05cf045f', '【サンプル】さくら'                                  , 300);
INSERT INTO book VALUES ('4e7cecac-7247-186a-7309-641d05cf045f', '【サンプル】魔王'                                    , 310);
