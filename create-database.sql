-- タイムゾーンの設定
SET TIME ZONE 'Asia/Tokyo';

-- ユーザアカウントテーブル作成
CREATE TABLE accounts (
  -- ID
  id varchar(20) PRIMARY KEY,
  -- 表示名
  name varchar(20) NOT NULL,
  -- パスワード
  password varchar(100) NOT NULL,
  -- 有効フラグ
  enabled boolean NOT NULL,
  -- 権限区分
  role integer NOT NULL,
  -- 登録日時
  registered timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- 更新日時
  updated timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 管理者アカウント作成
INSERT INTO accounts VALUES (
  -- ID
  'admin',
  -- 表示名
  '管理者',
  -- パスワード
  '********************',
  -- 有効フラグ
  true,
  -- 権限区分
  '1'
);

-- 認証ユーザアカウント作成
INSERT INTO accounts VALUES (
  -- ID
  'user',
  -- 表示名
  'ユーザ',
  -- パスワード
  '********************',
  -- 有効フラグ
  true,
  -- 権限区分
  '2'
);
