import java.nio.file.Files;
import java.nio.file.Paths;

public class RequisicaoHtml {
    
    public static void main(String[] args) {
        
        try {
            // Caminho do arquivo
            String caminhoArquivo = "C:/Users/pablo/OneDrive/Área de Trabalho/Projeto-JAVA/ProjetoPetShop/src/index.html";

            // Ler o conteúdo do arquivo
            String conteudo = Files.readString(Paths.get(caminhoArquivo));

            // Imprimir o conteúdo do arquivo
            System.out.println("HTML recebido:");
            System.out.println(conteudo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
