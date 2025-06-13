public abstract class Persona {

    protected String nome;
    protected String cognome;
    protected int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    
    public abstract String descrizione();

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    

    public int getEta() {
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    

}
