# Structure du projet

devoir-soap/

│

├── metier/                 → Module contenant la logique métier

│   ├── entity/             → Entités JPA (Sector, Classe)

│   ├── dto/                → Objets de transfert de données

│   ├── dao/                → Interfaces et implémentations DAO

│   ├── service/            → Interfaces et implémentations métier

│   ├── mapper/             → Conversion Entity <-> DTO

│   ├── config/             → Connexion MySQL

│   └── exception/          → Classe NotFoundException

│

├── soap/                   → Module exposant les services SOAP

│   ├── endpoint/           → Webservices (DevoirServiceImpl)

│   └── webapp/WEB-INF/     → Configuration web.xml & sun-jaxws.xml

│

├── pom.xml                 → POM parent



lien du wsdl: http://localhost:8080/soap/DevoirService?wsdl

# Tester les Webservices SOAP
Utilisez SoapUI ou Postman (mode SOAP) avec le WSDL suivant :


http://localhost:8080/soap/DevoirService?wsdl
y'aura deja les operation de base déja presente 


