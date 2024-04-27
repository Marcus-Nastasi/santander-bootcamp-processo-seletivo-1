import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale locale = Locale.US;
        Scanner sc = new Scanner(System.in);

        System.out.println("Processo seletivo\n");
        System.out.print("Qual o seu salário pretendido: ");
        Double salarioPretendido = sc.nextDouble();


        analisarCandidato(salarioPretendido);

        sc.close();
    }

    public static void analisarCandidato(Double salarioPretendido) {
        Double salarioBase = 2000.00;

        if(salarioPretendido > salarioBase) System.out.println("Ligar para o candidato");
        else if(salarioPretendido.equals(salarioBase)) System.out.println("Ligar para o candidato com contraproposta");
        else System.out.println("Aguardando resultado dos demais candidatos");
    }

    public static void selecionaCandidatos() {
        Scanner sc = new Scanner(System.in);

        String[] candidatos = {"Marcus", "Julia", "Milena", "Juberto"};

        sc.close();
    }
}

