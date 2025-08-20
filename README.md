# 📌 Projet SOAP

## 🚀 Étapes d’installation et d’exécution

1. **Télécharger** le projet et le **dézipper**.
2. **Ouvrir** le projet avec **IntelliJ IDEA** (ou VS Code).
3. **Installer les dépendances Maven** pour tous les modules.
4. **Créer les entités** (Classes et Sectors) avec leurs attributs (⚠️ ce n’est pas du JPA).
5. Vérifier l’environnement :

   * **Tomcat 9** (recommandé, mais Tomcat 10 possible).
   * **JDK 11** (recommandé).
6. **Déployer** et **lancer** le projet sur Tomcat.
7. Récupérer le **WSDL** :
   👉 [http://localhost:8080/soap\_war/DevoirService?wsdl](http://localhost:8080/soap_war/DevoirService?wsdl)
8. **Tester** le service avec **SoapUI** (de préférence).
9. Les **opérations de base** seront déjà générées si on **coche l’option “Sample”** dans SoapUI.
