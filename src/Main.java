import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
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

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}

