import java.util.ArrayList;
import java.util.List;

public class Studente extends Persona implements Valutabile{

    private String matricola;
    private List<Voto> listaVoti;

    public Studente(String nome, String cognome, int eta, String matricola) {
        super(nome, cognome, eta);
        this.matricola = matricola;
        this.listaVoti = new ArrayList<>();
    }

    

    public void aggiungiVoto(Voto voto){
        listaVoti.add(voto);
    }

    public double mediaVoti(){
        if(listaVoti.isEmpty()) return 0;
        int somma = 0;
        for(Voto v : listaVoti){
            somma += v.getValutazioneNumerica();
        }
        return (double) somma / listaVoti.size();
    }

    @Override
    public void valutaPrestazione() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'valutaPrestazione'");
    }

    @Override
    public String descrizione() {
        return "Studente: " + nome + " " + cognome + ", età: " + eta + ", matricola: " + matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    public List<Voto> getListaVoti() {
        return listaVoti;
    }

    

    

}
