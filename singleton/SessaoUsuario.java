public class SessaoUsuario {
    private static SessaoUsuario instancia;
    private Cliente cliente;
    private boolean autenticado;

    private SessaoUsuario() {
        this.autenticado = false;
    }

    public static SessaoUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
            System.out.println("Sessão criada.");
        } else {
            System.out.println("Sessão já existe.");
        }
        return instancia;
    }

    public void autenticar(Cliente cliente) {
        this.cliente = cliente;
        this.autenticado = true;
        System.out.println("Cliente autenticado: " + cliente.getNome());
    }

    public void acessarPainel() {
        if (autenticado) {
            System.out.println("Acessando painel do cliente: " + cliente.getNome());
        } else {
            System.out.println("Acesso negado. Cliente não autenticado.");
        }
    }

    public Cliente getCliente() {
        if (autenticado) {
            return cliente;
        } else {
            System.out.println("Cliente não autenticado.");
            return null;
        }
    }

    public void setInformacaoCliente(String novoNome) {
        if (autenticado) {
            cliente.setNome(novoNome);
            System.out.println("Informações do cliente atualizadas para: " + novoNome);
        } else {
            System.out.println("Não é possível alterar informações. Cliente não autenticado.");
        }
    }
}
