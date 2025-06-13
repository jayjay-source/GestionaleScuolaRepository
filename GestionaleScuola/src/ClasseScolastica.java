import java.util.ArrayList;

public class ClasseScolastica 
{
    //proprietà
    private String nomeClasse;
    private ArrayList<Studente> studentiClasse;
    private ArrayList<Docente> docentiClasse;
    //extra: orario settimanale contente le materie (array multidimensionale[giorni][ore])
    private String[][] orarioSettimanaleMaterie; //[giorni][ore] ([lun, mar, mer, ...][1, 2, 3, ...])

    //costruttore
    public ClasseScolastica(String nomeClasse) 
    {
        this.nomeClasse = nomeClasse;
        this.studentiClasse = new ArrayList<>();
        this.docentiClasse = new ArrayList<>();
        this.orarioSettimanaleMaterie = new String [5][5];
        String[] materie = {    "Matematica", "Italiano", "Storia", "Geografia", "Scienze", "Arte", 
                                "Educazione Fisica", "Inglese"};
        System.out.println("Orario settimanale per la classe che hai scelto: ");
        for(int i = 0; i < orarioSettimanaleMaterie.length; i++)
        {
            for(int j = 0; j < orarioSettimanaleMaterie[i].length; j++)
            {
                orarioSettimanaleMaterie[i][j] = materie[(int)(Math.random() * materie.length)];
            }
        }
    }

    public String getNome() 
    {
        return nomeClasse;
    }

    public String[][] getOrarioSettimanaleMaterie() {
        return orarioSettimanaleMaterie;
    }

    //aggiungi Studente/Docente
    public void aggiungiStudenteClasse(Studente s)
    {
        studentiClasse.add(s);
    }
    public void aggiungiDocenteClasse(Docente d)
    {
        docentiClasse.add(d);
    }
    //rimuovi Studente/Docente
    public void rimuoviStudenteClasse(Studente s)
    {
        studentiClasse.remove(s);
    }
    public void rimuoviDocenteClasse(Docente d)
    {
        docentiClasse.remove(d);
    }

    //stampa orario settimanale
    public void stampaOrarioSettimanale(String nomeClasse)
    {
        String[] giorniSettimana = {"Lun", "Mar", "Mer", "Gio", "Ven"};
        String[] oreGiornaliere = {"1", "2", "3", "4", "5"};
        System.out.println("Orario Settimanale per la classe " + nomeClasse + ":");
        //String[][] orarioSettimanaleMaterie;
        for(int i = 0; i < giorniSettimana.length; i++)
        {
            for(int j = 0; j < oreGiornaliere.length; j++)
            {
                System.out.print(giorniSettimana[i] + " Ora " + oreGiornaliere[j] + ": " + orarioSettimanaleMaterie[i][j] + "\n");
            }
        }
    }

    //media generale
    public void mediaGeneraleClasse()
    {
        double sommaVoti = 0;
        int nStudenti = studentiClasse.size();
        for(Studente s : studentiClasse)
        {
            sommaVoti += s.mediaVoti();
        }
        sommaVoti /= nStudenti;
        System.out.println("La media generale della classe " + nomeClasse + " è: " + sommaVoti);
    }

    //migliore/peggiore studente
    //migliore
    public void miglioreStudenteClasse()
    {
        double votoMax = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < studentiClasse.size(); i++)
        {
            if(studentiClasse.get(i).mediaVoti() > votoMax)
            {
                votoMax = studentiClasse.get(i).mediaVoti();
                index = i;
            }
        }
        System.out.println("Lo studente con la migliore media voti nella classe " + nomeClasse + " è: " 
                            + studentiClasse.get(index).getNome() + " con una media di " + votoMax);
    }
    //peggiore
    public void peggioreStudenteClasse()
    {
        double votoMin = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < studentiClasse.size(); i++)
        {
            if(studentiClasse.get(i).mediaVoti() < votoMin)
            {
                votoMin = studentiClasse.get(i).mediaVoti();
                index = i;
            }
        }
        System.out.println("Lo studente con la peggiore media voti nella classe " + nomeClasse + " è: " 
                            + studentiClasse.get(index).getNome() + " con una media di " + votoMin);
    }

    //effettuaInterrogazione(materia):
    //  Sceglie casualmente uno studente per interrogare nella materia scelta.
    //  Il docente della materia assegna un voto casuale (da 4 a 10) allo studente interrogato.
    public void interrogazione(String materia)
    {
        int randomIndex = (int) (Math.random() * studentiClasse.size());
        Studente studenteInterrogato = studentiClasse.get(randomIndex);
        int valutazioneNumerica = (int) (Math.random() * 7) + 4; // Voto casuale tra 4 e 10
        Voto v = new Voto(materia, valutazioneNumerica);
        studenteInterrogato.aggiungiVoto(v);
        System.out.println("Lo studente " + studenteInterrogato.getNome() + " è stato interrogato in " + materia + 
                           " e ha ricevuto un voto di " + valutazioneNumerica);
    }
}
