import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Dicionario 
{
    public HashMap<String,Personagem> LeitorPersonagem(String caminhoArquivoPersonagem)
    {  
        HashMap<String,Personagem> personagens = new HashMap<String,Personagem>();
        File arquivoPersonagem = new File(caminhoArquivoPersonagem);
        try 
        {
            Scanner escaneadoDeArquivos = new Scanner(arquivoPersonagem, "UTF-8");
            String linhaLida= "";
            String linhaNamePerso= "";
            int linhaEnergia= 0;
            while(escaneadoDeArquivos.hasNextLine())
            {
                while(!linhaLida.equals("PERSONAGEM"))
                {
                    linhaLida = escaneadoDeArquivos.nextLine();
                }
                linhaLida = escaneadoDeArquivos.nextLine();//Nome
                linhaNamePerso = escaneadoDeArquivos.nextLine();
                linhaLida = escaneadoDeArquivos.nextLine();//Energia
                linhaEnergia = Integer.parseInt(escaneadoDeArquivos.nextLine());//
                personagens.put(linhaNamePerso, new Personagem(linhaNamePerso,linhaEnergia));
            }
            escaneadoDeArquivos.close();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return personagens;
    }
    public HashMap<String,Capitulos> LeitorCapitulos(String caminhoArquivoCapitulo,HashMap<String,Personagem> personagens)
    {
        HashMap<String,Capitulos> caps = new HashMap<String,Capitulos>();
        File arquivoCapitulo = new File(caminhoArquivoCapitulo);
        try {
            Scanner escaneadorCapitulos = new Scanner(arquivoCapitulo, "UTF-8");
            while(escaneadorCapitulos.hasNextLine())
            {
                String linhaLidaCap = "";
                while(!linhaLidaCap.equals("CAPITULO") && !linhaLidaCap.equals("CAPITULO_COM_IMAGEM") && !linhaLidaCap.equals("ESCOLHA"))
                {
                    linhaLidaCap = escaneadorCapitulos.nextLine();
                }
                if(linhaLidaCap.equals("CAPITULO_COM_IMAGEM"))
                {
                    CapituloImagem capitulo = new CapituloImagem(personagens,escaneadorCapitulos);
                    caps.put(capitulo.getNome(),capitulo);
                    linhaLidaCap="";
                }
                else if(linhaLidaCap.equals("CAPITULO"))
                {
                    Capitulos capitulo = new Capitulos(personagens,escaneadorCapitulos);
                    caps.put(capitulo.getNome(),capitulo);
                    linhaLidaCap="";
                }
                else if(linhaLidaCap.equals("ESCOLHA"))
                {
                    lerEscolhas(caps,escaneadorCapitulos);
                    linhaLidaCap = "";
                }
            }
        } catch (FileNotFoundException exception) 
        {
            exception.printStackTrace();
        }
        return caps;
    }
    private void lerEscolhas(HashMap<String,Capitulos> caps, Scanner escaneadorCapitulos)
    {
        String linhaOrigem = "";
        String linhaName = "";
        String linhaDestino = "";
        String linhaLidaEscolhas = "";

        linhaLidaEscolhas = escaneadorCapitulos.nextLine();//Escolha Origem
        linhaOrigem = escaneadorCapitulos.nextLine();
        linhaLidaEscolhas = escaneadorCapitulos.nextLine();// Qual será a escolha
        linhaName = escaneadorCapitulos.nextLine();
        linhaLidaEscolhas = escaneadorCapitulos.nextLine();//Destino
        linhaDestino = escaneadorCapitulos.nextLine();

        Escolha opcao = new Escolha(linhaName, caps.get(linhaDestino));
        caps.get(linhaOrigem).addEscolhas(opcao);

    }
    
}
