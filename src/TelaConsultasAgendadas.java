import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaConsultasAgendadas extends JFrame {
    public TelaConsultasAgendadas(String username) {
        setTitle("Consultas Agendadas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel welcomeLabel = new JLabel("Usuário: " + username);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        topPanel.add(welcomeLabel);

        String[] colunas = {"Data", "Hora", "Especialidade", "Médico"};
        Object[][] dados = {
                {"18/06/2025", "09:00", "Cardiologia", "Dr. João"},
                {"19/08/2025", "14:00", "Dermatologia", "Dra. Camila"},
                {"22/09/2025", "10:00", "Ortopedia", "Dr. Pedro"}
        };

        JTable tabela = new JTable(new DefaultTableModel(dados, colunas));
        JScrollPane scroll = new JScrollPane(tabela);


        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            this.dispose();
            new TelaHome(username).setVisible(true);
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
    }
}

