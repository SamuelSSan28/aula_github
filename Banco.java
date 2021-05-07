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

    private Boolean verificaExisteCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

}
