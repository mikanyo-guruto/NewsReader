# NewsReaderアプリ

## 概要
GoogleAPIを使用してニュースの一覧を取得する  
Googleニュース : http://news.google.com/news  
GoogleAPI参考サイト : http://tomehachi.sakura.ne.jp/blog/archives/486  

## 機能
* APIからデータを取得し、ローカルデータベースに保存
* ローカルデータベースから記事の一覧が見れる
* ユーザが必要無い記事は物理的削除が出来る

### 表示するデータ
* タイトル
* 内容
* 画像
* ニュースの地域
* ニュース日付

### 取得JSONパラメータ
* titleNoFormatting
* content
* image
* location
* publishedDate
