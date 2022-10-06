public class Personagem {
    private String nomeA;
    private int energia;

    public Personagem(String nomeP, int energia)
    {
        this.nomeA = nomeP;
        this.energia = energia;
    }
    public String energy(int quantidade)
    {   String resultado = "";
        this.energia = this.energia + quantidade;
        if(this.energia >=50)
        {
            resultado = (this.nomeA + " ganhou " + quantidade + " e ficou com um total de " + this.energia + " de energia");
        }
        else if(this.energia < 50)
        {
            resultado = (this.nomeA + " perdeu " + quantidade + " e ficou com um total de " + this.energia + " de energia");
        }
        else if(this.energia ==0)
        {
            resultado = (" O personagem " + this.nomeA + "perdeu tudo, o jogo, inclusive a vida!");
        }
        return resultado;
    }
}
