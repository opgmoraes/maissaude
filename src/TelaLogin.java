import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Clínica Mais Saúde - Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE; //

        JLabel clinicLabel = new JLabel("Clínica Mais Saúde");
        clinicLabel.setFont(new Font("Arial", Font.BOLD, 24));
        clinicLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel userLabel = new JLabel("Usuário:");
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("Senha:");
        JPasswordField passField = new JPasswordField(15);

        JButton loginButton = new JButton("Entrar");
        JButton registerButton = new JButton("Cadastrar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(clinicLabel, gbc);

        gbc.gridy = 1;
        panel.add(titleLabel, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        panel.add(passField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (!username.isEmpty() && !password.isEmpty()) {
                this.dispose();
                new TelaHome(username).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            }
        });

        registerButton.addActionListener(e -> {
            this.dispose();
            new TelaCadastro().setVisible(true);
        });

        add(panel);
    }
}


