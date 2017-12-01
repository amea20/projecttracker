package projecttracker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.projecttracker.dao.LoginDAO;
import com.projecttracker.model.User;
import com.projecttracker.service.impl.LoginServiceImpl;

public class LoginServiceImplTest {
	
	
	@Mock
	private LoginDAO loginDAO;
	
	@Spy
	private List<User> users = new ArrayList<>();

	@InjectMocks
	private LoginServiceImpl loginService;
	
	@Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCheckCredentials() {
		String username = "aelagha";
		String password = "password1";
		when(loginDAO.checkCredentials(username, password)).thenReturn(null);
		verify(loginDAO).checkCredentials(username,password);
		assertEquals(null,loginService.checkCredentials(username, password));
		}

	@Test
	public void testCheckPasswordExists() {
		String username = "aelagha";
		String newPassword = "password1";
		when(loginDAO.checkPassword(username, newPassword)).thenReturn(1);
		assertEquals(1,loginService.checkPassword(username, newPassword));
	}

	@Test
	public void testCheckEmailExists() {
		String emailAddress = "amea20@gmail.com";
		when(loginDAO.checkEmailExists(emailAddress)).thenReturn(true);
		assertTrue("User does not exist",loginService.checkEmailExists(emailAddress));
	}

	@Test
	public void testCheckUserCredentials() {
		String username="aelagha";
		String password="password1";
		assertEquals(1,loginDAO.checkUserCredentials(username, password));
	}

}
