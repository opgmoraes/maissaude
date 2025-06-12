import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaMedicos extends JFrame {
    public TelaMedicos(String username, String especialidade) {
        setTitle("Médicos de " + especialidade);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel welcomeLabel = new JLabel("Usuário: " + username);
        topPanel.add(welcomeLabel);

        String[] colunas = {"Nome", "CRM", "Especialidade"};

        Object[][] dados = {
                {"Dr. João", "12345", "Cardiologia"},
                {"Dra. Marina", "12346", "Cardiologia"},
                {"Dra. Ana", "54321", "Pediatria"},
                {"Dr. Fabrício", "54322", "Pediatria"},
                {"Dr. Carlos", "67890", "Dermatologia"},
                {"Dra. Camila", "67891", "Dermatologia"},
                {"Dr. José", "11111", "Neurologia"},
                {"Dra. Fernanda", "11112", "Neurologia"},
                {"Dr. Pedro", "22222", "Ortopedia"},
                {"Dra. Maria", "22223", "Ortopedia"},
                {"Dr. Mateus", "33333", "Ginecologia"},
                {"Dra. Juliana", "33334", "Ginecologia"},
                {"Dr. Tiago", "44444", "Oftalmologia"},
                {"Dra. Letícia", "44445", "Oftalmologia"},
                {"Dr. Fábio", "55555", "Psiquiatria"},
                {"Dra. Vitória", "55556", "Psiquiatria"},
                {"Dr. Izaque", "66666", "Endocrinologia"},
                {"Dra. Sara", "66667", "Endocrinologia"}
        };

        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Object[] medico : dados) {
            if (medico[2].equals(especialidade)) {
                modelo.addRow(medico);
            }
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnAgendar = new JButton("Agendar");
        btnAgendar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                String nomeMedico = (String) tabela.getValueAt(linha, 0);
                new TelaHorarios(username, nomeMedico).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um médico!");
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            this.dispose();
            new TelaEspecialidades(username).setVisible(true);
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnAgendar);
        bottomPanel.add(backButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
    }
}
