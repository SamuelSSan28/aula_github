public class Cliente {

  private String nome;
  private String cpf;
  private String senha;

  public Cliente(String nome, String cpf, String senha) {
    this.nome = nome;
    this.cpf = cpf;
    this.senha = senha;
  }

  public Cliente() {}

  public String getNome() {
    return this.nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
