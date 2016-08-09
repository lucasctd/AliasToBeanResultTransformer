package br.com.programmer.test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.programmer.ProjectionHelper;
import br.com.programmer.exception.ProjectionHelperException;
import br.com.programmer.test.entities.Person;

public class Main {

	public static <T> void main(String[] args) {
		BigDecimal [] desfribilacao = new BigDecimal [3];
		desfribilacao[0] = new BigDecimal(10);
		desfribilacao[1] = new BigDecimal(11);
		
		List<Object []> lista = new ArrayList<Object []>();
		lista.add(new String[]{"Andre", "Lucas", "Vectra"});
		lista.add(new String[]{"Cesar", "John", "Corsa"});
		lista.add(new String[]{"Juca", "Carlos", "Cruze"});
		lista.add(new String[]{"Florentina", "Faker", "Cerato"});
		
		ProjectionHelper ph = new ProjectionHelper();
		try {
			List<Person> list = ph.transformList(Person.class, lista,  new String[]{"name", "son.name", "son.car.name"});
			System.out.println(list.get(0).getSon().getName());//Andre's son name (Lucas)
			System.out.println(list.get(1).getSon().getCar().getName()); ////John's car name (Corsa)
			System.out.println(list.get(2).getName());//Juca
		} catch (ProjectionHelperException e) {
			e.printStackTrace();
		}
	}
}

