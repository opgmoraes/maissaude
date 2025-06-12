import javax.swing.*;
import java.awt.*;

public class TelaMarcarConsultas extends JFrame {
    public TelaMarcarConsultas(String username) {
        setTitle("Sistema de Agendamento Médico");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel welcomeLabel = new JLabel("Usuário: " + username);
        topPanel.add(welcomeLabel);

        JButton btnAgendar = new JButton("Agendar Consulta");
        btnAgendar.addActionListener(e -> {
            new TelaEspecialidades(username).setVisible(true);
            dispose();
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            this.dispose();
            new TelaHome(username).setVisible(true);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAgendar);
        buttonPanel.add(backButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
    }
}
