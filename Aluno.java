
public class aluno extends Pessoa {

    private int mtr;
    private String curso;


    public aluno(String nome, String nasc, String apelido, int mtr, String curso) {
        super(nome, nasc, apelido);
        this.mtr = mtr;
        this.curso = curso;
    }

    @Override
    public String saudacao(){
        return super.saudacao() + " Minha matrícula é " +mtr+ " e faço o curso " + curso ;
    }
}
