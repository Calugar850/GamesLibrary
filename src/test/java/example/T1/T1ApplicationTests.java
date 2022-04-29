package example.T1;

import example.T1.FactoryPattern.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.client.ExpectedCount.times;

@SpringBootTest
class T1ApplicationTests {

	@Mock
	DataSource dataSourceMock;

	@Test
	void contextLoads() {
		FactoryUser factoryUser=new FactoryUser();
		BasicUser basicUser = factoryUser.createBasicUser(Enums.Angajat);
		BasicUser expectedRes= new Angajat(null,null);
		assertEquals("Rezultatul",expectedRes, basicUser);
	}

	@Test
	void test2(){
		when(dataSourceMock.days()).thenReturn(10);
		FactoryUser factoryUser=new FactoryUser();
		BasicUser basicUser = factoryUser.createBasicUser(Enums.Angajat);
		basicUser.data=dataSourceMock;
		int result=basicUser.zile();
		assertEquals("Rezultatul",120,result);
		//verify(dataSourceMock,times(1)).zile();
	}
}
