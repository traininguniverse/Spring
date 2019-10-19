package pl.spring.test01.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.spring.test01.domain.Topic;

@Service
public class TopicService {

	private ArrayList<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("java", "Java App", "Java App Description"),
					new Topic("spring", "Spring App", "Spring App Description"),
					new Topic("javascript", "Javascript App", "Javascript App Description")));

	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		// zwraca sekwencyjny strumień z listy, z tego strumienia filtruje nowy strumień
		// odpowiadający opartemu na danej zależności, znajduje pierwszy ze strumienia,
		// z opcjonalego elementu pobiera konkretny lub wyjątek
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); ++i) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		// usuwa wszystkie elementy odpowiadające wskazanemu
	}
}
