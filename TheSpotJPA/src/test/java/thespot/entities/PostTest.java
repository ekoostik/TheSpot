package thespot.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.thespot.entities.Post;


class PostTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Post post;

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
		post = em.find(Post.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		post = null;
	}

	@Test
	void testPostMap() {
		assertNotNull(post);
		assertEquals("Welcome post", post.getTitle());
	}
	
	@Test 
	void testUserMap() {
		assertNotNull(post.getUser());
		assertEquals("Brittany", post.getUser().getFirstName());
	}
	@Test
	void testCommentMap() {
		assertNotNull(post.getComments());
		assertFalse(post.getComments().isEmpty());
	}
	@Test
	void testCategoryMap() {
		assertNotNull(post.getCategories());
		assertFalse(post.getCategories().isEmpty());
	}

}
