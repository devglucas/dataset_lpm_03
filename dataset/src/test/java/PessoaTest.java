

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.lpm.business.EstadoCivil;
import br.lpm.business.FormacaoAcademica;
import br.lpm.business.Pessoa;
import br.lpm.business.Profissao;
import br.lpm.business.Dataset;

public class PessoaTest {
    private Dataset dataset;

    @BeforeEach
    public void setUp() {
        dataset = new Dataset();
        dataset.removeAll();  
    }
    
    @Test
    void testSetAltura() {
        Pessoa pessoa = new Pessoa();
        dataset.addPessoa(pessoa);
        pessoa.setAltura(1.82f);
        assertEquals(1.82f, pessoa.getAltura());
        pessoa.setAltura(3.45f);
        assertEquals(1.82f, pessoa.getAltura());
    }

    @Test
    void testSetAtividadeFisica() {
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setAtividadeFisica(2);
        assertEquals(2, pessoa2.getAtividadeFisica());
        pessoa2.setAtividadeFisica(12);
        assertEquals(2, pessoa2.getAtividadeFisica());
    }

    @Test
    void testSetDatanasc() {
        Pessoa pessoa3 = new Pessoa ();
        pessoa3.setDatanasc(LocalDate.of(2000, 8, 15));
        assertEquals(LocalDate.of(2000, 8, 15), pessoa3.getDatanasc());
        pessoa3.setDatanasc(LocalDate.of(2024, 8, 29));
        assertEquals(LocalDate.of(2000, 8, 15), pessoa3.getDatanasc());
    }

    @Test
    void testSetEstadoCivil() {
        Pessoa pessoa4 = new Pessoa ();
        EstadoCivil estadoCivil = EstadoCivil.CASADO;
        pessoa4.setEstadoCivil(estadoCivil);
        assertEquals(estadoCivil, pessoa4.getEstadoCivil());
    }

    @Test
    void testSetEstadoSaude() {
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setEstadoSaude(5);
        assertEquals(5, pessoa5.getEstadoSaude());
        pessoa5.setEstadoSaude(20);
        assertEquals(5, pessoa5.getEstadoSaude());
    }

    @Test
    void testSetFormacaoAcadem() {
        Pessoa pessoa6 = new Pessoa ();
        FormacaoAcademica formacaoAcad = FormacaoAcademica.SUPERIOR;
        pessoa6.setFormacaoAcadem(formacaoAcad);
        assertEquals(formacaoAcad, pessoa6.getFormacaoAcadem());
    }

    @Test
    void testSetHobby() {

    }

    @Test
    void testSetNome() {
        Pessoa pessoa7 = new Pessoa();
        pessoa7.setNome("Lucas");
        assertEquals("Lucas", pessoa7.getNome());
        pessoa7.setNome("L$¨&C");
        assertEquals("Lucas", pessoa7.getNome());
    }

    @Test
    void testSetPeso() {
        Pessoa pessoa8 = new Pessoa();
        pessoa8.setPeso(56.8f);
        assertEquals(56.8f, pessoa8.getPeso());
        pessoa8.setPeso(598f);
        assertEquals(56.8f, pessoa8.getPeso());
    }

    @Test
    void testSetProfissao() {
        Pessoa pessoa9 = new Pessoa ();
        Profissao profissao = Profissao.AUTONOMO;
        pessoa9.setProfissao(profissao);
        assertEquals(profissao, pessoa9.getProfissao());
    }

    @Test
    void testSetVidasocial() {
        
    }
}
