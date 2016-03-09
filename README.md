# webapp-model
webアプリケーションのベースモデル

## 目的
webアプリケーションとして必要な機能を最小限で実装し、webアプリケーション開発時に汎用的に利用可能なベースモデルを作成すること。

## 実装機能
* 匿名ユーザ(ANONYMOUS)
  - アカウントの作成
  - ログイン

* 認証ユーザ(ROLE_USER)
  - アカウントの閲覧
  - アカウントの削除
  - ログアウト

* 管理者(ROLE_ADMIN)
  - アカウントの閲覧
  - アカウントの凍結/解除
  - ログアウト

## Eclipseへのインポート方法
* English
  - File→Import→Maven→Existing Maven Projects
* 日本語
  - ファイル→インポート→Maven→既存 Maven プロジェクト

## キーワード
Java, SpringFramework, Maven, PostgreSQL
