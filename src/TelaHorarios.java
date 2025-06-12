import javax.swing.*;
import java.awt.*;

public class TelaHorarios extends JFrame {
    public TelaHorarios(String username, String nomeMedico) {
        setTitle("Horários com " + nomeMedico);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel welcomeLabel = new JLabel("Usuário: " + username);
        topPanel.add(welcomeLabel);

        JLabel lblTitulo = new JLabel("Horários disponíveis para " + nomeMedico, JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

        String[] horarios = {
                "Segunda - 08:00", "Segunda - 09:00", "Terça - 10:00",
                "Quarta - 14:00", "Quinta - 15:00", "Sexta - 16:00"
        };

        JPanel painelHorarios = new JPanel(new GridLayout(2, 3, 10, 10));
        for (String horario : horarios) {
            JButton btnHorario = new JButton(horario);
            btnHorario.addActionListener(e -> {
                JOptionPane.showMessageDialog(this,
                        "Consulta agendada com " + nomeMedico + " em " + horario);
                dispose();
                new TelaHome(username).setVisible(true);
            });
            painelHorarios.add(btnHorario);
        }

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            this.dispose();
            new TelaEspecialidades(username).setVisible(true);
        });

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(lblTitulo, BorderLayout.NORTH);
        centerPanel.add(painelHorarios, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
    }
}

