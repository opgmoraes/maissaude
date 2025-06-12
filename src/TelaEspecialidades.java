import javax.swing.*;
import java.awt.*;

public class TelaEspecialidades extends JFrame {
    public TelaEspecialidades(String username) {
        setTitle("Selecione a Especialidade");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel welcomeLabel = new JLabel("Usuário: " + username);
        topPanel.add(welcomeLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 3, 10, 10)); 


        String[] especialidades = {
                "Cardiologia", "Pediatria", "Dermatologia",
                "Neurologia", "Ortopedia", "Ginecologia",
                "Oftalmologia", "Psiquiatria", "Endocrinologia"
        };

        for (String especialidade : especialidades) {
            JButton btnEspecialidade = new JButton(especialidade);
            btnEspecialidade.addActionListener(e -> {
                new TelaMedicos(username, especialidade).setVisible(true);
                dispose();
            });
            centerPanel.add(btnEspecialidade);
        }

        JPanel bottomPanel = new JPanel();
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            this.dispose();
            new TelaHome(username).setVisible(true);
        });
        bottomPanel.add(backButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
    }
}
