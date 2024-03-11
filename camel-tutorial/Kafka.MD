docker-compose exec kafka bash
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic test-topic --partitions 1 --replication-factor 1
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --from-beginning

kafka-console-producer.sh --broker-list localhost:9092 --topic test-topic
