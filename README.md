# 📜 동행복권 MSA 로또 구매내역 파트

## 📃 프로젝트 소개
동행복권 인터넷 구매를 참고하여 로또 구매 파트와 구매내역 파트를 구현하였습니다.

### Lotto Perchase Server
https://github.com/encore-full-stack-5/NODAJU_Lotto_Perchase
### Lotto Analitics Server
https://github.com/encore-full-stack-5/NODAJI_LOTTO_ANALITICS_BE
### Front-End
https://github.com/encore-full-stack-5/DH_lottery

## ⚙️ 기술스택

### Server Framework
![Spring-Boot](https://img.shields.io/badge/spring--boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)

### Database
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

### Infra Framework
![Google Cloud](https://img.shields.io/badge/GoogleCloud-%234285F4.svg?style=for-the-badge&logo=google-cloud&logoColor=white)
![Kubernetes](https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka)

### Communication
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)
![Notion](https://img.shields.io/badge/notion-white.svg?style=for-the-badge&logo=notion&logoColor=000000)

## 프로젝트 구조
main<br>
 ┣ 📂java<br>
 ┃ ┗ 📂com<br>
 ┃ ┃ ┗ 📂example<br>
 ┃ ┃ ┃ ┗ 📂lottery<br>
 ┃ ┃ ┃ ┃ ┣ 📂controller<br>
 ┃ ┃ ┃ ┃ ┃ ┗ 📜LotteryHistoryController.java<br>
 ┃ ┃ ┃ ┃ ┣ 📂domain<br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LotteryHistoryRequest.java<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LotteryResultRequest.java<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂response<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HistoryPageResponse.java<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LotteryHistoryResponse.java<br>
 ┃ ┃ ┃ ┃ ┃ ┗ 📂entity<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LotteryHistory.java<br>
 ┃ ┃ ┃ ┃ ┣ 📂repository<br>
 ┃ ┃ ┃ ┃ ┃ ┗ 📜LottoHistoryRepository.java<br>
 ┃ ┃ ┃ ┃ ┣ 📂kafka<br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KafkaDto.java<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KafkaHistoryDto.java<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KafkaPayDto.java<br>
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜KafkaStatus.java<br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomKafkaStatusDeserializer.java<br>
 ┃ ┃ ┃ ┃ ┃ ┗ 📜KafkaConsumerConfig.java<br>
 ┃ ┃ ┃ ┃ ┣ 📂service<br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LotteryHistoryService.java<br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LotteryHistoryServiceImpl.java<br>
 ┃ ┃ ┃ ┃ ┃ ┗ 📜LotteryApplication.java<br>
 ┗ 📂resources<br>
 ┃ ┣ 📜application-prod.yml<br>
 ┃ ┗ 📜application.yml<br>

## 🔗 ERD
![image](https://github.com/user-attachments/assets/bcba2f14-318c-4598-bf53-101797020286)


## 📄 구매내역 시퀀스 다이어그램
![로또 시퀀스다이어그램](https://github.com/encore-full-stack-5/DH_lottery/assets/88492548/c8bcef40-a7ef-4750-89b9-08aefe9e93e8)

## 🖥️ 화면 구성도
![화면-녹화-중-2024-07-02-122437](https://github.com/encore-full-stack-5/DH_lottery/assets/76871728/5ad54f45-e12b-4222-a1b8-de06ecb3fdee)

## 느낀점
