public class Main {
    public static void main(String[] args) {
        SessaoUsuario sessao1 = SessaoUsuario.getInstancia();
        sessao1.acessarPainel(); // Não autenticado

        Cliente cliente = new Cliente("Carlos Eduardo");
        sessao1.autenticar(cliente);
        sessao1.acessarPainel();

        sessao1.setInformacaoCliente("Carlos Eduardo");

        SessaoUsuario sessao2 = SessaoUsuario.getInstancia();
        sessao2.acessarPainel(); // Mesmo cliente da mesma sessão

        System.out.println("Nome do cliente da sessao2: " + sessao2.getCliente().getNome());

        System.out.println("sessao1 == sessao2? " + (sessao1 == sessao2));
    }
}
