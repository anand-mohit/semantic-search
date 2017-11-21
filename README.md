# semantic-search ~ under construnction ~
Semantic search built on top of google api for java domain. The search is intent based .
Technologies used:
1.Angular 4 

2.Angular Material 2

3.Spring Boot (MicroServices)

4.Mongo DB

5.NEO 4J Database

6.Kafka (Messaging Between MicroServices)

7.DialogFlow API AI

MicroServices:

1.(Domain Expert UI)-Google Api-Crawler-Parser-Indexer-Neo4jconceptgraph (This pipeline populates neo4j database intent based for the domain)

2.(User Query UI)-Spell Checker-NLP{ it includes Pos,Ner,Lemmatizer,Stop Words,IntentSearchService} - Neo4jConceptService - SocketService-Post Results
Neo4j Intent Graph database is to populate intents.

3.Chat Bot trained to answer Java questions on DialogFLow
