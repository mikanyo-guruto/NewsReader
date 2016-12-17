# NewsReaderアプリ

## 概要
QiitaAPIを使用してニュースの一覧を取得する  
  
Qiita記事最新の一覧 http://qiita.com/api/v2/items

参考サイト
Qiita API 公式
http://qiita.com/api/v2/docs#get-apiv2items
Qiita API v2 の概要
http://qiita.com/tag1216/items/b0b90e30c7e581aa2b00


## 機能
* APIからデータを取得し、ローカルデータベースに保存
* ローカルデータベースから記事の一覧が見れる
* ユーザが必要無い記事は物理的削除が出来る

### 一覧表示する際のキー
* title タイトル
* url 詳細url
* created_at 作成日
* tags:name 記事についているタグ
* body 本文
