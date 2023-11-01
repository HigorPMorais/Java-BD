package modelo;

public class Endereco {
    private Integer idEndereco;
    private String cidade;
    private String rua;
    private String numero;

    public Endereco() {
    }

    public Endereco(Integer idEndereco, String cidade, String rua, String numero) {
        this.idEndereco = idEndereco;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public void exibir(){
        System.out.println("\nInformacoes do Endereco");
        System.out.println("idEndereco: " + idEndereco + 
                "\nCidade: " + cidade + 
                "\nRua: " + rua + 
                "\nNumero: " + numero);
    }
     
}
