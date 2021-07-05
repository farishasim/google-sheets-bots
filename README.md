# Google Sheets Bots

## Prerequisites
Untuk menjalankan program, ada beberapa hal yang perlu anda siapkan, yaitu:
1. Java >= 1.8
2. Gradle >= 2.3
3. Aktifkan Google Sheet Api (panduan pada link [berikut](https://developers.google.com/workspace/guides/create-project))
4. Dapatkan credentials.json (panduan pada link [berikut](https://developers.google.com/workspace/guides/create-credentials)). Setelah mendapatkan file json berisikan credential, masukkan isi file tersebut ke `src > main > resources > credentials.json`
5. Buatlah Google Spreadsheet baru, kemudian masukkan id dari spreadsheet tersebut ke `src > main > java > writer > SheetWriter.java`, pada atribut `SPREADSHEET_ID` 

## Compile
Program dapat di-build dengan perintah berikut
```
gradle build
```

## Run
Program dapat dijalankan dengan perintah berikut
```
gradle run
```