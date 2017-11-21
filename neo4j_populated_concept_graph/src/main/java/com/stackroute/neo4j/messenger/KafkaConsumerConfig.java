
package com.stackroute.neo4j.messenger;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.neo4j.domain.IndexerModel;
import com.stackroute.neo4j.domain.IntentSearchResult;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {


	    @Bean
	    public ConsumerFactory<String, IndexerModel> consumerFactory() {
	        Map<String, Object> props = new HashMap<>();
	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.238.151:9092");
	        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
	        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	        return new DefaultKafkaConsumerFactory<String, IndexerModel>(props, null,
	                new JsonDeserializer<IndexerModel>(IndexerModel.class));
	    }

	    @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, IndexerModel> kafkaListenerContainerFactory() {

	        ConcurrentKafkaListenerContainerFactory<String, IndexerModel> factory = new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
	    
	    
	    @Bean
	    public ConsumerFactory<String, IntentSearchResult> consumerFactory1() {
	        Map<String, Object> props = new HashMap<>();
	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.238.151:9092");
	        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group2");
	        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	        return new DefaultKafkaConsumerFactory<String, IntentSearchResult>(props, null,
	                new JsonDeserializer<IntentSearchResult>(IntentSearchResult.class));
	    } 
	    
	    @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, IntentSearchResult> kafkaListenerContainerFactory1() {

	        ConcurrentKafkaListenerContainerFactory<String, IntentSearchResult> factory1 = new ConcurrentKafkaListenerContainerFactory<>();
	        factory1.setConsumerFactory(consumerFactory1());
	        return factory1;
	    }  
	    
	    
		@Bean
		public Listener listener() {
			return new Listener();
		}

	}
	





//
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//@Configuration
//@EnableKafka
//public class KafkaConsumerConfig {
//	@Bean
//	KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
//		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
//		factory.setConsumerFactory(consumerFactory());
//		factory.setConcurrency(3);
//		factory.getContainerProperties().setPollTimeout(3000);
//		return factory;
//	}
//
//	@Bean
//	public ConsumerFactory<String, String> consumerFactory() {
//		return new DefaultKafkaConsumerFactory<String, String>(consumerConfigs());
//	}
//	
//	
//	@Bean
//	KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, IndexerModel>> kafkaListenerContainerFactory1() {
//		ConcurrentKafkaListenerContainerFactory<String, IndexerModel> factory = new ConcurrentKafkaListenerContainerFactory<String, IndexerModel>();
//		factory.setConsumerFactory(consumerFactory1());
//		factory.setConcurrency(3);
//		factory.getContainerProperties().setPollTimeout(3000);
//		return factory;
//	}
//
//	@Bean
//	public ConsumerFactory<String, IndexerModel> consumerFactory1() {
//		return new DefaultKafkaConsumerFactory<String, IndexerModel>(consumerConfigs());
//	}
//
//	@Bean
//	public Map<String, Object> consumerConfigs() {
//		Map<String, Object> propsMap = new HashMap<String, Object>();
//		propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.238.178:9092");
//		propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
//		propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
//		propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
//		propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//		propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
//		propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//		return propsMap;
//	}
//

//}