import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Pessoa {
    private Date date;
    private String nasc;
    private String nome;
    public String apelido;

    public Pessoa(String nome, String nasc, String apelido) {
        this.nome = nome;
        this.nasc = nasc;
        this.apelido = apelido;
    }

    public int calcularIdade() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int anoAtual = Integer.parseInt(dateFormat.format(date));
        int idade = anoAtual - Integer.parseInt(this.nasc);
        return idade;
    }

    public String saudacao() {
        int idade = calcularIdade();
        return "Olá, me chamo " + this.nome + ", mas meu apelido é " + this.apelido + " e tenho " + idade + " anos!";
    }

}