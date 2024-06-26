
import java.util.Scanner;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoApi consumo = new ConsumoApi();
    private final ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "34f6e3db0f18c8317dc2aac7/";

    public void exibeMenu() {
        int opcao = -1;
        while (opcao != 0) {
            String menu = """
                    1 - Dólar =>> para Real
                    2 - Dólar =>> para AUD
                    3 - Real =>> para JPY
                    4 - JPY =>> para Dólar
                    5 - Sair 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1 -> usdParaReal();
                case 2 -> usdParaAud();
                case 3 -> brlParaJpy();
                case 4 -> jpyParaUsd();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void usdParaReal() {
        converterMoeda(Moeda.USD, "BRL");
    }

    private void usdParaAud() {
        converterMoeda(Moeda.USD, "AUD");
    }

    private void brlParaJpy() {
        converterMoeda(Moeda.BRL, "JPY");
    }

    private void jpyParaUsd() {
        converterMoeda(Moeda.JPY, "USD");
    }

    private void converterMoeda(Moeda moeda, String to) {
        String json = consumo.obterDados(ENDERECO + API_KEY + "latest/".replace("", "+") + moeda);
        DadosMoeda dados = conversor.obterDados(json, DadosMoeda.class);
        Double taxa = null;

        switch (to) {
            case "BRL" -> taxa = dados.getReal();
            case "AUD" -> taxa = dados.getAud();
            case "JPY" -> taxa = dados.getJpy();
            case "USD" -> taxa = dados.getDolar();
        }

        if (taxa != null) {
            System.out.println("1 " + moeda + " = " + taxa + " " + to);
        } else {
            System.out.println("Erro ao obter a taxa de conversão.");
        }
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.exibeMenu();
    }
}
