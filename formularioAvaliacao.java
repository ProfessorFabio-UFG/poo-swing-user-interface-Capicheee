import javax.swing.*;
import java.awt.*;

public class formularioAvaliacao extends JFrame {

    public formularioAvaliacao() {
        super("Formulário de Avaliação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLayout(new BorderLayout(10, 10));

        JMenuBar menuBar = criarMenuBar();
        setJMenuBar(menuBar);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        painelPrincipal.add(criarCampoComLinha("Código :"));
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(criarCampoComLinha("Nome :"));
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(criarGrupoSexo());
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(new JSeparator(JSeparator.HORIZONTAL));
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(criarAreaComTitulo("Curriculum Vitae", 5));
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(new JSeparator(JSeparator.HORIZONTAL));
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(criarCampoComLinha("Áreas"));
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(criarAreaComTitulo("Interesse :", 2));
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(criarTabelaInteresses());
        painelPrincipal.add(Box.createVerticalStrut(20));
        painelPrincipal.add(criarBotoes());

        add(painelPrincipal, BorderLayout.CENTER);
    }

    private JMenuBar criarMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuArquivo = new JMenu("Arquivo");
        
        JMenuItem itemEnviar = new JMenuItem("Enviar");
        JMenu subMenuEmail = new JMenu("email");
        JMenuItem itemFicha = new JMenuItem("Ficha de Avaliação");
        JMenu subMenuSalvar = new JMenu("Salvar");
        JMenuItem itemImpressora = new JMenuItem("Impressora");
        JMenuItem itemSair = new JMenuItem("Sair");
        
        subMenuEmail.add(itemFicha);
        subMenuSalvar.add(itemImpressora);
        
        menuArquivo.add(itemEnviar);
        menuArquivo.add(subMenuEmail);
        menuArquivo.add(subMenuSalvar);
        menuArquivo.addSeparator();
        menuArquivo.add(itemSair);
        
        menuBar.add(menuArquivo);
        
        return menuBar;
    }

    private JPanel criarCampoComLinha(String rotulo) {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        
        JLabel label = new JLabel(rotulo);
        painel.add(label, BorderLayout.NORTH);
        
        JSeparator linha = new JSeparator(JSeparator.HORIZONTAL);
        painel.add(linha, BorderLayout.SOUTH);
        
        return painel;
    }

    private JPanel criarGrupoSexo() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painel.add(new JLabel("Sexo :"));
        
        JRadioButton radioFeminino = new JRadioButton("Feminino");
        JRadioButton radioMasculino = new JRadioButton("Masculino");
        
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(radioFeminino);
        grupoSexo.add(radioMasculino);
        
        painel.add(radioFeminino);
        painel.add(radioMasculino);
        
        return painel;
    }

    private JPanel criarAreaComTitulo(String titulo, int linhas) {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        
        JLabel label = new JLabel(titulo);
        painel.add(label, BorderLayout.NORTH);
        
        JTextArea areaTexto = new JTextArea(linhas, 30);
        areaTexto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        painel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        
        return painel;
    }

    private JScrollPane criarTabelaInteresses() {
        String[] colunas = {"Desenvolvedor", "Programação"};
        Object[][] dados = {
            {"", ""},
            {"", ""},
            {"", ""}
        };
        
        JTable tabela = new JTable(dados, colunas);
        tabela.setPreferredScrollableViewportSize(new Dimension(450, 80));
        
        return new JScrollPane(tabela);
    }

    private JPanel criarBotoes() {
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        JButton btnSalvar = new JButton("Salvar");
        JButton btnAnterior = new JButton("Anterior");
        JButton btnProximo = new JButton("Proximo");
        JButton btnNovo = new JButton("Novo");
        JButton btnCancelar = new JButton("Cancelar");
        
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnAnterior);
        painelBotoes.add(btnProximo);
        painelBotoes.add(btnNovo);
        painelBotoes.add(btnCancelar);
        
        return painelBotoes;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            formularioAvaliacao formulario = new formularioAvaliacao();
            formulario.setVisible(true);
        });
    }
}