import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CapituloImagem extends Capitulos{
    private String img;
    public CapituloImagem(HashMap<String,Personagem> personagens, Scanner escaneadorCapitulos)
    {
        this.ler(personagens, escaneadorCapitulos);
        this.escolhas = new ArrayList<Escolha>();     
    }
    @Override
    public void mostrar()
    {
        System.out.println();
        System.out.println(img);
        System.out.println();
        super.mostrar();
    }
    @Override
    protected void ler(HashMap<String,Personagem> personagens, Scanner escaneadorCapitulos)
    {
        String linha = escaneadorCapitulos.nextLine();//IMAGEM
        linha = escaneadorCapitulos.nextLine();
        this.img = linha;
        linha = escaneadorCapitulos.nextLine();
        while(!linha.equals("FINAL"))
        {
            this.img = this.img + "\n" + linha;
            linha = escaneadorCapitulos.nextLine();
        }
        super.ler(personagens, escaneadorCapitulos);
    }
}