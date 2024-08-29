package br.lpm.main;

import java.time.LocalDate;
import br.lpm.business.EstadoCivil;
import br.lpm.business.FormacaoAcademica;
import br.lpm.business.Pessoa;
import br.lpm.business.Profissao;
import br.lpm.business.Dataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

public class Main {
    public static Dataset dataset = new Dataset();

    public static void main(String[] args) throws Exception {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Adriana");
        pessoa1.setFormacaoAcadem(FormacaoAcademica.SUPERIOR);
        dataset.addPessoa(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Julio");
        pessoa2.setFormacaoAcadem(FormacaoAcademica.SUPERIOR);
        dataset.addPessoa(pessoa2);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Claudio");
        pessoa3.setFormacaoAcadem(FormacaoAcademica.BASICA);
        dataset.addPessoa(pessoa3);

        Pessoa pessoa4 = new Pessoa();
        pessoa4.setNome("Renan");
        pessoa4.setFormacaoAcadem(FormacaoAcademica.MEDIA);
        dataset.addPessoa(pessoa4);

        histogramFormacaoAcademica();
    }

    // Método corrigido para criar o histograma
    public static void histogramFormacaoAcademica() {
        DefaultCategoryDataset chartDataset = new DefaultCategoryDataset();
        
        int[] count = new int[FormacaoAcademica.values().length];
        for (Pessoa pessoa : dataset.getAll()) {
            if (pessoa != null) {
                FormacaoAcademica formacao = pessoa.getFormacaoAcadem();
                count[formacao.ordinal()]++;
            }
        }
    
        for (FormacaoAcademica formacao : FormacaoAcademica.values()) {
            chartDataset.addValue(count[formacao.ordinal()], "Formação Acadêmica", formacao.name());
        }
    
        JFreeChart chart = ChartFactory.createBarChart(
            "Distribuição das Formações Acadêmicas",  // Título do gráfico
            "Formação Acadêmica",                    // Eixo X
            "Número de Pessoas",                     // Eixo Y
            chartDataset,                            // Dados
            PlotOrientation.VERTICAL,                // Orientação
            true,                                    // Inclui a legenda
            true,                                    // Inclui ferramentas
            false                                    // Inclui URLs
        );
    
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    
        JFrame frame = new JFrame("Histograma de Formação Acadêmica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);      
    }
}
