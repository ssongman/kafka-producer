# kafka-producer
kafka-producer


```sh
curl -X POST http://localhost:8081/create \
  -H "Content-Type: application/json" \
  -d '{  
  "eventName": "boardCreate",
  "num": 2,
  "title": "test insert-1",
  "contents": "test insert-1",
  "writeId": "user1",
  "writeName": "user1",
  "writeDate": "2022-07-03T01:03:00"
}'
 
 
## while - sleep 1
while true; do curl -X POST http://localhost:8081/create \
  -H "Content-Type: application/json" \
  -d '{  
  "eventName": "boardCreate",
  "num": 2,
  "title": "test insert-1",
  "contents": "test insert-1",
  "writeId": "user1",
  "writeName": "user1",
  "writeDate": "2022-07-03T01:03:00"
}'; sleep 1; echo; done
```
 
 