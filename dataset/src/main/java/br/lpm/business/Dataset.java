package br.lpm.business;

import java.util.NoSuchElementException;

public class Dataset {
    public static final int MAX_PESSOAS = 20;
    private Pessoa[] pessoas;
    private int count;

    public Dataset() {
        this.pessoas = new Pessoa[MAX_PESSOAS];
        this.count = 0;
    }
    //Métodos de Acesso :

    public void addPessoa(Pessoa pessoa) {
        if (count < MAX_PESSOAS) { 
            pessoas[count] = pessoa; 
            count++;
        } 
    }

    public void removePessoa(Pessoa pessoa) {
        if (pessoa == null) {
            return; 
        }
        for (int i = 0; i < count; i++) {
            if (pessoas[i] == pessoa) { 
                for (int j = i; j < count - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[count - 1] = null; 
                count--;
                return; 
            }
        }
    }

    public void removePessoaByName(String nome) {
        for (int i = 0; i < count; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equals(nome)) { 
                for (int j = i; j < count - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[count - 1] = null; 
                count--; 
                return; 
            }
        }
    }

    public void replacePessoa(Pessoa oldPessoa, Pessoa newPessoa) {
        if (oldPessoa == null || newPessoa == null) {
            return; 
        }
        for (int i = 0; i < count; i++) {
            if (pessoas[i] != null && pessoas[i] == oldPessoa) {
                pessoas[i] = newPessoa;
                return; 
            }
        }
    }
    
    
    public Pessoa getPessoaByName(String nome) {
        if (nome == null) {
            return null; // Retorna null se o nome fornecido for null
        }
        for (int i = 0; i < count; i++) {
            if (pessoas[i] != null && nome.equals(pessoas[i].getNome())) {
                return pessoas[i];
            }
        }
        return null;
    }
    

    public Pessoa[] getAll() {
        Pessoa[] pessoasValidas = new Pessoa[count];
        for (int i = 0; i < count; i++) {
            pessoasValidas[i] = pessoas[i];
         }
        return pessoasValidas;
        }

    public void removeAll() {
        for (int i = 0; i < count; i++) {
            pessoas[i] = null; 
        }
        count = 0; 
    }

    //Métodos de Comportamento :

    public int size() {
        int count = 0;
        for (Pessoa p : pessoas) {
            if (p != null) {
                count++;
            }
        }
    return count;
    }

    public float maxAltura() {
        float maxHeight = Float.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            float currentHeight = pessoas[i].getAltura();
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
            }
        }
        return maxHeight;
    }

    public float minAltura() {
    float minHeight = Float.MAX_VALUE;
    for (int i = 0; i < count; i++) {
        float currentHeight = pessoas[i].getAltura();
        if (currentHeight < minHeight) {
            minHeight = currentHeight;
        }
    }
    return minHeight;
    }

    public float avgAltura(){
        if (count == 0) {
            return 0;
        }
        float soma = 0;
        for(int i = 0; i < count ; i++) {
            soma = soma + pessoas[i].getAltura();
        }
        return ((float) soma / count);
    }

    public float maxPeso(){
        float maxWeight = Float.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            float currentWeight = pessoas[i].getPeso();
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
        }
        return maxWeight;
    }

    public float minPeso() {
        float minWeight = Float.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            float currentWeight = pessoas[i].getPeso();
            if (currentWeight < minWeight) {
                minWeight = currentWeight;
        }
    }
        return minWeight;
    }

    public float avgPeso() {
        if (count == 0) {
            return 0;
        }
        float soma = 0;
        for(int i = 0; i < count ; i++) {
            soma = soma + pessoas[i].getPeso();
        }
        return ((float) soma / count);
    }

    public float percentAdult() {
        int total = count; 
        int legalAge = 0;
        if (total == 0) {
            return 0; 
        } 
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getIdade() >= 18) {
                legalAge++;
            }
        }
        return (float) legalAge / total * 100; 
    }

    public float percentEstadoCivil(EstadoCivil estadoCadastrado) {
        int contador = 0;
        int total = count;
        if (total == 0) {
            return 0;
        }
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getEstadoCivil().equals(estadoCadastrado)) {
                contador++;
            }
        }
        return (float) contador / total * 100;
    }
    
    public EstadoCivil modeEstadoCivil() {
        if (count == 0) {
            return null; 
        }
        EstadoCivil[] state = EstadoCivil.values();
        int[] frequency = new int[state.length];
        for (int i = 0; i < count; i++) {
            EstadoCivil stateTwo = pessoas[i].getEstadoCivil();
            for (int j = 0; j < state.length; j++) {
                if (state[j] == stateTwo) {
                    frequency[j]++;
                    break; 
                }
            }
        }
        EstadoCivil mostFrequentState = null;
        int maxFrequency = 0;
        for (int i = 0; i < state.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                mostFrequentState = state[i];
            }
        }
        return mostFrequentState; 
    }

    public float percentFormacaoAcademica(FormacaoAcademica formacaoAcad) {
        int contador = 0;
        int total = count;
        if (total == 0) {
            return 0;
        }
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getFormacaoAcadem().equals(formacaoAcad)) {
                contador++;
            }
        }
        return (float) contador / total * 100;
    }

    public FormacaoAcademica modeFormacaoAcademica() {
        if (count == 0) {
            return null; 
        }
        FormacaoAcademica[] acadFormation = FormacaoAcademica.values();
        int[] frequencyAcad = new int[acadFormation.length];
        for (int i = 0; i < count; i++) {
            FormacaoAcademica acadFormationTwo = pessoas[i].getFormacaoAcadem();
            for (int j = 0; j < acadFormation.length; j++) {
                if (acadFormation[j] == acadFormationTwo) {
                    frequencyAcad[j]++;
                    break; 
                }
            }
        }
        FormacaoAcademica mostFrequentAcad = null;
        int maxFrequencyAcad = 0;
        for (int i = 0; i < acadFormation.length; i++) {
            if (frequencyAcad[i] > maxFrequencyAcad) {
                maxFrequencyAcad = frequencyAcad[i];
                mostFrequentAcad = acadFormation[i];
            }
        }
        return mostFrequentAcad;
    }

    public float percentProfissao(Profissao profissao) {
        int contador = 0;
        int total = count;
        if (total == 0) {
            return 0;
        }
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getProfissao().equals(profissao)) {
                contador++;
            }
        }
        return (float) contador / total * 100;
    }

    public Profissao modeProfissao() {
        if (count == 0) {
            return null; 
        }
        Profissao[] profissao = Profissao.values();
        int[] frequency = new int[profissao.length];
        for (int i = 0; i < count; i++) {
            Profissao profissaoCount = pessoas[i].getProfissao();
            for (int j = 0; j < profissao.length; j++) {
                if (profissao[j] == profissaoCount) {
                    frequency[j]++;
                    break; 
                }
            }
        }
        Profissao mostFrequentJob = null;
        int maxFrequency = 0;
        for (int i = 0; i < profissao.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                mostFrequentJob = profissao[i];
            }
        }
        return mostFrequentJob;
    }

    public static float percentVidaSocial(boolean[] vidasocial) {
        int contador = 0;
        int total = vidasocial.length;
        if (total == 0) {
            return 0;
        }
        for (int i = 0; i < vidasocial.length; i++) {
            if (vidasocial[i]) {
                contador++;
            }
        }       
        return ((float) contador / total) * 100;
    }

    public static float percentHobby(boolean[] hobby) {
        int contador = 0;
        int total = hobby.length;
        if(total == 0) {
            return 0;
        }
        for(int i = 0; i < hobby.length; i++) {
            if(hobby[i]) {
                contador++;
            }
        }
        return ((float) contador / total) * 100;
    }

    public float avgAtividadeFisica() {
        if (count == 0) {
            return 0;
        }
        int soma = 0;
        for (int i = 0; i < count; i++) {
            soma += pessoas[i].getAtividadeFisica();
        }
        return ((float) soma / count);
    }

    public float svdAtividadeFisica() {
        if (count == 0) {
            return 0;
        }
        float media = avgAtividadeFisica();
        float somaQuadrados = 0;

        for (int i = 0; i < count; i++) {
            int dias = pessoas[i].getAtividadeFisica();
            float diferenca = (dias - media);
            somaQuadrados += (diferenca * diferenca);
        }
        float variancy = (somaQuadrados / count);
        return (float) Math.sqrt(variancy);
    }

    public float avgSaude() {
        if (count == 0) {
            return 0;
        }
        int soma = 0;
        for (int i = 0; i < count; i++) {
            soma += pessoas[i].getEstadoSaude();
        }
        return ((float) soma / count);
    }

    public float svdSaude() {
        if (count == 0) {
            return 0;
        }
        float media = avgSaude();
        float somaQuadrados = 0;
        for (int i = 0; i < count; i++) {
            int dias = pessoas[i].getEstadoSaude();
            float diferenca = (dias - media);
            somaQuadrados += (diferenca * diferenca);
        }
        float variancy = (somaQuadrados / count);
        return (float) Math.sqrt(variancy);
    }


}


    


    


    
    
    


    


    



    







