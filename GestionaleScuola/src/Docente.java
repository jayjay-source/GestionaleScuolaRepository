public class Docente extends Persona implements Valutabile{

    private String materia;
    private double stipendio;

    
    public Docente(String nome, String cognome, int eta, String materia, double stipendio) {
        super(nome, cognome, eta);
        this.materia = materia;
        this.stipendio = stipendio;
    }

    

    public void aumentaStipendio(double percentuale){
        stipendio += stipendio * percentuale / 100;
    }
    @Override
    public void valutaPrestazione() {
        //aumento stipendio del 5% per esempio
        aumentaStipendio(5);
    }
    @Override
    public String descrizione() {
        return "Docente: " + nome + " " + cognome + ", materia: " + materia + ", stipendio: " + stipendio;
    }

    public String getMateria() {
        return materia;
    }

    public double getStipendio() {
        return stipendio;
    }

    
}
