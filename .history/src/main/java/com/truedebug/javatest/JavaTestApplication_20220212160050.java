package com.truedebug.javatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTestApplication.class, args);
		Menu menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
		menuRepository.save(menu);
		menu = new Menu("Cerdo","Congri","Pepino","Helado","Granizado");
		menuRepository.save(menu);
		menu = new Menu("Picadillo","Arroz","Papa","Pancake","Coca cola");
		menuRepository.save(menu);
		menu = new Menu("Perro","Spaghetti","Queso","Dulce de leche","Vodka");
		menuRepository.save(menu);
		menu = new Menu("Jamon","Tallarines","Queso","Pudin","Pepsi");
		menuRepository.save(menu);
		menu = new Menu("Res","Arroz con frijoles","Machuquillo","Boniatillo","Vino tinto");
		menuRepository.save(menu);
	}
}
