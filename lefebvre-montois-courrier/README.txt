Projet Java COO : Courrier
Benjamin Lefebvre
Thibault Montois
2015

#------------------------#

1/ Introduction

Le logiciel Courrier est une simulation développée dans le cadre du troisième projet de licence 3 informatique.

#------------------------#

2/ Usage

Il existe un Makefile dont les commandes sont les suivantes : 
	- make compile -> exécute la compilation de toutes les classes contenues dans le répertoire src
	- make jar -> crée le jar exécutable tp03-lefebvre-montois.jar
	- make docs -> génére la documentation
	- make clean -> vide les répertoires bin et doc et supprime le fichier Mail.txt
	- make ou make all -> lance make clean, make docs, make compile et make jar
	- make run -> exécute le jar en redirigeant la sortie standard vers le fichier Mail.txt

Attention à ne pas modifier l'architecture du répertoire pour que le Makefile puisse s'exécuter correctement.

La totalité des fonctions demandées dans le cahier des charges ont été implémentées.

#------------------------#

3/ Architecture

Le projet est divisé en packages regroupant les classes par objectif.
L'architecture est la suivante : 

src
 |_city
 |_content
 |_letter
 |_main
 |_printer
 [_test
   |_city
   |_content
   |_letter
   |_main
   |_mock
   |_printer

On retrouve plusieurs polymorphismes dans ce programme: Content.java, Letter.java, Printer.java.

Content.java : 
Cette interface doit être implémentée par les classes définissants un contenu (MoneyContent.java, TextContent.java mais aussi Letter.java).

Letter.java : 
Cette classe abstraite implémente l'interface Content. Elle est aussi paramétrées par un
sous-type de Content et dispose d'un attribut "content" dont le type dépend de ce paramètre.
Elle fait partie d'un patron de conception de type décorateur, ce qui permet de créer des lettres qui peuvent contenir d'autres lettres.
Ses sous-classes PromissoryNote, SimpleLetter et ses descendants ont comme contenu un MoneyContent ou un TextContent.
Sa sous-classe LetterDecorator et ses descendants ont comme contenu une lettre.
La classe Letter contient la template méthode "doAction()" appelant la méthode abstraite "reallyDoAction()" redéfinie dans chacune des ses sous-classes.
	
Printer.java : 
Cette interface doit être implémentée par les classes définissants des méthodes d'affichage (StandardPrinter.java et - pour les tests - MockPrinter.java)

#------------------------#

4/ Code Sample

Signature de la classe Letter, la template méthode "doAction()" et la signature de la méthode "reallyDoAction()" appelée par "doAction()" : 

public abstract class Letter<C extends Content> implements Content {
  [...]
  protected C content;
  [...]
  public void doAction() {
    this.printer.printDoAction(this);
    this.reallyDoAction();
  }
  [...]
  protected abstract void reallyDoAction();
}

Signature de la sous-classe LetterDecorator et son constructeur: 

public abstract class LetterDecorator extends Letter<Letter<?>> {
  [...]
  public LetterDecorator(Letter<?> letter) {
    super(letter.getSender(), letter.getReceiver());
    this.content = letter;
  }
}

Signature de la sous-classe RegisteredLetter et implémentation de la méthode "reallyDoAction()" (qui s'appuie sur la méthode de son contenu) : 

public class RegisteredLetter extends LetterDecorator {
  [...]
  @Override
  protected void reallyDoAction() {
    this.content.reallyDoAction();
    this.receiver.getCity().sendLetter(new AknowledgmentOfReceipt(this.receiver, this.sender, this.toString()));
  }
  [...]
}

Signature de la sous-classe PromissoryNote, son constructeur et implémentation de la méthode "reallyDoAction()" : 

public class PromissoryNote extends Letter<MoneyContent> {
  [...]
  public PromissoryNote(Inhabitant sender, Inhabitant receiver, int amount) {
    super(sender, receiver);
    this.content = new MoneyContent(amount);
    this.factor = Mail.PNFACTOR;
  }
  [...]
  @Override
  protected void reallyDoAction() {
    this.sender.debit(this.content.getAmount());
    this.receiver.credit(this.content.getAmount());
    this.receiver.getCity().sendLetter(new ThanksLetter(this.receiver, this.sender, this.toString()));
  }
  [...]
}
















