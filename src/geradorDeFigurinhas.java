import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.text.Format;

import static java.awt.Color.*;

public class geradorDeFigurinhas {
        public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

            // leitura da imagem
            //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
            // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_2.jpg").openStream();

            BufferedImage imagemOriginal = ImageIO.read(inputStream);

            // cria nova imagem em memoria com transparencia e com tamanho novo

            int largura = imagemOriginal.getWidth();
            int altura = imagemOriginal.getHeight();
            int novaAltura = altura + 200;
            BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


            // copiar a imagem origina para nova imagem (em memória)

            Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
            graphics.drawImage(imagemOriginal, null,0, 0 );

            // Configurar a fonte

            var fonte = new Font(Font.SANS_SERIF, Font.ITALIC, 100);
            graphics.setColor(RED);
            graphics.setFont(fonte);

            // ecrever uma frase em uma nova imagem

            graphics.drawString("SAD BOY" , 0 , novaAltura - 100);

            // escrever em um arquivo

            ImageIO.write(novaImagem, "png", new File(nomeArquivo));




        }

    }

