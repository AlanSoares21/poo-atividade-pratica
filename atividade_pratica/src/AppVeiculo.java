import java.util.Scanner;

public class AppVeiculo {
    private static Scanner input;
    public static void main(String[] args) throws Exception {
        input = new Scanner(System.in);
        GerenciarVeiculos controller = new GerenciarVeiculos();
        boolean repeat = true;
        while (repeat) {
            System.out.println("A - adicionar veiculo");
            System.out.println("R - remover veiculo");
            System.out.println("B - buscar veiculo por placa");
            System.out.println("L - listar veiculos");
            System.out.println("O - obter valor de imposto de um veiculo");
            System.out.println("C - listar veiculos por combustivel");
            System.out.println("S - sair");
            char choice = input.nextLine().charAt(0);
            switch(choice) {
                case 'a':
                case 'A':
                    controller.adicionar(descrevaVeiculo());
                    System.out.println("veiculo adicionado");
                    break;
                case 'r':
                case 'R':
                    System.out.println("Informe a placa:");
                    if (controller.remover(input.nextLine())) {
                        System.out.println("removido com sucesso");
                    } else {
                        System.out.println("nao foi possivel remover, verifique se digitou a placa corretamente");
                    }
                    break;
                case 'b':
                case 'B':
                    System.out.println("Informe a placa:");
                    Veiculo veiculo = controller.buscarPorPlaca(input.nextLine());
                    if (veiculo != null) {
                        System.out.println("---");
                        System.out.println("Veiculo encontrado");
                        System.out.println("Modelo - " + veiculo.getModelo());
                        System.out.println("Marca - " + veiculo.getMarca());
                        System.out.println("Ano - " + veiculo.getAno_fabric());
                        System.out.println("Placa - " + veiculo.getPlaca());
                        System.out.println("Combustivel - " + veiculo.getCombustivel());
                        System.out.println("Valor de mercado - " + veiculo.getValor_mercado());
                        System.out.println("---");
                    } else {
                        System.out.println("nao foi possivel encontrar o veiculo, verifique se digitou a placa corretamente");
                    }
                    break;
                case 'l':
                case 'L':
                    System.out.println();
                    System.out.println("---");
                    System.out.println(controller.listarVeiculos());
                    System.out.println("---");
                    System.out.println();
                    break;
                case 'o':
                case 'O':
                    System.out.println("Informe a placa:");
                    double valor = controller.obeterValorImposto(input.nextLine());
                    if (valor != -1) {
                        System.out.println("---");
                        System.out.println("Veiculo encontrado");
                        System.out.println("Valor de mercado - " + valor);
                        System.out.println("---");
                    } else {
                        System.out.println("nao foi possivel encontrar o veiculo, verifique se digitou a placa corretamente");
                    }
                    break;
                case 'c':
                case 'C':
                    System.out.println("Informe o combustivel:");
                    System.out.println(controller.listarVeiculoPorCombustivel(input.nextLine()));
                    break;
                case 's':
                case 'S':
                    System.out.println("Saindo:");
                    repeat = false;
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
            System.out.println();
            System.out.println("Digite para continuar...");
            input.nextLine();
            System.out.println();

        }
    }

    public static Veiculo descrevaVeiculo() {
        System.out.println("Digite a marca");
        String marca = input.nextLine();
        
        System.out.println("Digite o modelo");
        String modelo = input.nextLine();

        
        System.out.println("Digite o ano");
        int ano = Integer.parseInt(input.nextLine());

        System.out.println("Digite o valor");
        double valor = Double.parseDouble(input.nextLine());
        
        System.out.println("Informe o Combustivel");
        System.out.println("1 - para diesel");
        System.out.println("2 - para GNV");
        System.out.println("3 - para flex");
        System.out.println("4 - para gasolina");
        System.out.println("5 - para álcool");
        String combustivel;
        while (true) {
            char choice = input.nextLine().charAt(0);
            if (choice == '1') {
                combustivel = "diesel";
                break;
            }
            if (choice == '2') {
                combustivel = "GNV";
                break;
            }
            if (choice == '3') {
                combustivel = "flex";
                break;
            }
            if (choice == '4') {
                combustivel = "gasolina";
                break;
            }
            if (choice == '5') {
                combustivel = "álcool";
                break;
            }
            System.out.println("digite um valor valido");
        }
        
        System.out.println("Informe a placa");
        String placa = input.nextLine();

        return new Veiculo(modelo, marca, ano, valor, placa, combustivel);
    }
}
