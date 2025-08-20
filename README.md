📌 Projet SOAP
🚀 Étapes d’installation et d’exécution
Télécharger le projet et le dézipper.

Ouvrir le projet avec IntelliJ IDEA (ou VS Code).

Installer les dépendances Maven pour tous les modules.

Créer les entités (Classes et Sectors) avec leurs attributs (⚠️ ce n’est pas du JPA).

Vérifier l’environnement :

Tomcat 9 (recommandé, mais Tomcat 10 possible).
JDK 11 (recommandé).
Déployer et lancer le projet sur Tomcat.

Récupérer le WSDL : 👉 http://localhost:8080/soap\_war/DevoirService?wsdl

Tester le service avec SoapUI (de préférence).

Les opérations de base seront déjà générées si on coche l’option “Sample” dans SoapUI.
