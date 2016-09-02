package br.com.programmer.test;
import java.util.ArrayList;
import java.util.List;

import br.com.programmer.AliasToBeanResultTransformer;
import br.com.programmer.exception.AliasToBeanResultTransformerException;
import br.com.programmer.test.entities.Person;

public class Main {

	public static <T> void main(String[] args) {
		List<Object []> list = new ArrayList<Object []>();
		list.add(new String[]{"Andre", "Lucas", "Vectra"});
		list.add(new String[]{"Cesar", "John", "Corsa"});
		list.add(new String[]{"Juca", "Carlos", "Cruze"});
		list.add(new String[]{"Florentina", "Faker", "Cerato"});
		
		try {
			List<Person> newList = AliasToBeanResultTransformer.transformList(Person.class, list,  new String[]{"name", "son.name", "son.car.name"});
			System.out.println(newList.get(0).getSon().getName());//Andre's son name (Lucas)
			System.out.println(newList.get(1).getSon().getCar().getName()); ////John's car name (Corsa)
			System.out.println(newList.get(2).getName());//Juca
		} catch (AliasToBeanResultTransformerException e) {
			e.printStackTrace();
		}
	}
}

