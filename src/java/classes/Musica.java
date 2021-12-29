
package classes;

public class Musica 
{
    private String nomeM;
    private String nomeC;
    private String tp;

    public Musica(String nome, String cantor, String tp) {
        this.nomeM = nome;
        this.nomeC = cantor;
        this.tp = tp;
    }
    
    public String getNome()
    {
        String aux;
        nomeM = nomeM.replace(".","_");
        nomeM = nomeM.replace(",","_");
        nomeM = nomeM.replace("$","_");
        nomeM = nomeM.replace("%","_");
        nomeM = nomeM.replace("#","_");
        nomeM = nomeM.replace(";","_");
        nomeM = nomeM.replaceAll(" ", "");
            
        nomeC = nomeC.replace(".","_");
        nomeC = nomeC.replace(",","_");
        nomeC = nomeC.replace("$","_");
        nomeC = nomeC.replace("%","_");
        nomeC = nomeC.replace("#","_");
        nomeC = nomeC.replace(";","_");
        nomeC = nomeC.replaceAll(" ", "");
        aux=nomeM+"_"+nomeC+"_"+tp;
        return aux;
    }
}
