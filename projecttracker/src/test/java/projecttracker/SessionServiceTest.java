package projecttracker;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import com.projecttracker.service.SessionService;

public class SessionServiceTest {

	@InjectMocks
	private SessionService service;
	@Mock
	HttpServletRequest request;
	@Mock
	HttpSession session;

	@Before
	public void testCreateSession() {
		request = new MockHttpServletRequest();
		
	}

	@Test
	public void testCreateNewSession() { 
		session = request.getSession(true);
		session.setAttribute("user", "amea20");
		assertNotNull(session.getAttribute("user"));
	}
	
	@Test
	public void testCloseSession() { 
		session = request.getSession();
		if (session != null) {
		session.invalidate();
		}
		assertTrue(((MockHttpSession) session).isInvalid());
	}

}
