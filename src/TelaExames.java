import javax.swing.*;
import java.awt.*;

public class TelaExames extends JFrame {
    public TelaExames(String username) {
        setTitle("Clínica Médica - Exames");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("Exames do Paciente: " + username);
        topPanel.add(titleLabel);

        String[] columnNames = {"Data", "Tipo de Exame", "Resultado", "Status"};
        Object[][] data = {
                {"10/06/2023", "Hemograma Completo", "Normal", "Finalizado"},
                {"15/05/2023", "Glicemia", "98 mg/dL", "Finalizado"},
                {"20/04/2023", "Colesterol Total", "Em análise", "Pendente"}
        };

        JTable examsTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(examsTable);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Voltar");

        bottomPanel.add(backButton);

        backButton.addActionListener(e -> {
            this.dispose();
            new TelaHome(username).setVisible(true);
        });

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        add(panel);
    }
}
