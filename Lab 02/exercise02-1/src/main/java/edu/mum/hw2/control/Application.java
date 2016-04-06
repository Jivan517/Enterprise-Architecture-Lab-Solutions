package edu.mum.hw2.control;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.mum.hw2.domain.Actor;
import edu.mum.hw2.domain.Category;
import edu.mum.hw2.domain.Movie;
import edu.mum.hw2.domain.Rating;

public class Application {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {

		addMovies();
		printMoviesReport();
		emf.close();
	}

	private static void printMoviesReport() {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			System.out.println("txn Begin");
			
			//Query q = em.createQuery("Select name From Movie");
			List<Movie> movies = em.createQuery("FROM Movie ORDER BY Id").getResultList();

			if (movies != null) {
				
				for (Movie m : movies) {
					System.out.println(m);
				}
			}

			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}

	}

	private static void addMovies() {
		
		System.out.println("Started the session");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Actor actor1 = new Actor();
			actor1.setName("Brad Pitt");
			actor1.setRating(Rating.GOOD);
			actor1.setActorCharacter("soldier charactor in the movie");

			Actor actor2 = new Actor();
			actor2.setName("Leonardo DiCaprio");
			actor2.setRating(Rating.EXCELLENT);
			actor2.setActorCharacter("Lover charactor in the movie");

			Actor actor3 = new Actor();
			actor3.setName("Billy Zane");
			actor3.setRating(Rating.EXCELLENT);
			actor3.setActorCharacter("Calendon Hockley charactor in the movie");

			Movie movie1 = new Movie();
			List<Actor> actorList = new ArrayList<>();
			actorList.add(actor2);
			actorList.add(actor3);

			Set<Category> categories = new HashSet<>();
			categories.add(Category.ROMANCE);
			categories.add(Category.DRAMA);

			List<String> comments = new ArrayList<>();

			comments.add(
					"Firstly and foremostly, I am a guy, which (in most cases) means I did not go see Titanic to see DiCaprio..."
							+ "although I think he can be a great actor."
							+ " Reading through earlier comments, i grew a bit weary of hearing about lame script and shallow characters.");

			comments.add("Superb movie");

			movie1.setActors(actorList);
			movie1.setCategories(categories);
			movie1.setComments(comments);
			movie1.setName("Titanic");
			movie1.setRating(Rating.EXCELLENT);
			
			System.out.println("Before path");
			try{
				Path path = FileSystems.getDefault().getPath("C:/Users/OWNER/Desktop/jivan.jpg");
				movie1.setCover(Files.readAllBytes(path));
				System.out.println("Before Persists");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			em.persist(actor1);
			em.persist(actor2);
			em.persist(actor3);
			em.persist(movie1);
			System.out.println("After Persists");
			tx.commit();
			
			System.out.println("Finished");
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

}
