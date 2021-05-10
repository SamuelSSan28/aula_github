public class Conta {

    private String cpf;
    private String extrato;
    private Integer numero;
    private Double saldo;

    public Conta(String cpf, Integer numero) {
        this.cpf = cpf;
        this.extrato = "";
        this.numero = numero;
        this.saldo = 0.0;
      }
    
      public Conta() {}
    
      public Integer getNumero() {
          return this.numero;
      }

      public String getCpf() {
        return this.cpf;
      }

      public Double getSaldo() {
        return this.saldo;
      }

      public String getExtrato() {
        return this.extrato;
      }
      public void addExtrato(String novaTransacao) {
        this.extrato += novaTransacao;
      }
    
      public void setSaldo(Double valor) {
          this.saldo = valor;
      }
    
      public void setNumero(Integer numero) {
          this.numero = numero;
      }
    
      public void setCpf(String cpf) {
        this.cpf = cpf;
      }

    
}
