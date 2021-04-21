import java.util.ArrayList;

public class GerenciarVeiculos {
    private ArrayList<Veiculo> lista;

    public GerenciarVeiculos() {
        this.lista = new ArrayList<Veiculo>();
    }

    public void adicionar(Veiculo veiculo) {
        lista.add(veiculo);
    }

    public boolean remover(String placa) {
        for (int i = 0; i < lista.size(); i++) {
            Veiculo veiculo = lista.get(i);
            if (veiculo.getPlaca().equals(placa)) {
                lista.remove(i);
                return true;
            }
        }
        return false;
    }

    public Veiculo buscarPorPlaca (String placa) {
        for (int i = 0; i < lista.size(); i++) {
            Veiculo veiculo = lista.get(i);
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public String listarVeiculos() {
        String result = "--- listando veiculos --- \n";
        for (Veiculo veiculo : lista) {
            result += "--- \n";
            result += "Placa - "+ veiculo.getPlaca() + "\n"; 
            result += "Modelo - "+ veiculo.getModelo() +"\n"; 
            result += "Marca - " + veiculo.getMarca() +"\n";
            result += "Combustivel - " + veiculo.getCombustivel() +"\n";
            result += "Ano - " + veiculo.getAno_fabric() +"\n";
            result += "Total - "+ veiculo.getValor_mercado() + "\n";
            result += "---";
        }
        return result + "\n--- \n";
    }

    public double obeterValorImposto(String placa) {
        Veiculo veiculo = buscarPorPlaca(placa);
        if (veiculo == null)
            return -1;
        return veiculo.getValor_mercado();
    }

    public String listarVeiculoPorCombustivel(String combustivel) {
        String result = "--- listando por combustivel ("+combustivel+") --- \n";
        for (Veiculo veiculo : lista) {
            if (veiculo.getCombustivel().equals(combustivel)) {
                result += "--- \n";
                result += "Placa - "+ veiculo.getPlaca() + "\n"; 
                result += "Modelo - "+ veiculo.getModelo() +"\n"; 
                result += "Marca - " + veiculo.getMarca() +"\n";
                result += "Combustivel - " + veiculo.getCombustivel() +"\n";
                result += "Ano - " + veiculo.getAno_fabric() +"\n";
                result += "Total - "+ veiculo.getValor_mercado() + "\n";
                result += "--- \n";
            }
        }
        return result + "\n\n---\n";
    }
}
