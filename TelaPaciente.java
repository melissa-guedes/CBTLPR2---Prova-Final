//ALUNAS: MELISSA ESCARMELOTO GUEDES E LARYSSA BARBOSA SOARES

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TelaPaciente extends JFrame {

    JTextField txtNome, txtIdade, txtPeso, txtAltura;

    public TelaPaciente() {
        setTitle("Cadastro de Pacientes");
        setSize(360, 360);
        setLayout(null);

        JLabel l1 = new JLabel("Nome:");
        JLabel l2 = new JLabel("Idade:");
        JLabel l3 = new JLabel("Peso:");
        JLabel l4 = new JLabel("Altura:");

        txtNome = new JTextField();
        txtIdade = new JTextField();
        txtPeso = new JTextField();
        txtAltura = new JTextField();

        JButton bIncluir = new JButton("Incluir");
        JButton bLimpar = new JButton("Limpar");
        JButton bApresenta = new JButton("Apresentar");
        JButton bPesquisar = new JButton("Pesquisar");
        JButton bCreditos = new JButton("Creditos");
        JButton bSair = new JButton("Sair");

        l1.setBounds(20, 20, 80, 20);
        l2.setBounds(20, 60, 80, 20);
        l3.setBounds(20, 100, 80, 20);
        l4.setBounds(20, 140, 80, 20);

        txtNome.setBounds(100, 20, 220, 25);
        txtIdade.setBounds(100, 60, 120, 25);
        txtPeso.setBounds(100, 100, 120, 25);
        txtAltura.setBounds(100, 140, 120, 25);

        bIncluir.setBounds(20, 190, 140, 30);
        bLimpar.setBounds(180, 190, 140, 30);
        bApresenta.setBounds(20, 230, 140, 30);
        bPesquisar.setBounds(180, 230, 140, 30);
        bCreditos.setBounds(20, 270, 140, 30);
        bSair.setBounds(180, 270, 140, 30);

        add(l1); add(txtNome);
        add(l2); add(txtIdade);
        add(l3); add(txtPeso);
        add(l4); add(txtAltura);

        add(bIncluir);
        add(bLimpar);
        add(bApresenta);
        add(bPesquisar);
        add(bCreditos);
        add(bSair);

        bIncluir.addActionListener(e -> incluir());
        bLimpar.addActionListener(e -> limpar());
        bApresenta.addActionListener(e -> apresentar());
        bPesquisar.addActionListener(e -> pesquisar());
        bCreditos.addActionListener(e -> JOptionPane.showMessageDialog(null, "Creditos nao informados."));
        bSair.addActionListener(e -> System.exit(0));

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void incluir() {
        try {
            Conexao db = new Conexao();
db.connect();
Connection con = db.getConnection();
            String sql = "INSERT INTO Paciente (nome, idade, peso, altura) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, txtNome.getText());
            stm.setInt(2, Integer.parseInt(txtIdade.getText()));
            stm.setFloat(3, Float.parseFloat(txtPeso.getText()));
            stm.setFloat(4, Float.parseFloat(txtAltura.getText()));

            stm.execute();
            JOptionPane.showMessageDialog(null, "Paciente inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public void limpar() {
        txtNome.setText("");
        txtIdade.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
    }

    public void apresentar() {
        String dados = "Nome: " + txtNome.getText() +
                       "\nIdade: " + txtIdade.getText() +
                       "\nPeso: " + txtPeso.getText() +
                       "\nAltura: " + txtAltura.getText();
        JOptionPane.showMessageDialog(null, dados);
    }

    public void pesquisar() {
        try {
Conexao db = new Conexao();
db.connect();
Connection con = db.getConnection();
            String sql = "SELECT * FROM Paciente WHERE nome LIKE ?";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, "%" + txtNome.getText() + "%");
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                txtIdade.setText(rs.getString("idade"));
                txtPeso.setText(rs.getString("peso"));
                txtAltura.setText(rs.getString("altura"));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new TelaPaciente();
    }
}

