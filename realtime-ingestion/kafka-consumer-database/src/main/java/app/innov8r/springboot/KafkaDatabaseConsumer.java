package app.innov8r.springboot;

import app.innov8r.springboot.entity.WikimediaData;
import app.innov8r.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener (topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage){
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        dataRepository.save(wikimediaData);
        LOGGER.info(String.format("Event message received: %s", eventMessage));
    }
}
