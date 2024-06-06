
public class teste {
    public static void main(String[] args) {
        Pessoa tio = new Pessoa("amanda", "2007", "mandy");
        System.out.println(tio.saudacao());

        aluno al = new aluno("pedro", "1956","pedrin", 54684, "Informática");
        System.out.println(al.saudacao());

        Professor prof = new Professor("matheus", "1940", "teus", 20656, "História", 2012);
        System.out.println(prof.saudacao());

        funcionario fun = new funcionario("Roberto", "1980", "bertinho", "desenvolvedor web", 5000);
        System.out.println(fun.saudacao());
    }
}