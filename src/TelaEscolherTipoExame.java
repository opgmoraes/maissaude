import javax.swing.*;
import java.awt.*;

public class TelaEscolherTipoExame extends JFrame {
    public TelaEscolherTipoExame(String username) {
        setTitle("Selecionar Tipo de Exame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel welcomeLabel = new JLabel("Usuário: " + username);
        topPanel.add(welcomeLabel);
        panel.add(topPanel, BorderLayout.NORTH);

        JLabel label = new JLabel("Escolha o tipo de exame:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        String[] exames = {"Hemograma Completo", "Glicemia", "Colesterol Total"};

        for (String exame : exames) {
            JButton botao = new JButton(exame);
            botao.addActionListener(e -> {
                new TelaEscolherDataHora(username, exame).setVisible(true);
                dispose();
            });
            buttonPanel.add(botao);
        }

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }
}


