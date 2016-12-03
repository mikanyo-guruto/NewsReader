# NewsReader

## 概要
googleのAPIを使ったニュースアプリ (http://news.google.com/news)  
取得したデータをローカルデータベースに保存し、オフラインでも見れるように  

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
