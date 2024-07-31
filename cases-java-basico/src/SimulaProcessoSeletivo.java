import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SimulaProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        // System.out.println("PROCESSO SELETIVO");
        // System.out.println("\nCASE 01 - ANALISAR CANDIDATOS\n");
        // analisarCandidatos(1600.0);
        // System.out.println("\nCASE 02 - SELECIONAR CANDIDATOS\n");
        // selecionarCandidato();
        // System.out.println("\nCASE 03 - IMPRIMIR LISTA DE CANDIDATOS SELECIONAMDOS\n");
        // imprimirCandidatosSelecionados();
        System.out.println("\nCASE 04 - CONTATAR CANDIDATOS SELECIONADOS\n");
        telefonarCandidatosSelecionados();
    }

    //Emula os valores de salários pretendidos
    private static double simularSalarioPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    //Emula o atendimento do telefone
    private static boolean atenderTelefone() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    //Case 01
    public static void analisarCandidatos(double salarioPretendido) {
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO.");
        } else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO E OFERECER CONTRA-PROPOSTA.");
        } else {
            System.out.println("AGUARDAR O RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }

    //Case 02
    public static void selecionarCandidato() {
        double salarioBase = 2000.0;
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int totalSelecionados = 0;
        int proximoCandidato = 0;

        while(totalSelecionados < 5 && proximoCandidato < candidatos.length) {
            String candidato = candidatos[proximoCandidato++];
            double salarioPretendido = simularSalarioPretendido();

            System.out.printf("O candidato %s está pedindo R$%.2f \n", candidato, salarioPretendido);
            
            if(salarioBase < salarioPretendido) {
                System.out.printf("O candidato %s NÃO foi selecionado\n", candidato);
            } else {
                System.out.printf("O candidato %s FOI selecionado\n", candidato);
                totalSelecionados++;
            }            
        }

        System.out.println("Total de selecionados: " + totalSelecionados);
        System.out.println("Total de consultados: " + proximoCandidato);
    }

    
    //Case 03
    public static List<String> imprimirCandidatosSelecionados() {
        List<String> candidatos = new ArrayList<>(Arrays.asList("FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"));
        System.out.println("Os candidatos selecionados foram: ");
        List<String> candidatosSelecionados = new ArrayList<>();
        
        Collections.shuffle(candidatos, ThreadLocalRandom.current());
        
        for(int i = 0; i < 5; i++){
            candidatosSelecionados.add(candidatos.get(i));
        }
        System.out.println(candidatosSelecionados);
        return candidatosSelecionados;
    }

    //Case 04
    public static void telefonarCandidatosSelecionados(){
        List<String> candidatos = imprimirCandidatosSelecionados();
        int numeroLigacao = 0;
        
        for(int i = 0; i < candidatos.size(); i++) {
            boolean atendeu = false;
            while(numeroLigacao < 3)
            {
                numeroLigacao++;
                atendeu = atenderTelefone();
                if(atendeu){
                    System.out.printf("Conseguimos contato com o candidato %s em %d tentativa(s)\n", candidatos.get(i), numeroLigacao);
                    break;
                } 
            }    
            if(!atendeu) {
                System.out.printf("Não conseguimos contato com o candidato %s\n", candidatos.get(i));
                continue;
            }
        }
    }

}
