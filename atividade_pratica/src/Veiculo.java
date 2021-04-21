public class Veiculo {
    private String modelo;
    private String marca;
    private int ano_fabric;
    private double valor_mercado;
    private String placa;
    private String combustivel;
    
    public Veiculo(String modelo, String marca, int ano, double valor, String placa, String combustivel) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano_fabric = ano;
        this.valor_mercado = valor;
        this.placa = placa;
        this.combustivel = combustivel;
    }

    public double calcularImposto() {
        if (2021 - ano_fabric > 20) {
            return 0;
        } 
        if (combustivel.equals("gasolina") || combustivel.equals("diesel") || combustivel.equals("flex")) {
            return valor_mercado * 0.04;
        }
        return valor_mercado * 0.03;
    }

    public int getAno_fabric() {
        return ano_fabric;
    }
    public String getCombustivel() {
        return combustivel;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getPlaca() {
        return placa;
    }

    public double getValor_mercado() {
        return valor_mercado;
    }
    public void setValor_mercado(double valor_mercado) {
        this.valor_mercado = valor_mercado;
    }

}
