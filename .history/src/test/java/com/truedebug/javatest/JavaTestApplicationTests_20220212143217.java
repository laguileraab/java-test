package com.truedebug.javatest;

import java.util.List;
import java.util.Optional;

import com.truedebug.javatest.Entity.Menu;
import com.truedebug.javatest.Repositorio.MenuRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaTestApplicationTests {

	@Autowired
    private MenuRepository menuRepository;
    @Test
    public void whenFindingCustomerById_thenCorrect() {
        menuRepository.save(new Menu("John", "john@domain.com", null, null, null));
        assertThat(menuRepository.findById(1L)).isInstanceOf(Optional.class);
    }
    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        menuRepository.save(new Menu("John", "john@domain.com", null, null, null));
        menuRepository.save(new Menu("Julie", "julie@domain.com", null, null, null));
        assertThat(menuRepository.findAll()).isInstanceOf(List.class);
    }

	@Test
	public void whenSavingCustomer_thenCorrect() {
    	menuRepository.save(new Menu("Bob", "bob@domain.com", null, null, null));
    	Menu menu = menuRepository.findById(1L).orElseGet(() -> new Menu("john", "john@domain.com", null, null, null));
    	assertThat(menu.getMainDish()).isEqualTo("Bob");
	}

}
