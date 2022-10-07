import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Capitulos 
{
    private String nome,texto;
    protected ArrayList<Escolha> escolhas;
    private Personagem personagem;
    private int variacaoEnergy;
    
    protected Capitulos(){}

    public Capitulos(String nome, String texto, Personagem personagem, int quantidade)
    {
        this.nome = nome;
        this.texto = texto;
        this.escolhas = new ArrayList<>();
        this.personagem = personagem;
        this.variacaoEnergy = quantidade;
        
    }
    
    public Capitulos(HashMap<String,Personagem> personagens, Scanner escaneadorCapitulos)
    {
        this.ler(personagens,escaneadorCapitulos);
        this.escolhas = new ArrayList<Escolha>();
    }
    protected void ler(HashMap<String,Personagem> personagens, Scanner escaneadorCapitulos)
    {
        escaneadorCapitulos.nextLine(); //Nome do Capitulo
        this.nome = escaneadorCapitulos.nextLine(); 
        escaneadorCapitulos.nextLine(); //Conteúdo
        this.texto = escaneadorCapitulos.nextLine(); 
        escaneadorCapitulos.nextLine(); //Perosnagem
        this.personagem = personagens.get(escaneadorCapitulos.nextLine()); 
        escaneadorCapitulos.nextLine(); //Variação de Energia
        this.variacaoEnergy = Integer.parseInt(escaneadorCapitulos.nextLine());
    }
    public void addEscolhas(Escolha escolha)
    {
        this.escolhas.add(escolha); 
    }
    public String getNome()
    {
        return this.nome;
    }

    public String getText() {
        return this.texto;
    }

    public String alterarEnergiaPersonagem() {
         return this.personagem.energy(this.variacaoEnergy);
    }

    public ArrayList<Escolha> getEscolhas() {
        return this.escolhas;
    }
}
