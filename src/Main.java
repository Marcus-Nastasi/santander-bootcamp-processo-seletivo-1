import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Locale locale = Locale.US;
        Scanner sc = new Scanner(System.in);

        System.out.println("Processo seletivo\n");
        System.out.print("Qual o seu salário pretendido: ");
        double salarioPretendido = sc.nextDouble();

        analisarCandidato(salarioPretendido);
        selecionaCandidatos();
        ligarCandidatos();

        sc.close();
    }

    public static void analisarCandidato(Double salarioPretendido) {
        Double salarioBase = 2000.00;

        if(salarioPretendido > salarioBase) System.out.println("\nLigar para o candidato\n");
        else if(salarioPretendido.equals(salarioBase)) System.out.println("\nLigar para o candidato com contraproposta\n");
        else System.out.println("\nAguardando resultado dos demais candidatos\n");
    }

    public static void selecionaCandidatos() {
        Scanner sc = new Scanner(System.in);

        double salarioBase = 2000.00;
        String[] candidatos = {"Marcus", "Julia", "Milena", "Juberto", "Ana", "Stella", "Maria"};
        ArrayList<String> listaCandidatosSelecionados = new ArrayList<>();

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado!");
                listaCandidatosSelecionados.add(candidato);
                candidatosSelecionados++;
                candidatoAtual++;
            } else System.out.println("Candidato " + candidato + " não selecionado");

            candidatoAtual++;
        }

        System.out.println("\nA lista de candidatos selecionados está abaixo: \n");

        for(String c: listaCandidatosSelecionados) System.out.println(c);

        sc.close();
    }

    public static void ligarCandidatos() {
        String[] candidatos = {"Marcus", "Julia", "Milena", "Juberto", "Ana", "Stella", "Maria"};
        for(String c: candidatos) {
            int tentativas = 1;
            boolean continuarTentando = true;
            boolean atendeu = false;

            do {
                atendeu = atender();
                continuarTentando = !atendeu;

                if (continuarTentando) tentativas++;
                else System.out.println("CONTATO REALIZADO COM SUCESSO");
            } while (continuarTentando && tentativas < 3);

            if (atendeu) System.out.println("CONSEGUIMOS CONTATO COM O CANDIDATO " + c);
            else System.out.println("NÃO CONSEGUIMOS CONTATO COM NENHUM CANDIDATO");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }
}

