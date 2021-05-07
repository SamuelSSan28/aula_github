import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static List<Cliente> clientes = new ArrayList<Cliente>();
    private static List<Conta> contas = new ArrayList<Conta>();

    public Banco() {}

    public String cadastrarCliente(Cliente cliente) {
        if(!this.verificaExisteCliente(cliente.getCpf())){
            clientes.add(cliente);
            return "Cliente cadastrado com sucesso!";
        }
        return "O cliente já existe.";
    }

    public String abrirConta(String cpf) {
        if(!this.verificaExisteCliente(cpf)){
            return "Cliente não existe!";
        }
        
        if(this.verificaExisteConta(cpf)){
            return "O cliente já possui conta";
        }

        int numero = contas.size() + 1;
        Conta conta = new Conta(cpf, numero);
        contas.add(conta);
        return "Conta aberta com sucesso. O número da conta é: " + numero;
    }

    private Boolean verificaExisteCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    private Boolean verificaExisteConta(String cpf) {
        for (Conta conta : contas) {
            if(conta.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

}
