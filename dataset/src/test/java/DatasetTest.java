

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.lpm.business.Pessoa;
import br.lpm.business.Profissao;
import br.lpm.business.Dataset;
import br.lpm.business.EstadoCivil;
import br.lpm.business.FormacaoAcademica;



public class DatasetTest {

    private Dataset dataset;

    @BeforeEach
    public void setUp() {
        dataset = new Dataset();
        dataset.removeAll();  
    }

    @Test
    public void testAddPessoa() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("João");
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Maria");

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        assertEquals(2, dataset.size());

        Pessoa[] pessoas = dataset.getAll();
        assertNotNull(pessoas);

        int count = 0;
        for (Pessoa p : pessoas) {
            if (p != null) {
            count++;
        }
    }
        assertEquals(2, count);
        boolean pessoa1Presente = false;
        boolean pessoa2Presente = false;
        for (Pessoa p : pessoas) {
            if (p != null) {
                if (p.equals(pessoa1)) {
                    pessoa1Presente = true;
            }
            if (p.equals(pessoa2)) {
                pessoa2Presente = true;
            }
        }
    }   
        assertTrue(pessoa1Presente);
        assertTrue(pessoa2Presente);
}

    @Test
    void testAvgAltura() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setAltura(1.70f); 

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setAltura(1.80f); 

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setAltura(1.90f);

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        float expectedAvg = (1.70f + 1.80f + 1.90f) / 3;

        assertEquals(expectedAvg, dataset.avgAltura());
    }

    @Test
    void testAvgAtividadeFisica() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setAtividadeFisica(4); 

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setAtividadeFisica(4); 

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        float expectedAvg = (4 + 4) / 2f; 
        float delta = 0.01f; 

        assertEquals(expectedAvg, dataset.avgAtividadeFisica(), delta);
    }

    @Test
    void testAvgPeso() {
        Pessoa pessoa1 = new Pessoa ();
        pessoa1.setPeso(55.2f);

        Pessoa pessoa2 = new Pessoa ();
        pessoa2.setPeso(89.5f);

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        float expectedAvg = (55.2f + 89.5f) / 2f;
        float delta = 0.01f;

        assertEquals(expectedAvg, dataset.avgPeso(), delta);
    }

    @Test
    void testAvgSaude() {
        Pessoa pessoa1 = new Pessoa ();
        pessoa1.setEstadoSaude(8);

        Pessoa pessoa2 = new Pessoa ();
        pessoa2.setEstadoSaude(3);

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        float expectedAvg = (8 + 3) / 2f;
        float delta = 0.01f;

        assertEquals(expectedAvg, dataset.avgSaude(), delta);
    }

    @Test
    void testGetAll() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Ana");
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Carlos");
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        
        Pessoa[] pessoas = dataset.getAll();
        
        Pessoa[] expectedPessoas = { pessoa1, pessoa2 };
        
        assertArrayEquals(expectedPessoas, pessoas);
    }

    @Test
    void testGetPessoaByName() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Ana");
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Carlos");
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        
        Pessoa result = dataset.getPessoaByName("Ana");
        assertEquals(pessoa1, result);
        
        result = dataset.getPessoaByName("Maria");
        assertNull(result);
    }

    @Test
    void testMaxAltura() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setAltura(1.72f);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setAltura(1.95f);
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setAltura(1.63f);
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        
        float result = dataset.maxAltura();
        assertEquals(1.95f, result);
    }

    @Test
    void testMaxPeso() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setPeso(89.5f);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setPeso(58.3f);

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        float result = dataset.maxPeso();
        assertEquals(89.5f, result);
    }

    @Test
    void testMinAltura() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setAltura(1.62f);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setAltura(1.89f);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setAltura(1.53f);

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        float result = dataset.minAltura();
        assertEquals(1.53f, result);

    }

    @Test
    void testMinPeso() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setPeso(89.5f);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setPeso(58.3f);

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        float result = dataset.minPeso();
        assertEquals(58.3f, result);

    }

    @Test
    void testModeEstadoCivil() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEstadoCivil(EstadoCivil.DIVORCIADO);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEstadoCivil(EstadoCivil.SOLTEIRO);
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEstadoCivil(EstadoCivil.CASADO);
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setEstadoCivil(EstadoCivil.SEPARADO);
        
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setEstadoCivil(EstadoCivil.SEPARADO);
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);
        dataset.addPessoa(pessoa5);
        
        EstadoCivil result = dataset.modeEstadoCivil();
        assertEquals(EstadoCivil.SEPARADO, result);
    }

    @Test
    void testModeFormacaoAcademica() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setFormacaoAcadem(FormacaoAcademica.MEDIA);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setFormacaoAcadem(FormacaoAcademica.SUPERIOR);
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setFormacaoAcadem(FormacaoAcademica.SUPERIOR);
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setFormacaoAcadem(FormacaoAcademica.BASICA);
        
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setFormacaoAcadem(FormacaoAcademica.SUPERIOR);
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);
        dataset.addPessoa(pessoa5);
        
        FormacaoAcademica result = dataset.modeFormacaoAcademica();
        assertEquals(FormacaoAcademica.SUPERIOR, result);
    }

    @Test
    void testModeProfissao() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setProfissao(Profissao.CLT);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setProfissao(Profissao.CLT);
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setProfissao(Profissao.ESTUDANTE);
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setProfissao(Profissao.CLT);
        
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setProfissao(Profissao.AUTONOMO);
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);
        dataset.addPessoa(pessoa5);
        
        Profissao result = dataset.modeProfissao();
        assertEquals(Profissao.CLT, result);
    }

    @Test
    void testPercentAdult() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setIdade(24); // MAIOR
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setIdade(15); // MENOR
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setIdade(35); // MAIOR
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setIdade(12); // MENOR
        
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setIdade(42); // MAIOR

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);
        dataset.addPessoa(pessoa5);
        
        float result = dataset.percentAdult();
        
        float esperado = 60.0f;
        
        assertEquals(esperado, result, 0.01);

    }

    @Test
    void testPercentEstadoCivil() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEstadoCivil(EstadoCivil.SEPARADO);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEstadoCivil(EstadoCivil.SOLTEIRO);
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEstadoCivil(EstadoCivil.CASADO);
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setEstadoCivil(EstadoCivil.SEPARADO);
        
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setEstadoCivil(EstadoCivil.SEPARADO);
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);
        dataset.addPessoa(pessoa5);
        
        float resultSeparado = dataset.percentEstadoCivil(EstadoCivil.SEPARADO);
        float expectedSeparado = 60.0f;

        assertEquals(expectedSeparado, resultSeparado, 0.01);
        
        float resultCasado = dataset.percentEstadoCivil(EstadoCivil.CASADO);
        float expectedCasado = 20.0f;
    
        assertEquals(expectedCasado, resultCasado, 0.01);

        float resultSolteiro = dataset.percentEstadoCivil(EstadoCivil.SOLTEIRO);
        float expectedSolteiro = 20.0f;

        assertEquals(expectedSolteiro, resultSolteiro, 0.01);
    }

    @Test
    void testPercentFormacaoAcademica() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setFormacaoAcadem(FormacaoAcademica.MEDIA);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setFormacaoAcadem(FormacaoAcademica.SUPERIOR);
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setFormacaoAcadem(FormacaoAcademica.SUPERIOR);
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setFormacaoAcadem(FormacaoAcademica.BASICA);
        
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setFormacaoAcadem(FormacaoAcademica.SUPERIOR);
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);
        dataset.addPessoa(pessoa5);
        
        float resultSuperior = dataset.percentFormacaoAcademica(FormacaoAcademica.SUPERIOR);
        float expectedSuperior = 60.0f;

        assertEquals(expectedSuperior, resultSuperior, 0.01);
        
        float resultMedia = dataset.percentFormacaoAcademica(FormacaoAcademica.MEDIA);
        float expectedMedia = 20.0f;
    
        assertEquals(expectedMedia, resultMedia, 0.01);

        float resultBasica = dataset.percentFormacaoAcademica(FormacaoAcademica.BASICA);
        float expectedBasica = 20.0f;

        assertEquals(expectedBasica, resultBasica, 0.01);
    }

    @Test
    void testPercentHobby() {
        boolean[] hobbies = {true, false, true, true, false};
        float resultTrue = dataset.percentHobby(hobbies);
        float expectedTrue = 60.0f;
        assertEquals(expectedTrue, resultTrue, 0.01);
    }

    @Test
    void testPercentProfissao() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setProfissao(Profissao.CLT);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setProfissao(Profissao.CLT);
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setProfissao(Profissao.ESTUDANTE);
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setProfissao(Profissao.CLT);
        
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setProfissao(Profissao.AUTONOMO);
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);
        dataset.addPessoa(pessoa5);

        float resultClt = dataset.percentProfissao(Profissao.CLT);
        float expectedClt = 60.0f;

        assertEquals(expectedClt, resultClt, 0.01);

        float resultEstudante = dataset.percentProfissao(Profissao.ESTUDANTE);
        float expectedEstudante = 20.0f;

        assertEquals(expectedEstudante, resultEstudante, 0.01);

        float resultAutonomo = dataset.percentProfissao(Profissao.AUTONOMO);
        float expectedAutonomo = 20.0f;

        assertEquals(expectedAutonomo, resultAutonomo, 0.01);
    }

    @Test
    void testPercentVidaSocial() {
        boolean[] vidasocial = {true, true, true, true, false};
        float resultTrue = dataset.percentHobby(vidasocial);
        float expectedTrue = 80.0f;
        assertEquals(expectedTrue, resultTrue, 0.01);
    }

    @Test
    void testRemoveAll() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Mauricio");
        pessoa1.setAltura(1.89f);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Luana");
        pessoa2.setAltura(1.55f);
        
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        assertEquals(2, dataset.size());

        dataset.removeAll();

        assertEquals(0, dataset.size());
    }

    @Test
    void testRemovePessoa() {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        pessoa1.setNome("João");
        pessoa2.setNome("Maria");

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        assertEquals(2, dataset.size());

        dataset.removePessoa(pessoa1);
    
        Pessoa[] pessoasRestantes = dataset.getAll(); 
        assertEquals(1, pessoasRestantes.length); 
        assertEquals("Maria", pessoasRestantes[0].getNome());
    }

    @Test
    void testRemovePessoaByName() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Pedro");
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Mariana");
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Roberto");

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(3, dataset.size());

        dataset.removePessoaByName("Mariana");

        Pessoa[] pessoasRestantes = dataset.getAll(); 
        assertEquals(2, pessoasRestantes.length); 
    }

    @Test
    void testReplacePessoa() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("João");
        pessoa1.setAltura(1.75f);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Maria");
        pessoa2.setAltura(1.65f);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Ana");
        pessoa3.setAltura(1.70f);

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome("Maria");
        novaPessoa.setAltura(1.80f); 

        dataset.replacePessoa(pessoa2, novaPessoa);

        Pessoa pessoaSubstituida = dataset.getPessoaByName("Maria");

        assertNotNull(pessoaSubstituida);
        assertEquals("Maria", pessoaSubstituida.getNome());
        assertEquals(1.80f, pessoaSubstituida.getAltura(), 0.01f);
        
}
    @Test
    void testSize() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Abobora");
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Paulo");
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Derci");

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        int expectedSize = 3;
        int resultedSize = dataset.size();

        assertEquals(expectedSize, resultedSize);

    }

    @Test
    void testSvdAtividadeFisica() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setAtividadeFisica(3);
        dataset.addPessoa(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setAtividadeFisica(5);
        dataset.addPessoa(pessoa2);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setAtividadeFisica(7);
        dataset.addPessoa(pessoa3);

        float media = dataset.avgAtividadeFisica();
        float varianciaEsperada = (float) ((Math.pow(3 - media, 2) + Math.pow(5 - media, 2) + Math.pow(7 - media, 2)) / 3);
        float desvioPadraoEsperado = (float) Math.sqrt(varianciaEsperada);
        float desvioPadraoCalculado = dataset.svdAtividadeFisica();

        assertEquals(desvioPadraoEsperado, desvioPadraoCalculado, 0.01f);

    }

    @Test
    void testSvdSaude() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEstadoSaude(3);
        dataset.addPessoa(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEstadoSaude(5);
        dataset.addPessoa(pessoa2);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEstadoSaude(7);
        dataset.addPessoa(pessoa3);

        float media = dataset.avgSaude();
        float varianciaEsperada = (float) ((Math.pow(3 - media, 2) + Math.pow(5 - media, 2) + Math.pow(7 - media, 2)) / 3);
        float desvioPadraoEsperado = (float) Math.sqrt(varianciaEsperada);
        float desvioPadraoCalculado = dataset.svdSaude();
        assertEquals(desvioPadraoEsperado, desvioPadraoCalculado, 0.01f);

    }
}
