import java.util.ArrayList;
import java.util.Comparator;

public class Scuola {
    private ArrayList<Studente> studenti = new ArrayList<>();
    private ArrayList<Docente> docenti = new ArrayList<>();
    private ArrayList<ClasseScolastica> classi = new ArrayList<>();

    public void addStudente (Studente studente) {
        studenti.add(studente);
    }

    public void addDocente (Docente docente) {
        docenti.add(docente);
    }

    public void addClasse (ClasseScolastica classe) {
        classi.add(classe);
    }
    
    public Studente findStudenteByNome (String nome) {
        for (Studente i : studenti) {
            if (i.getNome().equals(nome)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Studente con nome '" + nome + "' non trovato.");
    }

    public Docente findDocenteByNome (String nome) {
        for (Docente i : docenti) {
            if (i.getNome().equals(nome)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Docente con nome '" + nome + "' non trovato.");
    }

    public ClasseScolastica findClasseByNome (String nome) {
        for (ClasseScolastica i : classi) {
            if (i.getNome().equals(nome)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Classe con nome '" + nome + "' non trovata.");
    }

    public Docente findDocenteByMateria (String materia) {
        for (Docente i : docenti) {
            if (i.getMateria().equals(materia)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Docente della materia '" + materia + "' non trovato.");
    }

    public Studente findStudenteMediaBassa () {
        double votoBasso = 11;
        Studente peggiore = null;
        for (Studente i : studenti) {
            if (i.mediaVoti() < votoBasso) {
                votoBasso = i.mediaVoti();
                peggiore = i;
            } 
        }
        return peggiore;
    }

    public Studente findStudenteMediaAlta () {
        double votoAlto = -1;
        Studente migliore = null;
        for (Studente i : studenti) {
            if (i.mediaVoti() > votoAlto) {
                votoAlto = i.mediaVoti();
                migliore = i;
            } 
        }
        return migliore;
    }

    public void riepilogoAvanzato() {
        System.out.println("Ecco il riepilogo della Scuola: /n");

        System.out.println(" -> Classi disponibili:");
        System.out.println(classi.toString());

        System.out.println("/n -> Docenti impiegati:");
        System.out.println(docenti.toString());

        System.out.println("/n -> Studenti voti migliori:");
        studenti.sort(Comparator.comparing(Studente::mediaVoti));   
         
        System.out.println(studenti.toString());

        System.out.println("/n -> Studenti voti peggiori:");
        studenti.reversed();
        System.out.println(studenti.toString());
    }
}
