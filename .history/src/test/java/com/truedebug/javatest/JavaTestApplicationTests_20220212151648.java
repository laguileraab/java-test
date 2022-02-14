package com.truedebug.javatest;

/*import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import com.truedebug.javatest.Entity.Menu;
import com.truedebug.javatest.Repositorio.MenuRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;*/

@SpringBootTest
class JavaTestApplicationTests {

	/*@Autowired
    private MenuRepository menuRepository;

    @Test
    public void whenFindingMenuById_thenCorrect() {
        menuRepository.save(new Menu("John", "john@domain.com", null, null, null));
        //assertThat(menuRepository.findById(1L)).isInstanceOf(Optional.class);
    }
    @Test
    public void whenFindingAllMenu_thenCorrect() {
        menuRepository.save(new Menu("John", "john@domain.com", null, null, null));
        menuRepository.save(new Menu("Julie", "julie@domain.com", null, null, null));
        //assertThat(menuRepository.findAll()).isInstanceOf(List.class);
    }

	@Test
	public void whenSavingMenu_thenCorrect() {
		menuRepository.save(new Menu("Bob", "bob@domain.com", null, null, null));
		Menu menu = menuRepository.findById(1L).orElseGet(() -> new Menu("john", "john@domain.com", null, null, null));
		//assertThat(menu.getMainDish().equals("Bob"));
	}*/
}
