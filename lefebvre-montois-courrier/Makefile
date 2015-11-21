# cibles qui ne sont pas des fichiers (évite conflit avec les éventuels fichiers de même nom)
.PHONY: clean, docs, compile, jar, run

# variables à redéfinir pour chaque applications
SOURCES = city/*.java content/*.java letter/*.java main/*.java printer/*.java test/*/*.java
# nom du fichier jar généré							
JAR_NAME = tp03-lefebvre-montois.jar
# nom du manifeste utilisé pour la création du jar
MANIFEST = Manifest
# les packages utilisés
PACKAGES = city content letter main printer
# les répertoires utilisés
DIR = ../doc $(PACKAGES)
# le classpath à utiliser
CLASSPATH = ../junit.jar:.
# nom du fichier généré par la commande "make run"
FILENAME = Mail.txt

# toutes les tâches
all: clean docs compile jar

#compilation des sources	
compile: 
	cd src ; javac -classpath $(CLASSPATH) $(SOURCES) -d ../bin

#création du jar
jar: 
	cd bin ; jar cvfm ../$(JAR_NAME) ../$(MANIFEST) $(DIR)

#génération de la doc	
docs:
	cd src ; javadoc $(PACKAGES) -d ../doc

#exécution du jar
run: 
	@java -jar $(JAR_NAME) > $(FILENAME)

#nettoyage bin et doc
clean: 
	rm -f -r bin ; mkdir bin
	rm -f -r doc ; mkdir doc
	rm -f $(FILENAME)
