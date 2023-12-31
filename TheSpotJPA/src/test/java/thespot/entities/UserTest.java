package thespot.entities;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.thespot.entities.User;

class UserTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("TheSpotJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	void testUserMap() {
		assertNotNull(user);
		assertEquals("Brittany", user.getFirstName());
	}
	@Test
	void testUserLastName() {
	
		assertNotNull(user);
		assertEquals("Piacente", user.getLastName());
	}
	
	@Test
	void testPostMap() {
		assertNotNull(user.getPosts());
		assertFalse(user.getPosts().isEmpty());
	}
	
	@Test
	void testCommentMap() {
		user = em.find(User.class,2);
		assertNotNull(user.getComments());
		assertFalse(user.getComments().isEmpty());
	}

}
