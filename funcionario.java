public class funcionario extends Pessoa {

    private String funcao;
    private double salario;

    public funcionario(String nome, String nasc, String apelido, String funcao, double salario) {
        super(nome, nasc, apelido);
        this.funcao = funcao;
        this.salario = salario;
    }

    @Override
    public String saudacao(){
        return super.saudacao() + " Minha função é " +funcao+ " e meu salário é de " +salario+" reais!";   
    }
}
