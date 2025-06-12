import javax.swing.*;
import java.awt.*;

public class TelaHome extends JFrame {
    public TelaHome(String username) {
        setTitle("Clínica Mais Saúde - Home");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Bem-vindo, " + username + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(welcomeLabel, BorderLayout.WEST);
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel(new GridLayout(5, 1, 15, 15)); 
        menuPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

        JButton examsButton = new JButton("Acessar Exames");
        JButton scheduleButton = new JButton("Agendar Consulta");
        JButton consultasButton = new JButton("Consultas Agendadas");
        JButton solicitarExameButton = new JButton("Solicitar Novo Exame");
        JButton infoButton = new JButton("Mais Informações");

        examsButton.addActionListener(e -> {
            this.dispose();
            new TelaExames(username).setVisible(true);
        });

        scheduleButton.addActionListener(e -> {
            this.dispose();
            new TelaEspecialidades(username).setVisible(true);
        });

        consultasButton.addActionListener(e -> {
            this.dispose();
            new TelaConsultasAgendadas(username).setVisible(true);
        });

        solicitarExameButton.addActionListener(e -> {
            this.dispose();
            new TelaEscolherTipoExame(username).setVisible(true);
        });

        infoButton.addActionListener(e -> {
            this.dispose();
            new MaisInformacoes(username).setVisible(true);
        });

        menuPanel.add(examsButton);
        menuPanel.add(scheduleButton);
        menuPanel.add(consultasButton);
        menuPanel.add(solicitarExameButton);
        menuPanel.add(infoButton);
        panel.add(menuPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton logoutButton = new JButton("Sair");
        logoutButton.setPreferredSize(new Dimension(80, 30));
        logoutButton.addActionListener(e -> {
            this.dispose();
            new TelaLogin().setVisible(true);
        });
        bottomPanel.add(logoutButton, BorderLayout.EAST);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
    }
}
