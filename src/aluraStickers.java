import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class aluraStickers {
    public static void main(String[] args) throws Exception {
        //make an HTTP connection and fetch the top 250 movies

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)

        var parser = new jsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(json);

        // exibir e manipular os dados

        for (Map<String, String> filme : listaDeFilmes) {
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