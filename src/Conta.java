public class Conta {

    private String nome;

    private String documento;

    private String telefone;

    private String email;

    private String senha;

    private double saldo;

    

    

    public Conta(String nome, String documento, String telefone, String email, String senha, double saldo) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
        
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


   public void depositar(double deposito){
        saldo += deposito;
    }
    

      public void debitar(double deposito){
        saldo -= deposito;
    }
}
