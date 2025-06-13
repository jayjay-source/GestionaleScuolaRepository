import java.util.ArrayList;
import java.util.Scanner;

public class MenuScuola {

    //preparo tutti gli elementi che mi servono per inserire e gestire dati, simulare interrogazioni, gestire stipendi e valutazioni docenti e le statistiche avanzante
    //gli studenti ricevono voti dai docenti con le interrogazioni simulate, quindi avrò una interazione diretta tra Studente e Docente
    //il docente potrà ricevere un aumento di stipendio in base alla valutaizone della prestazione generale (ossia la media la media delle valutazioni date agli studenti)
    //ClasseScolastica deve calcolare periodicamente la media generale, influenzando eventuali premi o menzioni speciali
    //EXTRA: Ogni classe deve gestire il proprio orario settimanale(multidimensionale) che deve poter essere visualizzato dagli utenti

    private ArrayList<ClasseScolastica> classi = new ArrayList<>();
    private ArrayList<Docente> docenti = new ArrayList<>();
    private ArrayList<Studente> studenti = new ArrayList<>();

    Scanner tastiera = new Scanner(System.in);

    public void avvia(){
        int scelta;

        do { 

            System.out.println("\n--- MENU GESTIONALE SCUOLA ---");
            System.out.println("1. Inserisci Studente");
            System.out.println("2. Inserisci Docente");
            System.out.println("3. Inserisci Classe");
            System.out.println("4. Assegna Studente a Classe");
            System.out.println("5. Assegna Docente a Classe");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = Integer.parseInt(tastiera.nextLine());

            switch(scelta){
            case 1: inserisciStudente(); break;
            case 2: inserisciDocente(); break;
            case 3: inserisciClasse(); break;
            case 4: assegnaStudenteClasse(); break;
            case 5: assegnaDocenteClasse(); break;
            case 0: System.out.println("Uscita...");; break;
            default: System.out.println("Scelta non valida. Riprova.");
        }

            
        } while (scelta != 0);

        

    }

    //implementazioni dei metodi di inserimento
    private void inserisciStudente(){

        System.out.println("Nome: ");
        String nome = tastiera.nextLine();
        System.out.println("Cognome: ");
        String cognome = tastiera.nextLine();
        System.out.println("Eta: ");
        int eta = Integer.parseInt(tastiera.nextLine());
        System.out.println("Matricola: ");
        String matricola = tastiera.nextLine();
        Studente s = new Studente(nome, cognome, eta, matricola);
        studenti.add(s);
        System.out.println("Hai aggiunto un nuovo studente");

    }

    private void inserisciDocente(){

        System.out.print("Nome: ");
        String nome = tastiera.nextLine();
        System.out.print("Cognome: ");
        String cognome = tastiera.nextLine();
        System.out.print("Età: ");
        int eta = Integer.parseInt(tastiera.nextLine());
        System.out.print("Materia: ");
        String materia = tastiera.nextLine();
        System.out.print("Stipendio: ");
        String stipendioStr = tastiera.nextLine();
        double stipendio = Double.parseDouble(stipendioStr.replace(",", "."));
        Docente d = new Docente(nome, cognome, eta, materia, stipendio);
        docenti.add(d);
        System.out.println("Docente aggiunto.");
        
    }

    private void inserisciClasse(){
        System.out.println("Nome classe: ");
        String nomeClasse = tastiera.nextLine();
        ClasseScolastica c = new ClasseScolastica(nomeClasse);
        classi.add(c);
        System.out.println("Hai aggiunto una nuova classe.");
    }

    //implementazione dei metodi di scelta
    private ClasseScolastica scegliClasse() {
        if(classi.isEmpty()){
            System.out.println("Nessuna classe presente");
            return null;
        }

        System.out.println("Classi disponibili:");
        for(ClasseScolastica c : classi){
            System.out.println("- " + c.getNome());
        }

        System.out.println("Scegli classe (digita il NOME(numero+sezione)):");
        String nomeClasse = tastiera.nextLine().trim();
        for(ClasseScolastica c : classi){
            if(c.getNome().equalsIgnoreCase(nomeClasse)){
                return c;
            }
        }
        return null;
    }

    private Studente scegliStudente(){
        if(studenti.isEmpty()){
            System.out.println("Nessuno studente presente");
            return null;
        }

        System.out.println("Studenti presenti:");
        for(Studente s : studenti){
            System.out.println("- " + s.getNome() + " " + s.getCognome());
        }

        System.out.println("Scegli lo studente (Nome e Cognome):");
        System.out.println("Nome:");
        String nomeStudente = tastiera.nextLine().trim();
        System.out.println("Cognome:");
        String cognomeStudente = tastiera.nextLine().trim();

        for(Studente s : studenti){
            if(s.getNome().equalsIgnoreCase(nomeStudente) && s.getCognome().equalsIgnoreCase(cognomeStudente)){
                return s;
            }
        }
        return null;
    }

    private Docente scegliDocente(){
        if(docenti.isEmpty()){
            System.out.println("Nessun docente presente");
            return null;
        }

        System.out.println("Docenti disponibili:");
        for(Docente d : docenti){
            System.out.println("- " + d.getNome() + d.getCognome());
        }

        System.out.println("Scegli il docente (nome e cognome):");
        System.out.println("Nome:");
        String nomeDocente = tastiera.nextLine().trim();
        System.out.println("Cognome:");
        String cognomeDocente = tastiera.nextLine().trim();

        for(Docente d : docenti){
            if(d.getNome().equalsIgnoreCase(nomeDocente) && d.getCognome().equalsIgnoreCase(cognomeDocente)){
                return d;
            }
        }
        return null;
    }

    //implementazione metodi di assegnazione
    public void assegnaStudenteClasse(){
        ClasseScolastica classe = scegliClasse();
        if(classe == null) {
            System.out.println("Assegnazione fallita");
            return;
        }
        Studente studente = scegliStudente();
        if(studente == null) {
            System.out.println("Assegnazione fallita");
            return;
        }
        classe.aggiungiStudenteClasse(studente);
        System.out.println("Studente assegnato alla classe " + classe.getNome());
    }

    public void assegnaDocenteClasse(){

        ClasseScolastica classe = scegliClasse();
        if(classe == null) {
            System.out.println("Assegnazione fallita");
            return;
        }
        Docente docente = scegliDocente();
        if(docente == null) {
            System.out.println("Assegnazione fallita");
            return;
        }
        classe.aggiungiDocenteClasse(docente);
        System.out.println("Docente assegnato alla classe " + classe.getNome());

    }

    //implementazione metodo simula interrogazioni
    //implementazione metodo per gestire gli stipendi
    //implementazione metodo per le statistiche della classe
    //implementazione metodo per stampare l'orario




}
