import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class aluraStickers {
    public static void main(String[] args) throws Exception {
        //make an HTTP connection and fetch the top 250 movies

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        // extract only the data of interest (title, poster, rating)

        var parser = new jsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(json);

        // display and manipulate data

        for (Map<String, String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new geradorDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println("\u001b[37m\u001b[40m\u001b[1m");
            System.out.println(filme.get("image"));
            System.out.println();
            System.out.println("\u2B50\u001b[4m Rating: "  + filme.get("imDbRating"));
            System.out.println();
            System.out.println(filme.get("title"));
            System.out.println("\u001b[0m");


            
        }

    }
}