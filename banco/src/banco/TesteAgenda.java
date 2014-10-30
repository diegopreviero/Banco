/*
http://www.brunorota.com.br/2012/05/19/tutorial-criar-crud-em-java-com-jdbc-parte-1-final/
http://www.brunorota.com.br/2012/05/14/tutorial-criar-crud-em-java-com-jdbc-parte-1/


create database "d:\agenda.fbd" user "sysdba" password "masterkey";

connect "d:\agenda.fbd" user "sysdba" password "masterkey";

create table contatos(
	id int not null primary key,
	nome varchar(40),
	idade int,
	dataCadastro date
);

 */
package banco;

import java.util.Date;

public class TesteAgenda {

	public static void main(String args[]){
		TesteAgenda t = new TesteAgenda();

		//popula o banco com 5 registros
		/*for (int i = 0; i < 5; i++) {
			t.insere(i,"antonio",(5*i)/3);
		}*/

		//t.altera(1,"carla",26);
		//t.remove(1);

		t.lista();

	}

	ContatoDAO contatoDAO = new ContatoDAO();

	public void insere(int id, String nome, int idade){
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setIdade(idade);
		contato.setDataCadastro(new Date());

		contatoDAO.save(contato);
	}

	public void altera(int id, String nome, int idade){
		Contato contato1 = new Contato();
		contato1.setId(id);
		contato1.setNome(nome);
		contato1.setIdade(idade);
		contato1.setDataCadastro(new Date());

		contatoDAO.update(contato1);
	}

	public void remove(int id){
		contatoDAO.removeById(id);
	}

	public void lista(){
		for(Contato c : contatoDAO.getContatos()){
			System.out.println("Nome: "+c.getNome()+"\nIdade: "+c.getIdade()+"\nCadastro: "+c.getDataCadastro()+"\n");
		}
	}
}