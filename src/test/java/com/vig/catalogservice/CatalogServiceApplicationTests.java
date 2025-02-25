package com.vig.catalogservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.vig.catalogservice.domain.Book;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@TestPropertySource(properties = {"polar.greeting=dummy"})
class CatalogServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void whenPostRequestTheBookCreated() {
		var expectedBook = new Book(0L,0,"1234567890", "some", "some", 9.99, Instant.now(), Instant.now());

		webTestClient.post()
			.uri("/books")
			.bodyValue(expectedBook)
			.exchange()
			.expectStatus()
			.isCreated()
			.expectBody(Book.class).value(actualBook -> {
				assertThat(actualBook).isNotNull();
				assertThat(actualBook.isbn()).isEqualTo(expectedBook.isbn());
			});
	}

}
