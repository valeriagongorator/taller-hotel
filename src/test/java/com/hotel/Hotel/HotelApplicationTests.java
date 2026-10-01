package com.hotel.Hotel;

import com.hotel.Hotel.domain.Cliente;
import com.hotel.Hotel.domain.HabitacionEstandar;
import com.hotel.Hotel.domain.RangoFechas;
import com.hotel.Hotel.domain.Reserva;
import com.hotel.Hotel.repository.ClienteRepository;
import com.hotel.Hotel.repository.HabitacionRepository;
import com.hotel.Hotel.repository.ReservaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class HotelApplicationTests {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private ReservaRepository reservaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCrearReserva() {
		Cliente c = clienteRepository.save(new Cliente("Test", "test" + System.currentTimeMillis() + "@test.com"));
		HabitacionEstandar h = habitacionRepository.save(new HabitacionEstandar("H" + System.currentTimeMillis(), 2, 100.0, 1));
		RangoFechas rf = new RangoFechas(LocalDateTime.of(2026, 10, 1, 10, 0), LocalDateTime.of(2026, 10, 5, 10, 0));
		Reserva r = new Reserva(c, h, rf);
		reservaRepository.save(r);
	}

}

