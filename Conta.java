public class Conta {

    private String cpf;
    private Integer numero;

    public Conta(String cpf, Integer numero) {
        this.cpf = cpf;
        this.numero = numero;
      }
    
      public Conta() {}
    
      public Integer getNumero() {
          return this.numero;
      }

      public String getCpf() {
        return this.cpf;
      }
    
      public void setNumero(Integer numero) {
          this.numero = numero;
      }
    
      public void setCpf(String cpf) {
        this.cpf = cpf;
      }

    
}
