import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banco {

    private static List<Cliente> clientes = new ArrayList<Cliente>();
    private static List<Conta> contas = new ArrayList<Conta>();

    public Banco() {
    }

    public String cadastrarCliente(Cliente cliente) {
        if (!this.verificaExisteCliente(cliente.getCpf())) {
            clientes.add(cliente);
            return "Cliente cadastrado com sucesso!";
        }
        return "O cliente já existe.";
    }

    public String abrirConta(String cpf) {
        if (!this.verificaExisteCliente(cpf)) {
            return "Cliente não existe!";
        }

        if (this.verificaExisteConta(cpf)) {
            return "O cliente já possui conta";
        }

        int numero = contas.size() + 1;
        Conta conta = new Conta(cpf, numero);
        contas.add(conta);
        return "Conta aberta com sucesso. O número da conta é: " + numero;
    }

    private Boolean verificaExisteCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    private Boolean verificaExisteConta(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    private Integer verificaExisteConta(Integer numero) {
        Integer index = -1;
        for (Conta conta : contas) {
            index++;
            if (conta.getNumero() == numero) {
                return index;
            }
        }
        return -1;
    }

    private Boolean verificaSaldoDisponivel(Integer numero, double valor) {
        for (Conta conta : contas) {

            if (conta.getNumero() == numero) {
                if (conta.getSaldo() >= valor)
                    return true;
            }
        }

        return false;
    }

    public Boolean deposito(Integer numeroConta, double valor) {
        Integer indexConta = this.verificaExisteConta(numeroConta);

        if (indexConta == -1)
            return false;

        Conta conta = this.contas.get(indexConta);
        conta.setSaldo(conta.getSaldo() + valor);
        conta.addExtrato("+ " + valor +"\n");

        return true;
    }

    public Boolean saque(Integer numeroConta, double valor) {
        Integer indexConta = this.verificaExisteConta(numeroConta);
        Boolean temSaldoDisponivel = this.verificaSaldoDisponivel(numeroConta, valor);

        if(indexConta == -1 || !temSaldoDisponivel) return false;

        Conta conta = this.contas.get(indexConta);
        conta.setSaldo(conta.getSaldo() - valor);
        conta.addExtrato("- " + valor +"\n");

        return true;
    }

    public Boolean transferencia(Integer cOrigem, Integer cDestino, double valor) {
        Integer conta1Index = this.verificaExisteConta(cOrigem);
        Integer conta2Index = this.verificaExisteConta(cDestino);
        Boolean saldoDisponivel = this.verificaSaldoDisponivel(cOrigem, valor);

        if (conta1Index >= 0 && conta2Index >= 0 && saldoDisponivel) {
            Conta c1 = this.contas.get(conta1Index);
            c1.setSaldo(c1.getSaldo() - valor);
            c1.addExtrato("- " + valor + "\n");

            Conta c2 = this.contas.get(conta2Index);
            c2.setSaldo(c2.getSaldo() + valor);
            c2.addExtrato("+ " + valor + "\n");

            return true;
        }

        return false;

    }

    public String getExtrato(Integer numero_conta) {
        Integer conta1Index = this.verificaExisteConta(numero_conta);

        if (conta1Index >= 0) {
            Conta c1 = this.contas.get(conta1Index);
            return c1.getExtrato() + "\n Saldo atual: " + c1.getSaldo();
        }

        return "Conta não existe!";

    }

    public Boolean recarga(Integer numeroConta, String telefone) {
        Integer valorRecarga = 0;
        Integer operadora = 0;

        Integer indexConta = this.verificaExisteConta(numeroConta);

        Menu recargaMenu = new Menu("Selecione a operadora", Arrays.asList("Claro", "Oi", "Tim", "Vivo"));

        operadora = recargaMenu.getSelection();

        switch (operadora) {
            case 1:
                recargaMenu = new Menu("Selecione o valor da recarga", Arrays.asList("10", "20", "30"));
                break;
            case 2:
                recargaMenu = new Menu("Selecione o valor da recarga", Arrays.asList("5", "15", "25"));
                break;
            case 3:
                recargaMenu = new Menu("Selecione o valor da recarga", Arrays.asList("10", "15", "40"));
                break;
            case 4:
                recargaMenu = new Menu("Selecione o valor da recarga", Arrays.asList("5", "25", "50"));
                break;
        }

        valorRecarga = recargaMenu.getValueOfSelection();

        Boolean temSaldoDisponivel = this.verificaSaldoDisponivel(numeroConta, valorRecarga);

        if (indexConta == -1 || !temSaldoDisponivel)
            return false;

        Conta conta = this.contas.get(indexConta);
        conta.setSaldo(conta.getSaldo() - valorRecarga);
        conta.addExtrato("- " + valorRecarga + "\n");

        return true;
    }

}
