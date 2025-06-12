import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    public TelaCadastro() {
        setTitle("Clínica Mais Saúde - Cadastro");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Cadastro");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel nameLabel = new JLabel("Nome Completo:");
        JTextField nameField = new JTextField(15);

        JLabel emailLabel = new JLabel("E-mail:");
        JTextField emailField = new JTextField(15);

        JLabel userLabel = new JLabel("Usuário:");
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("Senha:");
        JPasswordField passField = new JPasswordField(15);

        JLabel confirmPassLabel = new JLabel("Confirmar Senha:");
        JPasswordField confirmPassField = new JPasswordField(15);

        JButton registerButton = new JButton("Cadastrar");
        JButton backButton = new JButton("Voltar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        panel.add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(confirmPassLabel, gbc);

        gbc.gridx = 1;
        panel.add(confirmPassField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(registerButton, gbc);

        gbc.gridx = 1;
        panel.add(backButton, gbc);

        registerButton.addActionListener(e -> {
            if (new String(passField.getPassword()).equals(new String(confirmPassField.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
                this.dispose();
                new TelaLogin().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "As senhas não coincidem!");
            }
        });

        backButton.addActionListener(e -> {
            this.dispose();
            new TelaLogin().setVisible(true);
        });

        add(panel);
    }
}
